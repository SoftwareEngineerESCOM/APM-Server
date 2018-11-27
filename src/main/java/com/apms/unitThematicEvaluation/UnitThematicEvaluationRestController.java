package com.apms.unitThematicEvaluation;

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
@RequestMapping("/unitThematicEvaluation")
public class UnitThematicEvaluationRestController {

	@Autowired
	private UnitThematicEvaluationService unitThematicEvaluationService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<UnitThematicEvaluation>> getAll() {
		List<UnitThematicEvaluation> res;
		try {
			res = unitThematicEvaluationService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<UnitThematicEvaluation>>(RESTResponse.DBFAIL,
					"Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<UnitThematicEvaluation>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<UnitThematicEvaluation>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<UnitThematicEvaluation> getOne(@PathVariable Integer id) {
		UnitThematicEvaluation res;
		try {
			res = unitThematicEvaluationService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<UnitThematicEvaluation>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (res != null) {
			return new RESTResponse<UnitThematicEvaluation>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<UnitThematicEvaluation>(RESTResponse.FAIL, "Unidad de Evaluacion tematica no registrada.",
					null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<UnitThematicEvaluation> post(
			@RequestBody RESTRequest<UnitThematicEvaluation> unitThematicEvaluation) {
		try {
			if(unitThematicEvaluationService.getOne(unitThematicEvaluation.getPayload().getId()) != null)
                return new RESTResponse<UnitThematicEvaluation>(RESTResponse.FAIL, "La Unidad de Evaluacion tematica ya existe en el sistema.", null);
			unitThematicEvaluationService.add(unitThematicEvaluation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<UnitThematicEvaluation>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<UnitThematicEvaluation>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<UnitThematicEvaluation> patch(
			@RequestBody RESTRequest<UnitThematicEvaluation> unitThematicEvaluation) {
		try {
			unitThematicEvaluationService.update(unitThematicEvaluation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<UnitThematicEvaluation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<UnitThematicEvaluation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<UnitThematicEvaluation> put(
			@RequestBody RESTRequest<UnitThematicEvaluation> unitThematicEvaluation) {
		try {
			unitThematicEvaluationService.update(unitThematicEvaluation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<UnitThematicEvaluation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<UnitThematicEvaluation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<UnitThematicEvaluation> delete(@PathVariable Integer id) {
		try {
			unitThematicEvaluationService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<UnitThematicEvaluation>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<UnitThematicEvaluation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
