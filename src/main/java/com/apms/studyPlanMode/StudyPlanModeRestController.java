package com.apms.studyPlanMode;

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
@RequestMapping("/studyPlanMode")
public class StudyPlanModeRestController {

	@Autowired
	private StudyPlanModeService studyPlanModeService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<StudyPlanMode>> getAll() {
		List<StudyPlanMode> res;
		try {
			res = studyPlanModeService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<StudyPlanMode>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<StudyPlanMode>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<StudyPlanMode>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<StudyPlanMode> getOne(@PathVariable Integer id) {
		StudyPlanMode res;
		try {
			res = studyPlanModeService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlanMode>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<StudyPlanMode>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<StudyPlanMode>(RESTResponse.FAIL, "StudyPlanMode no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<StudyPlanMode> post(@RequestBody RESTRequest<StudyPlanMode> studyPlanMode) {
		try {
			if(studyPlanModeService.getOne(studyPlanMode.getPayload().getId()) != null)
                return new RESTResponse<StudyPlanMode>(RESTResponse.FAIL, "StudyPlanMode ya existe en el sistema.", null);
			studyPlanModeService.add(studyPlanMode.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlanMode>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<StudyPlanMode>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<StudyPlanMode> patch(@RequestBody RESTRequest<StudyPlanMode> studyPlanMode) {
		try {
			studyPlanModeService.update(studyPlanMode.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlanMode>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<StudyPlanMode>(RESTResponse.OK, "StudyPlanMode modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<StudyPlanMode> put(@RequestBody RESTRequest<StudyPlanMode> studyPlanMode) {
		try {
			studyPlanModeService.update(studyPlanMode.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlanMode>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<StudyPlanMode>(RESTResponse.OK, "StudyPlanMode modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<StudyPlanMode> delete(@PathVariable Integer id) {
		try {
			studyPlanModeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlanMode>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<StudyPlanMode>(RESTResponse.OK, "StudyPlanMode modificado.", null);
	}
}
