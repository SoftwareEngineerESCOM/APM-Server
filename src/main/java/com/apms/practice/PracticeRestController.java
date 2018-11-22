package com.apms.practice;

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
@RequestMapping("/practice")
public class PracticeRestController {

	@Autowired
	private PracticeService practiceService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Practice>> getAll() {
		List<Practice> res;
		try {
			res = practiceService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Practice>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Practice>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Practice>>(RESTResponse.FAIL, "Servicios no disponibles.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Practice> getOne(@PathVariable Integer id) {
		Practice res;
		try {
			res = practiceService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Practice>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Practice>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Practice>(RESTResponse.FAIL, "Practica no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Practice> post(@RequestBody RESTRequest<Practice> practice) {
		try {
			if(practiceService.getOne(practice.getPayload().getId()) != null)
                return new RESTResponse<Practice>(RESTResponse.FAIL, "La practica ya existe en el sistema.", null);
			practiceService.add(practice.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Practice>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Practice>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Practice> patch(@RequestBody RESTRequest<Practice> practice) {
		try {
			practiceService.update(practice.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Practice>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Practice>(RESTResponse.OK, "Practica modificada.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Practice> put(@RequestBody RESTRequest<Practice> practice) {
		try {
			practiceService.update(practice.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Practice>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Practice>(RESTResponse.OK, "Practica modificada.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Practice> delete(@PathVariable Integer id) {
		try {
			practiceService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Practice>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Practice>(RESTResponse.OK, "Practica modificada.", null);
	}
}
