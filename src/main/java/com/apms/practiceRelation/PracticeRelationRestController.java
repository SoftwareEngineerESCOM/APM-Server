package com.apms.practiceRelation;

import com.apms.learningUnit.LearningUnit;
import com.apms.learningUnit.LearningUnitService;
import com.apms.practice.PracticeService;
import com.apms.practiceRelationEvaluation.PracticeRelationEvaluationService;
import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practiceRelation")
public class PracticeRelationRestController {
	
    @Autowired
    private PracticeRelationService practiceRelationService;
	
    @Autowired
    private LearningUnitService learningUnitService;

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private PracticeRelationEvaluationService practiceRelationEvaluationService;

    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<PracticeRelation>> getAll() {
        List<PracticeRelation> res;
        try {
            res = practiceRelationService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<List<PracticeRelation>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
                    null);
        }
        if (!res.isEmpty()) {
            return new RESTResponse<List<PracticeRelation>>(RESTResponse.OK, "", res);
        } else {
            return new RESTResponse<List<PracticeRelation>>(RESTResponse.FAIL,
                    "Servicios no disponibles.", null);
        }
    }

    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<PracticeRelation> getOne(@PathVariable Integer id) {
        PracticeRelation res;
        try {
            res = practiceRelationService.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<PracticeRelation>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
                    null);
        }
        if (res != null) {
            return new RESTResponse<PracticeRelation>(RESTResponse.OK, "", res);
        } else {
            return new RESTResponse<PracticeRelation>(RESTResponse.FAIL, "Relación de Prácticas no registrada.", null);
        }
    }

    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public RESTResponse<PracticeRelation> post(@RequestBody RESTRequest<PracticeRelation> req) {
        try {
            if (practiceRelationService.getOne(req.getPayload().getId()) != null)
                return new RESTResponse<PracticeRelation>(RESTResponse.FAIL, "La Relación de Prácticas ya existe en el sistema.", null);

            if (req.getPayload().getPractices() != null) {
                for (int i = 0; i < req.getPayload().getPractices().size(); i++) {
                    req.getPayload().getPractices().get(i).setId(practiceService.add(req.getPayload().getPractices().get(i)).getId());
                }
            }
            if (req.getPayload().getPracticeRelationEvaluations() != null){
                for (int i = 0; i < req.getPayload().getPracticeRelationEvaluations().size(); i++) {
                    req.getPayload().getPracticeRelationEvaluations().get(i).setId(practiceRelationEvaluationService.add(req.getPayload().getPracticeRelationEvaluations().get(i)).getId());
                }
            }
            practiceRelationService.add(req.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<PracticeRelation>(RESTResponse.FAIL,
                    "Por el momento no se puede realizar el registro.", null);
        }
        return new RESTResponse<PracticeRelation>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
    }

    /*
     ** Update the specified resource in storage partially.
     */
    @PatchMapping
    public RESTResponse<PracticeRelation> patch(@RequestBody RESTRequest<PracticeRelation> req) {
        try {
            practiceRelationService.update(req.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<PracticeRelation>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<PracticeRelation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    /*
     ** Update the specified resource in storage.
     */
    @PutMapping
    public RESTResponse<PracticeRelation> put(@RequestBody RESTRequest<PracticeRelation> req) {
        try {
            practiceRelationService.update(req.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<PracticeRelation>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<PracticeRelation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public RESTResponse<PracticeRelation> delete(@PathVariable Integer id) {
        try {
            practiceRelationService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<PracticeRelation>(RESTResponse.FAIL,
                    "Por el momento no se puede realizar el registro.", null);
        }
        return new RESTResponse<PracticeRelation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    @GetMapping("/practiceRelationsByLearningUnitId/{id}")
    public RESTResponse<PracticeRelation> practiceRelationsByLearningUnitId(@PathVariable Integer id) {
        LearningUnit res;
        try {
            res = learningUnitService.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<PracticeRelation>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
            PracticeRelation aux;
            try {
                aux = practiceRelationService.getPracticeRelationsByLearningUnitId(id);
            } catch (Exception e) {
                e.printStackTrace();
                return new RESTResponse<PracticeRelation>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
            }
            if (aux != null) {
                return new RESTResponse<PracticeRelation>(RESTResponse.OK, "", aux);
            } else {
                return new RESTResponse<PracticeRelation>(RESTResponse.FAIL, "No hay Programa Sintético asociado a esta Unidad de Aprendizaje", null);
            }
        } else {
            return new RESTResponse<PracticeRelation>(RESTResponse.FAIL, "Unidad de Aprendizaje no registrada.", null);
        }
    }
}
