package com.apms.evaluationAccreditationUA;

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
@RequestMapping("/evaluationAccreditationUA")
public class EvaluationAccreditationUARestController {

	@Autowired
	private EvaluationAccreditationUAService evaluationAccreditationUAService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<EvaluationAccreditationUA>> getAll() {
		List<EvaluationAccreditationUA> res;
		try {
			res = evaluationAccreditationUAService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<EvaluationAccreditationUA>>(RESTResponse.DBFAIL,
					"Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<EvaluationAccreditationUA>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<EvaluationAccreditationUA>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<EvaluationAccreditationUA> getOne(@PathVariable Integer id) {
		EvaluationAccreditationUA res;
		try {
			res = evaluationAccreditationUAService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.DBFAIL,
					"Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.FAIL,
					"Evaluacion de acreditacion de Unidad de Aprendizaje no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<EvaluationAccreditationUA> post(
			@RequestBody RESTRequest<EvaluationAccreditationUA> evaluationAccreditationUA) {
		try {
			if(evaluationAccreditationUAService.getOne(evaluationAccreditationUA.getPayload().getId()) != null)
                return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.FAIL, "EvaluationAccreditationUA ya existe en el sistema.", null);
			evaluationAccreditationUAService.add(evaluationAccreditationUA.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<EvaluationAccreditationUA> patch(
			@RequestBody RESTRequest<EvaluationAccreditationUA> evaluationAccreditationUA) {
		try {
			evaluationAccreditationUAService.update(evaluationAccreditationUA.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.OK, "Los cambios se guardaron exitosamente.",
				null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<EvaluationAccreditationUA> put(
			@RequestBody RESTRequest<EvaluationAccreditationUA> evaluationAccreditationUA) {
		try {
			evaluationAccreditationUAService.update(evaluationAccreditationUA.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.OK, "Los cambios se guardaron exitosamente.",
				null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<EvaluationAccreditationUA> delete(@PathVariable Integer id) {
		try {
			evaluationAccreditationUAService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationAccreditationUA>(RESTResponse.OK, "Los cambios se guardaron exitosamente.",
				null);
	}
}
