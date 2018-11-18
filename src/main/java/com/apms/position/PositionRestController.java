package com.apms.position;

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
@RequestMapping("/Position")
public class PositionRestController {

	@Autowired
	private PositionService positionService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Position>> getAll() {
		List<Position> res;
		try {
			res = positionService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Position>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					new ArrayList<Position>());
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Position>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Position>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.",
					res);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Position> getOne(@PathVariable Integer id) {
		return new RESTResponse<Position>(1, "", positionService.getOne(id));
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public void add(@RequestBody RESTRequest<Position> req) {
		System.out.println("alooossss");
		positionService.add(req.getPayload());
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PatchMapping
	public void update(@RequestBody RESTRequest<Position> req) {
		positionService.update(req.getPayload());
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		positionService.delete(id);
	}
}
