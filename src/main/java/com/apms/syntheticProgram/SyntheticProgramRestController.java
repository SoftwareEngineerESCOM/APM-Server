package com.apms.syntheticProgram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.apms.accreditationType.AccreditationType;
import com.apms.content.Content;
import com.apms.content.ContentService;
import com.apms.evaluationAccreditationUA.EvaluationAccreditationUA;
import com.apms.evaluationAccreditationUA.EvaluationAccreditationUAService;
import com.apms.evaluationUA.EvaluationUA;
import com.apms.evaluationUA.EvaluationUAService;
import com.apms.learningUnit.LearningUnit;
import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/syntheticProgram")
public class SyntheticProgramRestController {

	@Autowired
	private SyntheticProgramService syntheticProgramService;

	@Autowired
	private EvaluationAccreditationUAService evaluationAccreditationUAService;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private EvaluationUAService evaluationUAService;



	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<SyntheticProgram>> getAll() {
		List<SyntheticProgram> res;
		try {
			res = syntheticProgramService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<SyntheticProgram>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<SyntheticProgram>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<SyntheticProgram>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<SyntheticProgram> getOne(@PathVariable Integer id) {
		SyntheticProgram res;
		try {
			res = syntheticProgramService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<SyntheticProgram>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<SyntheticProgram>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<SyntheticProgram>(RESTResponse.FAIL, "Programa sintetico no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<SyntheticProgram> post(@RequestBody Map<String,JsonNode> req) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		List<Content> content = new ArrayList<Content>();
		List<AccreditationType> accreditationtype = new ArrayList<AccreditationType>();
		List<EvaluationUA> evaluationUA = new ArrayList<EvaluationUA>();
		LearningUnit learningUnit = mapper.treeToValue(req.get("learningUnit"),LearningUnit.class);
		String regard = mapper.treeToValue(req.get("regard"),String.class);
		String didacticOrientation = mapper.treeToValue(req.get("didacticOrientation"),String.class);

		for(JsonNode c :req.get("content")) {
			content.add(contentService.add(mapper.treeToValue(c,Content.class)));
		}
		int i = 0;
		for(JsonNode c :req.get("evaluationAccreditationUA")) {
			System.out.println(c);
			if(i==0) {
				for(JsonNode a : c) {
					System.out.println(a);
					accreditationtype.add(mapper.treeToValue(a,AccreditationType.class));
				}
			}else {
				for(JsonNode a : c) {
					evaluationUA.add(evaluationUAService.add(mapper.treeToValue(a,EvaluationUA.class)));
				}
			}
			i++;
		}
		EvaluationAccreditationUA evaluationAccreditationUA = evaluationAccreditationUAService.add(new EvaluationAccreditationUA(0,accreditationtype,evaluationUA));

		try {
			syntheticProgramService.add(new SyntheticProgram(regard,didacticOrientation,learningUnit,evaluationAccreditationUA,content));
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<SyntheticProgram>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<SyntheticProgram>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<SyntheticProgram> patch(@RequestBody RESTRequest<SyntheticProgram> req) {
		try {
			syntheticProgramService.update(req.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<SyntheticProgram>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<SyntheticProgram>(RESTResponse.OK, "Programa sintetico modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<SyntheticProgram> put(@RequestBody RESTRequest<SyntheticProgram> req) {
		try {
			syntheticProgramService.update(req.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<SyntheticProgram>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<SyntheticProgram>(RESTResponse.OK, "Programa sintetico modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<SyntheticProgram> delete(@PathVariable Integer id) {
		try {
			syntheticProgramService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<SyntheticProgram>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<SyntheticProgram>(RESTResponse.OK, "Programa sintetico modificado.", null);
	}
}
