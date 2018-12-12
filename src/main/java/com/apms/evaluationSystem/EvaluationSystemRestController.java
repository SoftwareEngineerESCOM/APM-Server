package com.apms.evaluationSystem;

import java.util.Iterator;
import java.util.List;

import com.apms.learningUnit.LearningUnit;
import com.apms.learningUnit.LearningUnitService;
import com.apms.thematicUnit.ThematicUnit;
import com.apms.thematicUnit.ThematicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apms.rest.RESTRequest;

import java.util.logging.Logger;

import com.apms.rest.RESTResponse;

@RestController
@RequestMapping("/evaluationSystem")
public class EvaluationSystemRestController {

    @Autowired
    private EvaluationSystemService evaluationSystemService;

    @Autowired
    private LearningUnitService learningUnitService;

    @Autowired
    private ThematicUnitService thematicUnitService;

    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<EvaluationSystem>> getAll() {
        List<EvaluationSystem> res;
        try {
            res = evaluationSystemService.getAll();
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<List<EvaluationSystem>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
                    null);
        }
        if (!res.isEmpty()) {
            return new RESTResponse<List<EvaluationSystem>>(RESTResponse.OK, "", res);
        } else {
            return new RESTResponse<List<EvaluationSystem>>(RESTResponse.FAIL,
                    "Servicios no disponibles.", null);
        }
    }

    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<EvaluationSystem> getOne(@PathVariable Integer id) {
        EvaluationSystem res;
        try {
            res = evaluationSystemService.getOne(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<EvaluationSystem>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
            return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "", res);
        } else {
            return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL, "Sistema de evaluacion no registrado.", null);
        }
    }

    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public RESTResponse<EvaluationSystem> post(@RequestBody RESTRequest<EvaluationSystem> req) {
        try {
            if (evaluationSystemService.getOne(req.getPayload().getId()) != null)
                return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL, "El sistema de evaluacion ya existe en el sistema.", null);
            evaluationSystemService.add(req.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL,
                    "Por el momento no se puede realizar el registro.", null);
        }
        if (req.getPayload().isFinished()) {
            return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
        } else {
            return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Avances guardados exitosamente.", null);
        }
    }

    /*
     ** Update the specified resource in storage partially.
     */
    @PatchMapping
    public RESTResponse<EvaluationSystem> patch(@RequestBody RESTRequest<EvaluationSystem> req) {
        try {
            evaluationSystemService.update(req.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        if (req.getPayload().isFinished()) {
            return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
        } else {
            return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Avances guardados exitosamente.", null);
        }
    }

    /*
     ** Update the specified resource in storage.
     */
    @PutMapping
    public RESTResponse<EvaluationSystem> put(@RequestBody RESTRequest<EvaluationSystem> req) {
        try {
            evaluationSystemService.update(req.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public RESTResponse<EvaluationSystem> delete(@PathVariable Integer id) {
        try {
            evaluationSystemService.delete(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL,
                    "Por el momento no se puede realizar el registro.", null);
        }
        return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    @GetMapping("getEvaluationSystemByThematicUnitId/{id}")
    public RESTResponse<EvaluationSystem> getEvaluationSystemByThematicUnitId(@PathVariable Integer id) {
        EvaluationSystem res;
        try {
            res = evaluationSystemService.getEvaluationSystemByThematicUnitId(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<EvaluationSystem>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
            return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "", res);
        } else {
            return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL, "", null);
        }
    }

    @PatchMapping("/finish")
    public RESTResponse<EvaluationSystem> learningUnitFinished(@RequestBody RESTRequest<EvaluationSystem> req) {
        boolean aux = true;
        try {
            List<ThematicUnit> thematicUnitList = thematicUnitService.getThematicUnitByLearningUnitId(req.getPayload().getThematicUnit().getLearningUnit().getId());
            for (Iterator<ThematicUnit> thematicUnitIterator = thematicUnitList.iterator(); thematicUnitIterator.hasNext(); ) {
                aux = aux && evaluationSystemService.getEvaluationSystemByThematicUnitId(thematicUnitIterator.next().getId()).isFinished();
            }
            if (aux) {
                LearningUnit learningUnit = learningUnitService.getOne(req.getPayload().getThematicUnit().getLearningUnit().getId());
                learningUnit.setFinishEvaluationSystem(true);
                learningUnitService.update(learningUnit);
            }
        } catch (Exception e) {
            Logger.getLogger(null).log(null, "F: ", e);
            return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL,
                    "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        if (aux) {
            return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
        }
        else {
            return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Avances guardados exitosamente.", null);
        }
    }
}
