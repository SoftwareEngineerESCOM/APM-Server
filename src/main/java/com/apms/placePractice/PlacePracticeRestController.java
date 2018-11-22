package com.apms.placePractice;

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
@RequestMapping("/placePractice")
public class PlacePracticeRestController {

	@Autowired
	private PlacePracticeService placePracticeService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<PlacePractice>> getAll() {
		List<PlacePractice> res;
		try {
			res = placePracticeService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<PlacePractice>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<PlacePractice>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<PlacePractice>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<PlacePractice> getOne(@PathVariable Integer id) {
		PlacePractice res;
		try {
			res = placePracticeService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PlacePractice>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<PlacePractice>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<PlacePractice>(RESTResponse.FAIL, "Lugar de practica no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<PlacePractice> post(@RequestBody RESTRequest<PlacePractice> placePractice) {
		try {
			if(placePracticeService.getOne(placePractice.getPayload().getId()) != null)
                return new RESTResponse<PlacePractice>(RESTResponse.FAIL, "El lugar de practica ya existe en el sistema.", null);
			placePracticeService.add(placePractice.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PlacePractice>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PlacePractice>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<PlacePractice> patch(@RequestBody RESTRequest<PlacePractice> placePractice) {
		try {
			placePracticeService.update(placePractice.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PlacePractice>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PlacePractice>(RESTResponse.OK, "Lugar de practica modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<PlacePractice> put(@RequestBody RESTRequest<PlacePractice> placePractice) {
		try {
			placePracticeService.update(placePractice.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PlacePractice>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PlacePractice>(RESTResponse.OK, "Lugar de practica modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<PlacePractice> delete(@PathVariable Integer id) {
		try {
			placePracticeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PlacePractice>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PlacePractice>(RESTResponse.OK, "Lugar de practica modificado.", null);
	}
}
