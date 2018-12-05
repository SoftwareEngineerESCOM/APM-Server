package com.apms.learningUnitTask;

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
@RequestMapping("/learningUnitTask")
public class LearningUnitTaskRestController {
	
    @Autowired
    private LearningUnitTaskService learningUnitTaskService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
	public RESTResponse<List<LearningUnitTask>> getAll() {
		List<LearningUnitTask> res;
		try {
			res = learningUnitTaskService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<LearningUnitTask>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<LearningUnitTask>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<LearningUnitTask>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.", null);
		}
	}

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public RESTResponse<LearningUnitTask> getOne(@PathVariable Integer id) {
        LearningUnitTask res;
        try{
            res = learningUnitTaskService.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<LearningUnitTask>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
			return new RESTResponse<LearningUnitTask>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<LearningUnitTask>(RESTResponse.FAIL, "LearningUnitTask no registrado.", null);
		}
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public RESTResponse<LearningUnitTask> post(@RequestBody RESTRequest<LearningUnitTask> learningUnitTask) {
        try {
            if(learningUnitTaskService.getOne(learningUnitTask.getPayload().getId()) != null)
                return new RESTResponse<LearningUnitTask>(RESTResponse.FAIL, "LearningUnitTask ya existe en el sistema.", null);
            learningUnitTaskService.add(learningUnitTask.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<LearningUnitTask>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnitTask>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
    }

    /*
    **Update the specified resource in storage partially.
    */
    @PatchMapping
    public RESTResponse<LearningUnitTask> patch(@RequestBody RESTRequest<LearningUnitTask> learningUnitTask) {
        try {
            learningUnitTaskService.update(learningUnitTask.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<LearningUnitTask>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnitTask>(RESTResponse.OK, "LearningUnitTask modificado.", null);
    }

    /*
    **Update the specified resource in storage.
    */
    @PutMapping
    public RESTResponse<LearningUnitTask> put(@RequestBody RESTRequest<LearningUnitTask> learningUnitTask) {
        try {
            learningUnitTaskService.update(learningUnitTask.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<LearningUnitTask>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnitTask>(RESTResponse.OK, "LearningUnitTask modificado.", null);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public RESTResponse<LearningUnitTask> delete(@PathVariable Integer id) {
        try {
            learningUnitTaskService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<LearningUnitTask>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<LearningUnitTask>(RESTResponse.OK, "LearningUnitTask modificado.", null);
    }
}