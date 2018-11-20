package com.apms.studyPlan;

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
@RequestMapping("/studyPlan")
public class StudyPlanRestController {

	@Autowired
	private StudyPlanService studyPlanService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<StudyPlan>> getAll() {
		List<StudyPlan> res;
		try {
			res = studyPlanService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<StudyPlan>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<StudyPlan>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<StudyPlan>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<StudyPlan> getOne(@PathVariable Integer id) {
		StudyPlan res;
		try {
			res = studyPlanService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlan>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<StudyPlan>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<StudyPlan>(RESTResponse.FAIL, "Plan de estudio no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<StudyPlan> post(@RequestBody RESTRequest<StudyPlan> studyPlan) {
		try {
			if(studyPlanService.getOne(studyPlan.getPayload().getId()) != null)
                return new RESTResponse<StudyPlan>(RESTResponse.FAIL, "El Plan de estudio ya existe en el sistema.", null);
			studyPlanService.add(studyPlan.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlan>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<StudyPlan>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<StudyPlan> patch(@RequestBody RESTRequest<StudyPlan> studyPlan) {
		try {
			studyPlanService.update(studyPlan.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlan>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<StudyPlan>(RESTResponse.OK, "Plan de estudio modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<StudyPlan> put(@RequestBody RESTRequest<StudyPlan> studyPlan) {
		try {
			studyPlanService.update(studyPlan.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlan>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<StudyPlan>(RESTResponse.OK, "Plan de estudio modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<StudyPlan> delete(@PathVariable Integer id) {
		try {
			studyPlanService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlan>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<StudyPlan>(RESTResponse.OK, "Plan de estudio modificado.", null);
	}

	@GetMapping("/studyPlansByAcademicProgramId/{id}")
	public RESTResponse<List<StudyPlan>> getStudyPlansByAcademicProgramId(@PathVariable Integer id) {
		return new RESTResponse<List<StudyPlan>>(1, "", studyPlanService.getStudyPlansByAcademicProgramId(id));
	}
}
