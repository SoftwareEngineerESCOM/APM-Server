package com.apms.authorizations;

import com.apms.learningUnit.LearningUnit;
import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apms.syntheticProgram.SyntheticProgram;
import com.apms.syntheticProgram.SyntheticProgramService;

import java.util.List;
import java.util.Map;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/authorizations")
public class AuthorizationsRestController {
	
    @Autowired
    private AuthorizationsService authorizationsService;

    @Autowired
    private SyntheticProgramService syntheticProgramService;

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
    public RESTResponse<Authorizations> post(@RequestBody Map<String,JsonNode> req) throws JsonProcessingException {
	    ObjectMapper mapper = new ObjectMapper();
		Authorizations authorizations = mapper.treeToValue(req.get("authorizations"),Authorizations.class);
        SyntheticProgram syntheticProgram = syntheticProgramService.getSyntheticProgramsByLearningUnitId(authorizations.getSyntheticProgram().getLearningUnit().getId());
        authorizations.setSyntheticProgram(syntheticProgram);
        try {
            if(authorizationsService.getOne(authorizations.getId()) != null)
                return new RESTResponse<Authorizations>(RESTResponse.FAIL, "Authorizations ya existe en el sistema.", null);

		authorizationsService.add(authorizations);
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
