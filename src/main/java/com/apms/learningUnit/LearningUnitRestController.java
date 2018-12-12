package com.apms.learningUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.apms.bibliographyRelation.BibliographyRelation;
import com.apms.bibliographyRelation.BibliographyRelationService;
import com.apms.document.LearningUnitDocument;
import com.apms.evaluationSystem.EvaluationSystem;
import com.apms.evaluationSystem.EvaluationSystemService;
import com.apms.extensiveProgram.ExtensiveProgram;
import com.apms.extensiveProgram.ExtensiveProgramService;
import com.apms.learningEvaluation.LearningEvaluation;
import com.apms.learningEvaluation.LearningEvaluationService;
import com.apms.learningUnitStatus.LearningUnitStatusService;
import com.apms.practiceRelation.PracticeRelation;
import com.apms.practiceRelation.PracticeRelationService;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apms.rest.RESTRequest;

import java.util.logging.Logger;

import com.apms.rest.RESTResponse;
import com.apms.semester.Semester;
import com.apms.semester.SemesterService;
import com.apms.studyPlan.StudyPlan;
import com.apms.studyPlan.StudyPlanService;
import com.apms.syntheticProgram.SyntheticProgram;
import com.apms.syntheticProgram.SyntheticProgramService;
import com.apms.thematicUnit.ThematicUnit;
import com.apms.thematicUnit.ThematicUnitService;

@RestController
@RequestMapping("/learningUnit")
public class LearningUnitRestController {

    @Autowired
    private LearningUnitService learningUnitService;

    @Autowired
    private SemesterService semesterService;

    @Autowired
    private LearningUnitStatusService learningUnitStatusService;

    @Autowired
    private SyntheticProgramService syntheticProgramService;

    @Autowired
    private StudyPlanService studyPlanService;

    @Autowired
    private ExtensiveProgramService extensiveProgramService;

    @Autowired
    private BibliographyRelationService bibliographyRelationService;

    @Autowired
    private PracticeRelationService practiceRelationService;

    @Autowired
    private ThematicUnitService thematicUnitService;
    
