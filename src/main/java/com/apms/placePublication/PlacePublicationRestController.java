package com.apms.placePublication;

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
@RequestMapping("/placePublication")
public class PlacePublicationRestController {

	@Autowired
	private PlacePublicationService placePublicationService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<PlacePublication>> getAll() {
		List<PlacePublication> res;
		try {
			res = placePublicationService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<PlacePublication>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<PlacePublication>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<PlacePublication>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<PlacePublication> getOne(@PathVariable Integer id) {
		PlacePublication res;
		try {
			res = placePublicationService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PlacePublication>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<PlacePublication>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<PlacePublication>(RESTResponse.FAIL, "Lugar de publicacion no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<PlacePublication> post(@RequestBody RESTRequest<PlacePublication> placePublication) {
		try {
			if(placePublicationService.getOne(placePublication.getPayload().getId()) != null)
                return new RESTResponse<PlacePublication>(RESTResponse.FAIL, "El lugar de publicacion ya existe en el sistema.", null);
			placePublicationService.add(placePublication.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PlacePublication>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PlacePublication>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<PlacePublication> patch(@RequestBody RESTRequest<PlacePublication> placePublication) {
		try {
			placePublicationService.update(placePublication.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PlacePublication>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PlacePublication>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<PlacePublication> put(@RequestBody RESTRequest<PlacePublication> placePublication) {
		try {
			placePublicationService.update(placePublication.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PlacePublication>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PlacePublication>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<PlacePublication> delete(@PathVariable Integer id) {
		try {
			placePublicationService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PlacePublication>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PlacePublication>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
