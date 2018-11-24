package com.apms.evaluationUA;

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
@RequestMapping("/evaluationua")
public class EvaluationUARestController {

	@Autowired
	private EvaluationUAService evaluationUAService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<EvaluationUA>> getAll() {
		List<EvaluationUA> res;
		try {
			res = evaluationUAService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<EvaluationUA>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<EvaluationUA>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<EvaluationUA>>(RESTResponse.FAIL, "Evaluaciones de la unidad no disponibles.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<EvaluationUA> getOne(@PathVariable Integer id) {
		EvaluationUA res;
		try {
			res = evaluationUAService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationUA>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<EvaluationUA>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<EvaluationUA>(RESTResponse.FAIL, "Evaluacion no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<EvaluationUA> post(@RequestBody RESTRequest<EvaluationUA> evaluationUA) {
		try {
			if(evaluationUAService.getOne(evaluationUA.getPayload().getId()) != null)
                return new RESTResponse<EvaluationUA>(RESTResponse.FAIL, "La evaluacion ya existe en el sistema.", null);
			evaluationUAService.add(evaluationUA.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationUA>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationUA>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<EvaluationUA> patch(@RequestBody RESTRequest<EvaluationUA> evaluationUA) {
		try {
			evaluationUAService.update(evaluationUA.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationUA>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationUA>(RESTResponse.OK, "Evaluacion modificada.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<EvaluationUA> put(@RequestBody RESTRequest<EvaluationUA> evaluationUA) {
		try {
			evaluationUAService.update(evaluationUA.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationUA>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationUA>(RESTResponse.OK, "Evaluacion modificada.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<EvaluationUA> delete(@PathVariable Integer id) {
		try {
			evaluationUAService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationUA>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationUA>(RESTResponse.OK, "Evaluacion modificada.", null);
	}
}
