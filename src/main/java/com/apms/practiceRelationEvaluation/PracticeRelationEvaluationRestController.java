package com.apms.practiceRelationEvaluation;

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

import com.apms.rest.RESTRequest;import java.util.logging.Logger;
import com.apms.rest.RESTResponse;

@RestController
@RequestMapping("/practiceRelationEvaluation")
public class PracticeRelationEvaluationRestController {
	
    @Autowired
    private PracticeRelationEvaluationService practiceRelationEvaluationService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
	public RESTResponse<List<PracticeRelationEvaluation>> getAll() {
		List<PracticeRelationEvaluation> res;
		try {
			res = practiceRelationEvaluationService.getAll();
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<PracticeRelationEvaluation>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<PracticeRelationEvaluation>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<PracticeRelationEvaluation>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.", null);
		}
	}

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public RESTResponse<PracticeRelationEvaluation> getOne(@PathVariable Integer id) {
        PracticeRelationEvaluation res;
        try{
            res = practiceRelationEvaluationService.getOne(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null,"F: ",e);
            return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
			return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.FAIL, "PracticeRelationEvaluation no registrado.", null);
		}
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public RESTResponse<PracticeRelationEvaluation> post(@RequestBody RESTRequest<PracticeRelationEvaluation> practiceRelationEvaluation) {
        try {
            if(practiceRelationEvaluationService.getOne(practiceRelationEvaluation.getPayload().getId()) != null)
                return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.FAIL, "PracticeRelationEvaluation ya existe en el sistema.", null);
            practiceRelationEvaluationService.add(practiceRelationEvaluation.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null,"F: ",e);
            return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
    }

    /*
    **Update the specified resource in storage partially.
    */
    @PatchMapping
    public RESTResponse<PracticeRelationEvaluation> patch(@RequestBody RESTRequest<PracticeRelationEvaluation> practiceRelationEvaluation) {
        try {
            practiceRelationEvaluationService.update(practiceRelationEvaluation.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null,"F: ",e);
            return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.OK, "PracticeRelationEvaluation modificado.", null);
    }

    /*
    **Update the specified resource in storage.
    */
    @PutMapping
    public RESTResponse<PracticeRelationEvaluation> put(@RequestBody RESTRequest<PracticeRelationEvaluation> practiceRelationEvaluation) {
        try {
            practiceRelationEvaluationService.update(practiceRelationEvaluation.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null,"F: ",e);
            return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.OK, "PracticeRelationEvaluation modificado.", null);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public RESTResponse<PracticeRelationEvaluation> delete(@PathVariable Integer id) {
        try {
            practiceRelationEvaluationService.delete(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null,"F: ",e);
            return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<PracticeRelationEvaluation>(RESTResponse.OK, "PracticeRelationEvaluation modificado.", null);
    }
}
