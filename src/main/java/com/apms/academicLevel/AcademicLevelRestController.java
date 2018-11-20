package com.apms.academicLevel;

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
@RequestMapping("/academicLevel")
public class AcademicLevelRestController {
	
    @Autowired
    private AcademicLevelService academicLevelService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
	public RESTResponse<List<AcademicLevel>> getAll() {
		List<AcademicLevel> res;
		try {
			res = academicLevelService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<AcademicLevel>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<AcademicLevel>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<AcademicLevel>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public RESTResponse<AcademicLevel> getOne(@PathVariable Integer id) {
        AcademicLevel res;
        try{
            res = academicLevelService.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<AcademicLevel>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
			return new RESTResponse<AcademicLevel>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<AcademicLevel>(RESTResponse.FAIL, "Nivel academico no registrado.", null);
		}
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public RESTResponse<AcademicLevel> post(@RequestBody RESTRequest<AcademicLevel> academicLevel) {
        try {
        	if(academicLevelService.getOne(academicLevel.getPayload().getId()) != null)
                return new RESTResponse<AcademicLevel>(RESTResponse.FAIL, "Nivel academico ya existe en el sistema.", null);
            academicLevelService.add(academicLevel.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<AcademicLevel>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<AcademicLevel>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
    }

    /*
    **Update the specified resource in storage partially.
    */
    @PatchMapping
    public RESTResponse<AcademicLevel> patch(@RequestBody RESTRequest<AcademicLevel> academicLevel) {
        try {
            academicLevelService.update(academicLevel.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<AcademicLevel>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<AcademicLevel>(RESTResponse.OK, "Nivel academico modificado.", null);
    }

    /*
    **Update the specified resource in storage.
    */
    @PutMapping
    public RESTResponse<AcademicLevel> put(@RequestBody RESTRequest<AcademicLevel> academicLevel) {
        try {
            academicLevelService.update(academicLevel.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<AcademicLevel>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<AcademicLevel>(RESTResponse.OK, "Nivel academico modificado.", null);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public RESTResponse<AcademicLevel> delete(@PathVariable Integer id) {
        try {
            academicLevelService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<AcademicLevel>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<AcademicLevel>(RESTResponse.OK, "Nivel academico modificado.", null);
    }
}