    @Autowired EvaluationSystemService evaluationSystemService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<LearningUnit>> getAll() {
        List<LearningUnit> res;
        try {
            res = learningUnitService.getAll();
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
                    null);
        }
        if (!res.isEmpty()) {
            return new RESTResponse<List<LearningUnit>>(RESTResponse.OK, "", res);
        } else {
            return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
        }
    }

    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<LearningUnit> getOne(@PathVariable Integer id) {
        LearningUnit res;
        try {
            res = learningUnitService.getOne(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<LearningUnit>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
            return new RESTResponse<LearningUnit>(RESTResponse.OK, "", res);
        } else {
            return new RESTResponse<LearningUnit>(RESTResponse.FAIL, "Unidad de apredizaje no registrada.", null);
        }
    }

    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public RESTResponse<LearningUnit> post(@RequestBody RESTRequest<LearningUnit> req) {
        try {
            if (!learningUnitService.getLearningUnitByNameAndStudyPlanId(req.getPayload().getName(),
                    req.getPayload().getSemester().getStudyPlan().getId()).isEmpty())
                return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
                        "Unidad de Aprendizaje ya existe en el sistema.", null);
            req.getPayload().setLearningUnitStatus(learningUnitStatusService.getOne(req.getPayload().getLearningUnitStatus().getId()));
            learningUnitService.add(req.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<LearningUnit>(RESTResponse.FAIL, "Por el momento no se puede realizar el registro.",
                    null);
        }
        return new RESTResponse<LearningUnit>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
    }

    /*
     ** Update the specified resource in storage partially.
     */
    @PatchMapping
    public RESTResponse<LearningUnit> patch(@RequestBody RESTRequest<LearningUnit> req) {
        try {
            LearningUnit dbLearningUnitById = learningUnitService.getOne(req.getPayload().getId());
            if (!req.getPayload().getName().equalsIgnoreCase(dbLearningUnitById.getName())) {
                if (learningUnitService.getLearningUnitByNameAndStudyPlanId(req.getPayload().getName(),
                        req.getPayload().getSemester().getStudyPlan().getId()) != null)
                    return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
                            "Unidad de Aprendizaje ya existe en el sistema.", null);
            }
            learningUnitService.update(req.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    /*
     ** Update the specified resource in storage.
     */
    @PutMapping
    public RESTResponse<LearningUnit> put(@RequestBody RESTRequest<LearningUnit> req) {
        try {
            LearningUnit dbLearningUnitById = learningUnitService.getOne(req.getPayload().getId());
            if (!req.getPayload().getName().equalsIgnoreCase(dbLearningUnitById.getName())) {
                if (learningUnitService.getLearningUnitByNameAndStudyPlanId(req.getPayload().getName(),
                        req.getPayload().getSemester().getStudyPlan().getId()) != null)
                    return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
                            "Unidad de Aprendizaje ya existe en el sistema.", null);
            }
            learningUnitService.update(req.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public RESTResponse<LearningUnit> delete(@PathVariable Integer id) {
        try {
            learningUnitService.delete(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<LearningUnit>(RESTResponse.FAIL, "Por el momento no se puede realizar el registro.",
                    null);
        }
        return new RESTResponse<LearningUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    @GetMapping("/learningUnitsBySemesterId/{id}")
    public RESTResponse<List<LearningUnit>> getLearningUnitsBySemesterId(@PathVariable Integer id) {
        Semester res;
        try {
            res = semesterService.getOne(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
                    null);
        }
        if (res != null) {
            List<LearningUnit> aux;
            try {
                aux = learningUnitService.getLearningUnitsBySemesterId(id);
            } catch (Exception e) {
                Logger.getLogger(null).log(null, "F: ", e);
                return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
                        null);
            }
            if (!aux.isEmpty()) {
                return new RESTResponse<List<LearningUnit>>(RESTResponse.OK, "", aux);
            } else {
                return new RESTResponse<List<LearningUnit>>(RESTResponse.OK,
                        "El semestre no cuenta con unidades de aprendizaje.", aux);
            }
        } else {
            return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL, "Semestre no registrado.", null);
        }
    }

    @GetMapping("/learningUnitByNameAndSemesterId/{name}/{id}")
    public RESTResponse<List<LearningUnit>> learningUnitByNameAndSemesterId(@PathVariable String name,
                                                                            @PathVariable Integer id) {
        List<LearningUnit> res;
        try {
            res = learningUnitService.getLearningUnitByNameAndSemesterId(name, id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
                    null);
        }
        if (!res.isEmpty()) {
            return new RESTResponse<List<LearningUnit>>(RESTResponse.OK, "", res);
        } else {
            return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
        }
    }

    @GetMapping("/learningUnitByNameAndStudyPlanId/{name}/{id}")
    public RESTResponse<List<LearningUnit>> learningUnitByNameAndStudyPlanId(@PathVariable String name,
                                                                             @PathVariable Integer id) {
        List<LearningUnit> res;
        try {
            res = learningUnitService.getLearningUnitByNameAndStudyPlanId(name, id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
                    null);
        }
        if (!res.isEmpty()) {
            return new RESTResponse<List<LearningUnit>>(RESTResponse.OK, "", res);
        } else {
            return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
        }
    }

    @GetMapping("/changeLearningUnitToSemester/{learningUnitId}/{semesterId}")
    public RESTResponse<LearningUnit> changeLearningUnitToSemester(@PathVariable Integer learningUnitId,
                                                                   @PathVariable Integer semesterId) {
        Semester semester;
        LearningUnit res;
        try {
            semester = semesterService.getOne(semesterId);
            res = learningUnitService.getOne(learningUnitId);
            res.setSemester(semester);
            learningUnitService.update(res);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    @PatchMapping("/finish")
    public RESTResponse<LearningUnit> learningUnitFinished(@RequestBody RESTRequest<LearningUnit> req) {
        LearningUnit learningUnit;
        try {
            learningUnit = learningUnitService.getOne(req.getPayload().getId());
            if (learningUnit.isFinishSynteicProgram() &&
                    learningUnit.isFinishExtensiveProgram() &&
                    learningUnit.isFinishThematicUnit() &&
                    learningUnit.isFinishPracticeRelation() &&
                    learningUnit.isFinishEvaluationSystem() &&
                    learningUnit.isFinishAuthorizations()){
                learningUnit.setLearningUnitStatus(learningUnitStatusService.getOne(4));
                learningUnitService.update(learningUnit);
            }
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        if(learningUnit.getLearningUnitStatus().getId() == 4)
            return new RESTResponse<LearningUnit>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
        else
            return new RESTResponse<LearningUnit>(RESTResponse.FAIL, "Registro incompleto.", null);
    }

    @GetMapping("/isFinished/{id}")
    public RESTResponse<Boolean> getFinished(@PathVariable Integer id) {
        LearningUnit res;
        try {
            res = learningUnitService.getOne(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<Boolean>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res.getLearningUnitStatus().getId() == 4) {
            return new RESTResponse<Boolean>(RESTResponse.OK, "Unidad de aprendizaje " + res.getLearningUnitStatus().getName(), true);
        } else {
            return new RESTResponse<Boolean>(RESTResponse.OK, "Unidad de apredizaje " + res.getLearningUnitStatus().getName(), false);
        }
    }

    @PatchMapping("/inProcess")
    public RESTResponse<LearningUnit> learningUnitInProcess(@RequestBody RESTRequest<LearningUnit> req) {
        try {
            LearningUnit learningUnit = learningUnitService.getOne(req.getPayload().getId());
            learningUnit.setLearningUnitStatus(learningUnitStatusService.getOne(3));
            learningUnitService.update(learningUnit);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnit>(RESTResponse.OK, "", null);
    }

    @GetMapping("learningUnit/inProcess/{id}")
    public RESTResponse<Boolean> getInProcess(@PathVariable Integer id) {
        LearningUnit res;
        try {
            res = learningUnitService.getOne(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<Boolean>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res.getLearningUnitStatus().getId() == 3) {
            return new RESTResponse<Boolean>(RESTResponse.OK, "Unidad de aprendizaje " + res.getLearningUnitStatus().getName(), true);
        } else {
            return new RESTResponse<Boolean>(RESTResponse.OK, "Unidad de apredizaje " + res.getLearningUnitStatus().getName(), false);
        }
    }

    @GetMapping("/generatePDF/{learningUnitId}")
    public ResponseEntity<InputStreamResource> generatePDF(@PathVariable Integer learningUnitId) throws IOException {
        LearningUnitDocument document;
        try {
        	//ProgramaSintetico
        	SyntheticProgram syntheticProgram = null;
        	try {
        		syntheticProgram = syntheticProgramService.getSyntheticProgramsByLearningUnitId(learningUnitId);
        	}catch(NullPointerException e) {
        		syntheticProgram = null;
        	}
        	//PlanDeEstudios
        	StudyPlan studyPlan = null;
        	try {
        		studyPlan = studyPlanService.getStudyPlanByLearningUnitId(learningUnitId);
        	}catch(NullPointerException e) {
        		studyPlan = null;
        	}
        	
            ExtensiveProgram extensiveProgram = null;
            try {
            	extensiveProgram = extensiveProgramService.getExtensiveProgramByLearningUnitId(learningUnitId);
        	}catch(NullPointerException e) {
        		extensiveProgram = null;
        	}
            
            List<BibliographyRelation> bibliographyRelations = null;
            try {
            	bibliographyRelations = bibliographyRelationService.getBibliographyRelationByLearningUnitId(learningUnitId);
        	}catch(NullPointerException e) {
        		bibliographyRelations = null;
        	}
            //Obtener Unidades Tematicas con sus evaluaciones
            List<ThematicUnit> thematicUnits = null;
            try {
            	thematicUnits = thematicUnitService.getThematicUnitByLearningUnitId(learningUnitId);
        	}catch(NullPointerException e) {
        		thematicUnits = null;
        	}
            
            List<EvaluationSystem> evaluationSystems = new ArrayList<>();
            try {
            	for (ThematicUnit thematicUnit : thematicUnits) {
                	EvaluationSystem evaluationSystem = evaluationSystemService.getEvaluationSystemByThematicUnitId(thematicUnit.getId());
                	if(evaluationSystem != null)
                		evaluationSystems.add(evaluationSystem);
                }
            }catch(NullPointerException e) {
            	evaluationSystems = null;
        	}
            
            PracticeRelation practiceRelation = null;
            try {
            	practiceRelation = practiceRelationService.getPracticeRelationsByLearningUnitId(learningUnitId);
        	}catch(NullPointerException e) {
        		practiceRelation = null;
        	}
            document = new LearningUnitDocument(syntheticProgram, studyPlan, extensiveProgram, bibliographyRelations, thematicUnits, evaluationSystems, practiceRelation);
            document.createDocument();
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return null;
        }
        ClassPathResource pdfFile = new ClassPathResource("document_latex/FormatoUnidadAcademica.pdf");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(pdfFile.contentLength())
                .contentType(
                        MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(pdfFile.getInputStream()));
    }
}
