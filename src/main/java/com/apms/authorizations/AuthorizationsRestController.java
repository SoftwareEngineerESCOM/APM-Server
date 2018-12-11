package com.apms.authorizations;

import com.apms.academy.Academy;
import com.apms.humanResource.HumanResource;
import com.apms.learningUnit.LearningUnit;
import com.apms.learningUnit.LearningUnitService;
import com.apms.rest.RESTRequest;import java.util.logging.Logger;
import com.apms.rest.RESTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apms.syntheticProgram.SyntheticProgram;
import com.apms.syntheticProgram.SyntheticProgramService;

import java.util.List;
import java.util.Map;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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

    @Autowired
    private LearningUnitService learningUnitService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
	public RESTResponse<List<Authorizations>> getAll() {
		List<Authorizations> res;
		try {
			res = authorizationsService.getAll();
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
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
            Logger.getLogger(null).log(null,"F: ",e);
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
    public RESTResponse<Authorizations> post(@RequestBody Map<String,JsonNode> req) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Academy elaboratedBy = mapper.treeToValue(req.get("elaboratedBy"),Academy.class);
            HumanResource revisedBy = 	mapper.treeToValue(req.get("revisedBy"),HumanResource.class);
            HumanResource authorizedBy = mapper.treeToValue(req.get("authorizedBy"),HumanResource.class);
            HumanResource approvedBy = mapper.treeToValue(req.get("approvedBy"),HumanResource.class);
            SyntheticProgram s = mapper.treeToValue(req.get("syntheticProgram"),SyntheticProgram.class);
            LearningUnit learningUnit = learningUnitService.getOne(s.getLearningUnit().getId());
            learningUnit.setFinishAuthorizations(true);
            learningUnit = learningUnitService.update(learningUnit);
            SyntheticProgram s1 = syntheticProgramService.getSyntheticProgramsByLearningUnitId(learningUnit.getId());
        	authorizationsService.add(new Authorizations(elaboratedBy,revisedBy,authorizedBy,approvedBy,s1));
        } catch (Exception e) {
            Logger.getLogger(null).log(null,"F: ",e);
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
            Logger.getLogger(null).log(null,"F: ",e);
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
            Logger.getLogger(null).log(null,"F: ",e);
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
            Logger.getLogger(null).log(null,"F: ",e);
            return new RESTResponse<Authorizations>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<Authorizations>(RESTResponse.OK, "Authorizations modificado.", null);
    }
}
