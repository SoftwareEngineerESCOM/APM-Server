package com.apms.evaluation;

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
@RequestMapping("/evaluation")
public class EvaluationRestController {

	@Autowired
	private EvaluationService evaluationService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Evaluation>> getAll() {
		List<Evaluation> res;
		try {
			res = evaluationService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Evaluation>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Evaluation>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Evaluation>>(RESTResponse.FAIL, "Servicios no disponibles.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Evaluation> getOne(@PathVariable Integer id) {
		Evaluation res;
		try {
			res = evaluationService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Evaluation>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Evaluation>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Evaluation>(RESTResponse.FAIL, "Evaluacion no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Evaluation> post(@RequestBody RESTRequest<Evaluation> evaluation) {
		try {
			if(evaluationService.getOne(evaluation.getPayload().getId()) != null)
                return new RESTResponse<Evaluation>(RESTResponse.FAIL, "La evaluacion ya existe en el sistema.", null);
			evaluationService.add(evaluation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Evaluation>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Evaluation>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Evaluation> patch(@RequestBody RESTRequest<Evaluation> evaluation) {
		try {
			evaluationService.update(evaluation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Evaluation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Evaluation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Evaluation> put(@RequestBody RESTRequest<Evaluation> evaluation) {
		try {
			evaluationService.update(evaluation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Evaluation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Evaluation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Evaluation> delete(@PathVariable Integer id) {
		try {
			evaluationService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Evaluation>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Evaluation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
