package com.apms.academicProgram;

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
@RequestMapping("/AcademicProgram")
public class AcademicProgramRestController {

	@Autowired
	private AcademicProgramService academicProgramService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<AcademicProgram>> getAll() {
		List<AcademicProgram> res;
		try {
			res = academicProgramService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<AcademicProgram>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					new ArrayList<AcademicProgram>());
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<AcademicProgram>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<AcademicProgram>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.",
					res);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<AcademicProgram> getOne(@PathVariable Integer id) {
		return new RESTResponse<AcademicProgram>(RESTResponse.OK, "", academicProgramService.getOne(id));
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public void add(@RequestBody RESTRequest<AcademicProgram> req) {
		academicProgramService.add(req.getPayload());
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PatchMapping
	public void update(@RequestBody RESTRequest<AcademicProgram> req) {
		academicProgramService.update(req.getPayload());
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		academicProgramService.delete(id);
	}

	@GetMapping("/AcademicProgramsByWorkPlaceId/{id}")
	public RESTResponse<List<AcademicProgram>> getAcademicProgramsByWorkPlaceId(@PathVariable Integer id) {
		return new RESTResponse<List<AcademicProgram>>(1, "",
				academicProgramService.getAcademicProgramsByWorkPlaceId(id));
	}
}
