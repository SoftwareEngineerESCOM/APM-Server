package com.apms.learningUnitMode;

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
@RequestMapping("/learningUnitMode")
public class LearningUnitModeRestController {

	@Autowired
	private LearningUnitModeService learningUnitModeService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<LearningUnitMode>> getAll() {
		List<LearningUnitMode> res;
		try {
			res = learningUnitModeService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<LearningUnitMode>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<LearningUnitMode>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<LearningUnitMode>>(RESTResponse.FAIL, "Servicios no disponibles.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<LearningUnitMode> getOne(@PathVariable Integer id) {
		LearningUnitMode res;
		try {
			res = learningUnitModeService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnitMode>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<LearningUnitMode>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<LearningUnitMode>(RESTResponse.FAIL, "Modalidad de la Unidad de Aprendizaje no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<LearningUnitMode> post(@RequestBody RESTRequest<LearningUnitMode> learningUnitMode) {
		try {
			if(learningUnitModeService.getOne(learningUnitMode.getPayload().getId()) != null)
                return new RESTResponse<LearningUnitMode>(RESTResponse.FAIL, "La modalidad de la Unidad de Aprendizaje ya existe en el sistema.", null);
			learningUnitModeService.add(learningUnitMode.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnitMode>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnitMode>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<LearningUnitMode> patch(@RequestBody RESTRequest<LearningUnitMode> learningUnitMode) {
		try {
			learningUnitModeService.update(learningUnitMode.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnitMode>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnitMode>(RESTResponse.OK, "Modalidad de la Unidad de Aprendizaje modificada", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<LearningUnitMode> put(@RequestBody RESTRequest<LearningUnitMode> learningUnitMode) {
		try {
			learningUnitModeService.update(learningUnitMode.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnitMode>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnitMode>(RESTResponse.OK, "Modalidad de la Unidad de Aprendizaje modificada.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<LearningUnitMode> delete(@PathVariable Integer id) {
		try {
			learningUnitModeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnitMode>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnitMode>(RESTResponse.OK, "Modalidad de la Unidad de Aprendizaje modificada.", null);
	}
}
