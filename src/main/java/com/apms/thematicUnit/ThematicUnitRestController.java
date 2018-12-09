package com.apms.thematicUnit;

import com.apms.content.ContentService;
import com.apms.learningEvaluation.LearningEvaluation;
import com.apms.learningEvaluation.LearningEvaluationService;
import com.apms.learningUnit.LearningUnit;
import com.apms.learningUnit.LearningUnitService;
import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;
import com.apms.subtopic.Subtopic;
import com.apms.subtopic.SubtopicService;
import com.apms.topic.Topic;
import com.apms.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/thematicUnit")
public class ThematicUnitRestController {

    @Autowired
    private ThematicUnitService thematicUnitService;

    @Autowired
    private SubtopicService subtopicService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private LearningUnitService learningUnitService;

    @Autowired
    private ContentService contentService;

    @Autowired
    private LearningEvaluationService learningEvaluationService;

    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<ThematicUnit>> getAll() {
        List<ThematicUnit> res;
        try {
            res = thematicUnitService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<List<ThematicUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
                    null);
        }
        if (!res.isEmpty()) {
            return new RESTResponse<List<ThematicUnit>>(RESTResponse.OK, "", res);
        } else {
            return new RESTResponse<List<ThematicUnit>>(RESTResponse.FAIL,
                    "Servicios no disponibles.", null);
        }
    }

    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<ThematicUnit> getOne(@PathVariable Integer id) {
        ThematicUnit res;
        try {
            res = thematicUnitService.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<ThematicUnit>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
            return new RESTResponse<ThematicUnit>(RESTResponse.OK, "", res);
        } else {
            return new RESTResponse<ThematicUnit>(RESTResponse.FAIL, "Unidad tematica no registrada.", null);
        }
    }

    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public RESTResponse<ThematicUnit> post(@RequestBody RESTRequest<ThematicUnit> req) {
        try {
            if (req.getPayload().getTopics() != null) {
                for (int i = 0; i < req.getPayload().getTopics().size(); i++) {
                    if (topicService.getTopicByThematicUnitIdAndName(req.getPayload().getTopics().get(i).getId(), req.getPayload().getTopics().get(i).getName()) != null) {
                        return new RESTResponse<ThematicUnit>(RESTResponse.FAIL, "El tema ya existe en el sistema.", null);
                    }
                    for (int j = 0; j < req.getPayload().getTopics().get(i).getSubtopics().size(); j++) {
                        if (subtopicService.getSubtopicByTopicIdAndName(req.getPayload().getTopics().get(i).getSubtopics().get(j).getId(), req.getPayload().getTopics().get(i).getSubtopics().get(j).getName()) != null) {
                            return new RESTResponse<ThematicUnit>(RESTResponse.FAIL, "El subtema ya existe en el sistema.", null);
                        }
                        req.getPayload().getTopics().get(i).getSubtopics().get(j).setId(subtopicService.add(req.getPayload().getTopics().get(i).getSubtopics().get(j)).getId());
                    }
                    req.getPayload().getTopics().get(i).setId(topicService.add(req.getPayload().getTopics().get(i)).getId());
                }
            }
            List<LearningEvaluation> learningEvaluations = req.getPayload().getLearningEvaluations();
            if (learningEvaluations != null) {
                for (int i = 0; i < req.getPayload().getLearningEvaluations().size(); i++) {
                    req.getPayload().getLearningEvaluations().get(i).setId(learningEvaluationService.add(req.getPayload().getLearningEvaluations().get(i)).getId());
                }
            }
            req.getPayload().getLearningUnit().setId(learningUnitService.add(req.getPayload().getLearningUnit()).getId());
            req.getPayload().getContent().setId(contentService.add(req.getPayload().getContent()).getId());
            thematicUnitService.add(req.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
                    "Por el momento no se puede realizar el registro.", null);
        }
        if (req.getPayload().isFinished()) {
            return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
        }
        else {
            return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Avances guardados exitosamente.", null);
        }
    }

    /*
     ** Update the specified resource in storage partially.
     */
    @PatchMapping
    public RESTResponse<ThematicUnit> patch(@RequestBody RESTRequest<ThematicUnit> req) {
        try {
            if (req.getPayload().getTopics() != null) {
                for (int i = 0; i < req.getPayload().getTopics().size(); i++) {
                    for (int j = 0; j < req.getPayload().getTopics().get(i).getSubtopics().size(); j++) {
                        req.getPayload().getTopics().get(i).getSubtopics().get(j).setId(subtopicService.update(req.getPayload().getTopics().get(i).getSubtopics().get(j)).getId());
                    }
                    req.getPayload().getTopics().get(i).setId(topicService.update(req.getPayload().getTopics().get(i)).getId());
                }
            }
            List<LearningEvaluation> learningEvaluations = req.getPayload().getLearningEvaluations();
            if (learningEvaluations != null) {
                for (int i = 0; i < req.getPayload().getLearningEvaluations().size(); i++) {
                    req.getPayload().getLearningEvaluations().get(i).setId(learningEvaluationService.update(req.getPayload().getLearningEvaluations().get(i)).getId());
                }
            }
            req.getPayload().getLearningUnit().setId(learningUnitService.update(req.getPayload().getLearningUnit()).getId());
            req.getPayload().getContent().setId(contentService.update(req.getPayload().getContent()).getId());
            thematicUnitService.update(req.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        if (req.getPayload().isFinished()) {
            return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
        }
        else {
            return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Avances guardados exitosamente.", null);
        }
    }

    /*
     ** Update the specified resource in storage.
     */
    @PutMapping
    public RESTResponse<ThematicUnit> put(@RequestBody RESTRequest<ThematicUnit> req) {
        try {
            thematicUnitService.update(req.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public RESTResponse<ThematicUnit> delete(@PathVariable Integer id) {
        try {
            thematicUnitService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
                    "Por el momento no se puede realizar el registro.", null);
        }
        return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    @GetMapping("/thematicUnitByLearningUnitId/{id}")
    public RESTResponse<List<ThematicUnit>> thematicUnitByLearningUnitId(@PathVariable Integer id) {
        LearningUnit res;
        try {
            res = learningUnitService.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<List<ThematicUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
            List<ThematicUnit> aux;
            try {
                aux = thematicUnitService.getThematicUnitByLearningUnitId(id);
            } catch (Exception e) {
                e.printStackTrace();
                return new RESTResponse<List<ThematicUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
            }
            if (!aux.isEmpty()) {
                return new RESTResponse<List<ThematicUnit>>(RESTResponse.OK, "", aux);
            } else {
                return new RESTResponse<List<ThematicUnit>>(RESTResponse.OK, "No hay Unidades Temáticas asociadas a esta Unidad de Aprendizaje", null);
            }
        } else {
            return new RESTResponse<List<ThematicUnit>>(RESTResponse.FAIL, "Unidad de Aprendizaje no registrada.", null);
        }
    }
}
