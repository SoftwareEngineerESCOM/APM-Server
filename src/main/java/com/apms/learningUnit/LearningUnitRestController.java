package com.apms.learningUnit;

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
@RequestMapping("/LearningUnit")
public class LearningUnitRestController {

	@Autowired
	private LearningUnitService learningUnitService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<LearningUnit>> getAll() {
		List<LearningUnit> res;
		try {
			res = learningUnitService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					new ArrayList<LearningUnit>());
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<LearningUnit>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado.", res);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<LearningUnit> getOne(@PathVariable Integer id) {
		return new RESTResponse<LearningUnit>(1, "", learningUnitService.getOne(id));
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public void add(@RequestBody RESTRequest<LearningUnit> req) {
		learningUnitService.add(req.getPayload());
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PatchMapping
	public void update(@RequestBody RESTRequest<LearningUnit> req) {
		learningUnitService.update(req.getPayload());
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		learningUnitService.delete(id);
	}

	@GetMapping("LearningUnitsBySemesterId/{id}")
	public RESTResponse<List<LearningUnit>> getLearningUnitsBySemesterId(@PathVariable Integer id) {
		return new RESTResponse<List<LearningUnit>>(1, "", learningUnitService.getLearningUnitsBySemesterId(id));
	}

}
