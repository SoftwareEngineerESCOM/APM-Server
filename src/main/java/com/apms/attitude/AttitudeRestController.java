package com.apms.attitude;

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
@RequestMapping("/attitude")
public class AttitudeRestController {

	@Autowired
	private AttitudeService attitudeService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Attitude>> getAll() {
		List<Attitude> res;
		try {
			res = attitudeService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Attitude>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Attitude>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Attitude>>(RESTResponse.FAIL, "Servicios no disponibles.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Attitude> getOne(@PathVariable Integer id) {
		Attitude res;
		try {
			res = attitudeService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Attitude>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Attitude>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Attitude>(RESTResponse.FAIL, "Actitud no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Attitude> post(@RequestBody RESTRequest<Attitude> attitude) {
		try {
			if(attitudeService.getOne(attitude.getPayload().getId()) != null)
                return new RESTResponse<Attitude>(RESTResponse.FAIL, "Actitud ya existe en el sistema.", null);
			attitudeService.add(attitude.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Attitude>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Attitude>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Attitude> patch(@RequestBody RESTRequest<Attitude> attitude) {
		try {
			attitudeService.update(attitude.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Attitude>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Attitude>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Attitude> put(@RequestBody RESTRequest<Attitude> attitude) {
		try {
			attitudeService.update(attitude.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Attitude>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Attitude>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Attitude> delete(@PathVariable Integer id) {
		try {
			attitudeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Attitude>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Attitude>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
