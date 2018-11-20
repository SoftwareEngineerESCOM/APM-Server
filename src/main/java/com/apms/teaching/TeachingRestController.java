package com.apms.teaching;

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
@RequestMapping("/teaching")
public class TeachingRestController {

	@Autowired
	private TeachingService teachingService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Teaching>> getAll() {
		List<Teaching> res;
		try {
			res = teachingService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Teaching>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Teaching>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Teaching>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Teaching> getOne(@PathVariable Integer id) {
		Teaching res;
		try {
			res = teachingService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Teaching>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Teaching>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Teaching>(RESTResponse.FAIL, "Teaching no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Teaching> post(@RequestBody RESTRequest<Teaching> teaching) {
		try {
			if(teachingService.getOne(teaching.getPayload().getId()) != null)
                return new RESTResponse<Teaching>(RESTResponse.FAIL, "Teaching ya existe en el sistema.", null);
			teachingService.add(teaching.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Teaching>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Teaching>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Teaching> patch(@RequestBody RESTRequest<Teaching> teaching) {
		try {
			teachingService.update(teaching.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Teaching>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Teaching>(RESTResponse.OK, "Teaching modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Teaching> put(@RequestBody RESTRequest<Teaching> teaching) {
		try {
			teachingService.update(teaching.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Teaching>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Teaching>(RESTResponse.OK, "Teaching modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Teaching> delete(@PathVariable Integer id) {
		try {
			teachingService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Teaching>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Teaching>(RESTResponse.OK, "Teaching modificado.", null);
	}
}
