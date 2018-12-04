package com.apms.practiceRelation;

import java.util.List;

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

import com.apms.learningUnit.LearningUnit;
import com.apms.learningUnit.LearningUnitService;

import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;

@RestController
@RequestMapping("/practiceRelation")
public class PracticeRelationRestController {
	
    @Autowired
    private PracticeRelationService practiceRelationService;
	
    @Autowired
    private LearningUnitService learningUnitService;

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
    public RESTResponse<PracticeRelation> post(@RequestBody RESTRequest<PracticeRelation> practiceRelation) {
        try {
            if(practiceRelationService.getOne(practiceRelation.getPayload().getId()) != null)
                return new RESTResponse<PracticeRelation>(RESTResponse.FAIL, "La Relación de Prácticas ya existe en el sistema.", null);
            practiceRelationService.add(practiceRelation.getPayload());
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
    public RESTResponse<PracticeRelation> patch(@RequestBody RESTRequest<PracticeRelation> practiceRelation) {
        try {
            practiceRelationService.update(practiceRelation.getPayload());
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
    public RESTResponse<PracticeRelation> put(@RequestBody RESTRequest<PracticeRelation> practiceRelation) {
        try {
            practiceRelationService.update(practiceRelation.getPayload());
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
