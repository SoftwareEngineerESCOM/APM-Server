package com.apms.learningUnitEvaluation;

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
@RequestMapping("/learningUnitEvaluation")
public class LearningUnitEvaluationRestController {

	@Autowired
	private LearningUnitEvaluationService learningUnitEvaluationService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<LearningUnitEvaluation>> getAll() {
		List<LearningUnitEvaluation> res;
		try {
			res = learningUnitEvaluationService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<LearningUnitEvaluation>>(RESTResponse.DBFAIL,
					"Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<LearningUnitEvaluation>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<LearningUnitEvaluation>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<LearningUnitEvaluation> getOne(@PathVariable Integer id) {
		LearningUnitEvaluation res;
		try {
			res = learningUnitEvaluationService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnitEvaluation>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (res != null) {
			return new RESTResponse<LearningUnitEvaluation>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<LearningUnitEvaluation>(RESTResponse.FAIL, "LearningUnitEvaluation no registrado.",
					null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<LearningUnitEvaluation> post(
			@RequestBody RESTRequest<LearningUnitEvaluation> learningUnitEvaluation) {
		try {
			if(learningUnitEvaluationService.getOne(learningUnitEvaluation.getPayload().getId()) != null)
                return new RESTResponse<LearningUnitEvaluation>(RESTResponse.FAIL, "LearningUnitEvaluation ya existe en el sistema.", null);
			learningUnitEvaluationService.add(learningUnitEvaluation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnitEvaluation>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnitEvaluation>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<LearningUnitEvaluation> patch(
			@RequestBody RESTRequest<LearningUnitEvaluation> learningUnitEvaluation) {
		try {
			learningUnitEvaluationService.update(learningUnitEvaluation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnitEvaluation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnitEvaluation>(RESTResponse.OK, "LearningUnitEvaluation modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<LearningUnitEvaluation> put(
			@RequestBody RESTRequest<LearningUnitEvaluation> learningUnitEvaluation) {
		try {
			learningUnitEvaluationService.update(learningUnitEvaluation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnitEvaluation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnitEvaluation>(RESTResponse.OK, "LearningUnitEvaluation modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<LearningUnitEvaluation> delete(@PathVariable Integer id) {
		try {
			learningUnitEvaluationService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnitEvaluation>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnitEvaluation>(RESTResponse.OK, "LearningUnitEvaluation modificado.", null);
	}
}
