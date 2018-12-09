package com.apms.academy;

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
@RequestMapping("/academy")
public class AcademyRestController {
	
    @Autowired
    private AcademyService academyService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
	public RESTResponse<List<Academy>> getAll() {
		List<Academy> res;
		try {
			res = academyService.getAll();
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<Academy>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Academy>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Academy>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.", null);
		}
	}

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public RESTResponse<Academy> getOne(@PathVariable Integer id) {
        Academy res;
        try{
            res = academyService.getOne(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null,"F: ",e);
            return new RESTResponse<Academy>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
			return new RESTResponse<Academy>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Academy>(RESTResponse.FAIL, "Academia no registrado.", null);
		}
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public RESTResponse<Academy> post(@RequestBody RESTRequest<Academy> academy) {
        try {
            if(academyService.getOne(academy.getPayload().getId()) != null)
                return new RESTResponse<Academy>(RESTResponse.FAIL, "Academia ya existe en el sistema.", null);
            academyService.add(academy.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null,"F: ",e);
            return new RESTResponse<Academy>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<Academy>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
    }

    /*
    **Update the specified resource in storage partially.
    */
    @PatchMapping
    public RESTResponse<Academy> patch(@RequestBody RESTRequest<Academy> academy) {
        try {
            academyService.update(academy.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null,"F: ",e);
            return new RESTResponse<Academy>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<Academy>(RESTResponse.OK, "Academia modificado.", null);
    }

    /*
    **Update the specified resource in storage.
    */
    @PutMapping
    public RESTResponse<Academy> put(@RequestBody RESTRequest<Academy> academy) {
        try {
            academyService.update(academy.getPayload());
        } catch (Exception e) {
            Logger.getLogger(null).log(null,"F: ",e);
            return new RESTResponse<Academy>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<Academy>(RESTResponse.OK, "Academia modificado.", null);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public RESTResponse<Academy> delete(@PathVariable Integer id) {
        try {
            academyService.delete(id);
        } catch (Exception e) {
            Logger.getLogger(null).log(null,"F: ",e);
            return new RESTResponse<Academy>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<Academy>(RESTResponse.OK, "Academia modificado.", null);
    }
}
