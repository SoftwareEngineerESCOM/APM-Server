package com.apms.workplace;

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

import com.apms.restResponse.RESTRequest;
import com.apms.restResponse.RESTResponse;

@RestController
@RequestMapping("/Workplace")
public class WorkplaceRestController {

	@Autowired
	private WorkplaceService workplaceService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Workplace>> getAll() {
		List<Workplace> res;
		try {
			res = workplaceService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Workplace>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					new ArrayList<Workplace>());
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Workplace>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Workplace>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.",
					res);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Workplace> getOne(@PathVariable Integer id) {
		return new RESTResponse<>(RESTResponse.OK, "", workplaceService.getOne(id));
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public void add(@RequestBody RESTRequest<Workplace> req) {
		workplaceService.add(req.getPayload());
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PatchMapping
	public void update(@RequestBody RESTRequest<Workplace> req) {
		workplaceService.update(req.getPayload());
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		workplaceService.delete(id);
	}
}
