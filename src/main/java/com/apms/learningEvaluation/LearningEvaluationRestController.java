package com.apms.learningEvaluation;

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
@RequestMapping("/unitThematicEvaluation")
public class LearningEvaluationRestController {

	@Autowired
	private LearningEvaluationService learningEvaluationService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<LearningEvaluation>> getAll() {
		List<LearningEvaluation> res;
		try {
			res = learningEvaluationService.getAll();
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<LearningEvaluation>>(RESTResponse.DBFAIL,
					"Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<LearningEvaluation>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<LearningEvaluation>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<LearningEvaluation> getOne(@PathVariable Integer id) {
		LearningEvaluation res;
		try {
			res = learningEvaluationService.getOne(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<LearningEvaluation>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (res != null) {
			return new RESTResponse<LearningEvaluation>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<LearningEvaluation>(RESTResponse.FAIL, "Unidad de Evaluacion tematica no registrada.",
					null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<LearningEvaluation> post(
			@RequestBody RESTRequest<LearningEvaluation> unitThematicEvaluation) {
		try {
			if(learningEvaluationService.getOne(unitThematicEvaluation.getPayload().getId()) != null)
                return new RESTResponse<LearningEvaluation>(RESTResponse.FAIL, "La Unidad de Evaluacion tematica ya existe en el sistema.", null);
			learningEvaluationService.add(unitThematicEvaluation.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<LearningEvaluation>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<LearningEvaluation>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<LearningEvaluation> patch(
			@RequestBody RESTRequest<LearningEvaluation> unitThematicEvaluation) {
		try {
			learningEvaluationService.update(unitThematicEvaluation.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<LearningEvaluation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningEvaluation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<LearningEvaluation> put(
			@RequestBody RESTRequest<LearningEvaluation> unitThematicEvaluation) {
		try {
			learningEvaluationService.update(unitThematicEvaluation.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<LearningEvaluation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningEvaluation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<LearningEvaluation> delete(@PathVariable Integer id) {
		try {
			learningEvaluationService.delete(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<LearningEvaluation>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<LearningEvaluation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
