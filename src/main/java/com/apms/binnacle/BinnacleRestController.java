package com.apms.binnacle;

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

import com.apms.rest.RESTRequest;import java.util.logging.Logger;
import com.apms.rest.RESTResponse;

@RestController
@RequestMapping("/binnacle")
public class BinnacleRestController {
	
	@Autowired
	BinnacleService binnacleService;
	
	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Binnacle>> getAll() {
		List<Binnacle> res;
		try {
			res = binnacleService.getAll();
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<Binnacle>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Binnacle>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Binnacle>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Binnacle> getOne(@PathVariable Integer id) {
		Binnacle res;
		try {
			res = binnacleService.getOne(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Binnacle>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Binnacle>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Binnacle>(RESTResponse.FAIL, "Bitácora no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Binnacle> post(@RequestBody RESTRequest<Binnacle> binnacle) {
		try {
			if (binnacleService.getOne(binnacle.getPayload().getId()) != null)
				return new RESTResponse<Binnacle>(RESTResponse.FAIL, "La bitácora ya existe en el sistema.", null);
			binnacleService.add(binnacle.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Binnacle>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Binnacle>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Binnacle> patch(@RequestBody RESTRequest<Binnacle> binnacle) {
		try {
			binnacleService.update(binnacle.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Binnacle>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Binnacle>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Binnacle> put(@RequestBody RESTRequest<Binnacle> binnacle) {
		try {
			binnacleService.update(binnacle.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Binnacle>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Binnacle>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Binnacle> delete(@PathVariable Integer id) {
		try {
			binnacleService.delete(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Binnacle>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Binnacle>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);	
	}
}
