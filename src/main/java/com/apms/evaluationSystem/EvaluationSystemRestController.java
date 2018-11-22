package com.apms.evaluationSystem;

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
@RequestMapping("/evaluationSystem")
public class EvaluationSystemRestController {

	@Autowired
	private EvaluationSystemService evaluationSystemService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<EvaluationSystem>> getAll() {
		List<EvaluationSystem> res;
		try {
			res = evaluationSystemService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<EvaluationSystem>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<EvaluationSystem>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<EvaluationSystem>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<EvaluationSystem> getOne(@PathVariable Integer id) {
		EvaluationSystem res;
		try {
			res = evaluationSystemService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationSystem>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL, "Sistema de evaluacion no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<EvaluationSystem> post(@RequestBody RESTRequest<EvaluationSystem> evaluationSystem) {
		try {
			if(evaluationSystemService.getOne(evaluationSystem.getPayload().getId()) != null)
                return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL, "El sistema de evaluacion ya existe en el sistema.", null);
			evaluationSystemService.add(evaluationSystem.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<EvaluationSystem> patch(@RequestBody RESTRequest<EvaluationSystem> evaluationSystem) {
		try {
			evaluationSystemService.update(evaluationSystem.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Sistema de evaluacion modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<EvaluationSystem> put(@RequestBody RESTRequest<EvaluationSystem> evaluationSystem) {
		try {
			evaluationSystemService.update(evaluationSystem.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Sistema de evaluacion modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<EvaluationSystem> delete(@PathVariable Integer id) {
		try {
			evaluationSystemService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<EvaluationSystem>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<EvaluationSystem>(RESTResponse.OK, "Sistema de evaluacion modificado.", null);
	}
}
