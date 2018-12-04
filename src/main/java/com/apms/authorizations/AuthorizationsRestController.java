package com.apms.authorizations;

import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorizations")
public class AuthorizationsRestController {
	
    @Autowired
    private AuthorizationsService authorizationsService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
	public RESTResponse<List<Authorizations>> getAll() {
		List<Authorizations> res;
		try {
			res = authorizationsService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Authorizations>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Authorizations>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Authorizations>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.", null);
		}
	}

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public RESTResponse<Authorizations> getOne(@PathVariable Integer id) {
        Authorizations res;
        try{
            res = authorizationsService.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<Authorizations>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
			return new RESTResponse<Authorizations>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Authorizations>(RESTResponse.FAIL, "Authorizations no registrado.", null);
		}
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public RESTResponse<Authorizations> post(@RequestBody RESTRequest<Authorizations> authorizations) {
        try {
            if(authorizationsService.getOne(authorizations.getPayload().getId()) != null)
                return new RESTResponse<Authorizations>(RESTResponse.FAIL, "Authorizations ya existe en el sistema.", null);
            authorizationsService.add(authorizations.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<Authorizations>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<Authorizations>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
    }

    /*
    **Update the specified resource in storage partially.
    */
    @PatchMapping
    public RESTResponse<Authorizations> patch(@RequestBody RESTRequest<Authorizations> authorizations) {
        try {
            authorizationsService.update(authorizations.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<Authorizations>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<Authorizations>(RESTResponse.OK, "Authorizations modificado.", null);
    }

    /*
    **Update the specified resource in storage.
    */
    @PutMapping
    public RESTResponse<Authorizations> put(@RequestBody RESTRequest<Authorizations> authorizations) {
        try {
            authorizationsService.update(authorizations.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<Authorizations>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<Authorizations>(RESTResponse.OK, "Authorizations modificado.", null);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public RESTResponse<Authorizations> delete(@PathVariable Integer id) {
        try {
            authorizationsService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<Authorizations>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<Authorizations>(RESTResponse.OK, "Authorizations modificado.", null);
    }
}
