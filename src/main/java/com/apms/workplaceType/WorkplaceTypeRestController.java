package com.apms.workplaceType;

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
@RequestMapping("/WorkplaceType")
public class WorkplaceTypeRestController {

	@Autowired
	private WorkplaceTypeService workplaceTypeService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<WorkplaceType>> getAll() {
		List<WorkplaceType> res;
		try {
			res = workplaceTypeService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<WorkplaceType>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					new ArrayList<WorkplaceType>());
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<WorkplaceType>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<WorkplaceType>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado.", res);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<WorkplaceType> getOne(@PathVariable Integer id) {
		return new RESTResponse<WorkplaceType>(1, "", workplaceTypeService.getOne(id));
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public void add(@RequestBody RESTRequest<WorkplaceType> req) {
		workplaceTypeService.add(req.getPayload());
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PatchMapping
	public void update(@RequestBody RESTRequest<WorkplaceType> req) {
		workplaceTypeService.update(req.getPayload());
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		workplaceTypeService.delete(id);
	}
}
