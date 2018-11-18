package com.apms.message;

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
@RequestMapping("/Message")
public class MessageRestController {

	@Autowired
	private MessageService messageService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Message>> getAll() {
		List<Message> res;
		try {
			res = messageService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Message>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					new ArrayList<Message>());
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Message>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Message>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.",
					res);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Message> getOne(@PathVariable Integer id) {
		return new RESTResponse<Message>(1, "", messageService.getOne(id));
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public void add(@RequestBody RESTRequest<Message> req) {
		messageService.add(req.getPayload());
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PatchMapping
	public void update(@RequestBody RESTRequest<Message> req) {
		messageService.update(req.getPayload());
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		messageService.delete(id);
	}
}
