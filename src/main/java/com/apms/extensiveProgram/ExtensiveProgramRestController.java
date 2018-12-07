package com.apms.extensiveProgram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.ManyToMany;

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

import com.apms.ability.Ability;
import com.apms.ability.AbilityService;
import com.apms.academicLevel.AcademicLevel;
import com.apms.academicLevel.AcademicLevelService;
import com.apms.accreditationType.AccreditationType;
import com.apms.assignedTime.AssignedTime;
import com.apms.assignedTime.AssignedTimeService;
import com.apms.attitude.Attitude;
import com.apms.attitude.AttitudeService;
import com.apms.bibliography.Bibliography;
import com.apms.content.Content;
import com.apms.evaluationAccreditationUA.EvaluationAccreditationUA;
import com.apms.evaluationUA.EvaluationUA;
import com.apms.knowledge.Knowledge;
import com.apms.knowledge.KnowledgeService;
import com.apms.learningUnit.LearningUnit;
import com.apms.modality.Modality;
import com.apms.professionalExperience.ProfessionalExperience;
import com.apms.professionalExperience.ProfessionalExperienceService;
import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;
import com.apms.schoolingGrade.SchoolingGrade;
import com.apms.schoolingGrade.SchoolingGradeService;
import com.apms.syntheticProgram.SyntheticProgram;
import com.apms.teaching.Teaching;
import com.apms.teachingProfile.TeachingProfile;
import com.apms.teachingProfile.TeachingProfileService;
import com.apms.type.Type;
import com.apms.type.TypeService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

@RestController
@RequestMapping("/extensiveProgram")
public class ExtensiveProgramRestController {

	@Autowired
	private AssignedTimeService assignedTimeService;
	
	
	@Autowired
	private AcademicLevelService academicLevelService;
	
	@Autowired
	private SchoolingGradeService schoolingGradeService;
	

	@Autowired
	private KnowledgeService knowledgesService;
	@Autowired
	private ProfessionalExperienceService professionalExperienceService;
	@Autowired
	private AttitudeService attitudeService;
	@Autowired
	private AbilityService abilityService;
	@Autowired
	private ExtensiveProgramService extensiveProgramService;
	@Autowired
	private TeachingProfileService teachingProfileService;
	
	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<ExtensiveProgram>> getAll() {
		List<ExtensiveProgram> res;
		try {
			res = extensiveProgramService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<ExtensiveProgram>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<ExtensiveProgram>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<ExtensiveProgram>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<ExtensiveProgram> getOne(@PathVariable Integer id) {
		ExtensiveProgram res;
		try {
			res = extensiveProgramService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ExtensiveProgram>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<ExtensiveProgram>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<ExtensiveProgram>(RESTResponse.FAIL, "Programa en extenso no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<ExtensiveProgram> post(@RequestBody Map<String,JsonNode> req) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		/*Catalogos*/		
		
		LearningUnit learningUnit = mapper.treeToValue(req.get("learningUnit"),LearningUnit.class);
		Modality modality =  mapper.treeToValue(req.get("modality"),Modality.class);
		Teaching teaching =  mapper.treeToValue(req.get("teaching"),Teaching.class);
		List<Type> types = new ArrayList<Type>();
		for(JsonNode c :req.get("types")) {
			types.add(mapper.treeToValue(c,Type.class));
		}
		/*atributos*/
		AssignedTime assignedTime = assignedTimeService.add(mapper.treeToValue(req.get("assignedTime"),AssignedTime.class));  
		int validity  = mapper.treeToValue(req.get("validity"),Integer.class);
		String educationalIntention = mapper.treeToValue(req.get("educationalIntention"),String.class);
		
		/*Perfil docente*/
		
		TeachingProfile teachingProfile = teachingProfileService.add(mapper.treeToValue(req.get("teachingProfile"),TeachingProfile.class));
		
		/*Extensive program*/
		try {
			extensiveProgramService.add(new ExtensiveProgram(educationalIntention,validity,types,learningUnit,assignedTime,teachingProfile,modality,teaching));
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ExtensiveProgram>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<ExtensiveProgram>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}
	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<ExtensiveProgram> patch(@RequestBody RESTRequest<ExtensiveProgram> extensiveProgram) {
		try {
			extensiveProgramService.update(extensiveProgram.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ExtensiveProgram>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ExtensiveProgram>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<ExtensiveProgram> put(@RequestBody RESTRequest<ExtensiveProgram> extensiveProgram) {
		try {
			extensiveProgramService.update(extensiveProgram.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ExtensiveProgram>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ExtensiveProgram>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<ExtensiveProgram> delete(@PathVariable Integer id) {
		try {
			extensiveProgramService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ExtensiveProgram>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<ExtensiveProgram>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
