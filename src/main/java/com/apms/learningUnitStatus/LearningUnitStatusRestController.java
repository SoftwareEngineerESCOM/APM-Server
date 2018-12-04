package com.apms.learningUnitStatus;

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

import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;

@RestController
@RequestMapping("/learningUnitStatus")
public class LearningUnitStatusRestController {
	
    @Autowired
    private LearningUnitStatusService learningUnitStatusService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
	public RESTResponse<List<LearningUnitStatus>> getAll() {
		List<LearningUnitStatus> res;
		try {
			res = learningUnitStatusService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<LearningUnitStatus>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<LearningUnitStatus>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<LearningUnitStatus>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.", null);
		}
	}

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public RESTResponse<LearningUnitStatus> getOne(@PathVariable Integer id) {
        LearningUnitStatus res;
        try{
            res = learningUnitStatusService.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<LearningUnitStatus>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
			return new RESTResponse<LearningUnitStatus>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<LearningUnitStatus>(RESTResponse.FAIL, "LearningUnitStatus no registrado.", null);
		}
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public RESTResponse<LearningUnitStatus> post(@RequestBody RESTRequest<LearningUnitStatus> learningUnitStatus) {
        try {
            if(learningUnitStatusService.getOne(learningUnitStatus.getPayload().getId()) != null)
                return new RESTResponse<LearningUnitStatus>(RESTResponse.FAIL, "LearningUnitStatus ya existe en el sistema.", null);
            learningUnitStatusService.add(learningUnitStatus.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<LearningUnitStatus>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnitStatus>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
    }

    /*
    **Update the specified resource in storage partially.
    */
    @PatchMapping
    public RESTResponse<LearningUnitStatus> patch(@RequestBody RESTRequest<LearningUnitStatus> learningUnitStatus) {
        try {
            learningUnitStatusService.update(learningUnitStatus.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<LearningUnitStatus>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnitStatus>(RESTResponse.OK, "LearningUnitStatus modificado.", null);
    }

    /*
    **Update the specified resource in storage.
    */
    @PutMapping
    public RESTResponse<LearningUnitStatus> put(@RequestBody RESTRequest<LearningUnitStatus> learningUnitStatus) {
        try {
            learningUnitStatusService.update(learningUnitStatus.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<LearningUnitStatus>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnitStatus>(RESTResponse.OK, "LearningUnitStatus modificado.", null);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public RESTResponse<LearningUnitStatus> delete(@PathVariable Integer id) {
        try {
            learningUnitStatusService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<LearningUnitStatus>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnitStatus>(RESTResponse.OK, "LearningUnitStatus modificado.", null);
    }
}
