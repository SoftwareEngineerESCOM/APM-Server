package com.apms.studyPlanMode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;

@RestController
@RequestMapping("/StudyPlanMode")
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
					new ArrayList<StudyPlanMode>());
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<StudyPlanMode>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<StudyPlanMode>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado.", res);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<StudyPlanMode> getOne(@PathVariable Long id) {
		return new RESTResponse<StudyPlanMode>(1, "", studyPlanModeService.getOne(id));
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public void add(@RequestBody RESTRequest<StudyPlanMode> studyPlanMode) {
		studyPlanModeService.add(studyPlanMode.getPayload());
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PatchMapping
	public void update(@RequestBody RESTRequest<StudyPlanMode> studyPlanMode) {
		studyPlanModeService.update(studyPlanMode.getPayload());
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		studyPlanModeService.delete(id);
	}
}
