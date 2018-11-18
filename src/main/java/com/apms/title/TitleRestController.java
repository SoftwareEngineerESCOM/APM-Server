package com.apms.title;

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
@RequestMapping("/Title")
public class TitleRestController {

	@Autowired
	private TitleService titleService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Title>> getAll() {
		List<Title> res;
		try {
			res = titleService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Title>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					new ArrayList<Title>());
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Title>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Title>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.", res);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Title> getOne(@PathVariable Integer id) {
		return new RESTResponse<Title>(1, "", titleService.getOne(id));
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public void add(@RequestBody RESTRequest<Title> req) {
		titleService.add(req.getPayload());
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PatchMapping
	public void update(@RequestBody RESTRequest<Title> req) {
		titleService.update(req.getPayload());
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		titleService.delete(id);
	}
}
