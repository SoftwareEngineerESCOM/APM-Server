package com.apms.title;

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
@RequestMapping("/title")
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
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<Title>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Title>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Title>>(RESTResponse.FAIL, "Servicios no disponibles.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Title> getOne(@PathVariable Integer id) {
		Title res;
		try {
			res = titleService.getOne(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Title>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Title>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Title>(RESTResponse.FAIL, "Titulo no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Title> post(@RequestBody RESTRequest<Title> title) {
		try {
			if(titleService.getOne(title.getPayload().getId()) != null)
                return new RESTResponse<Title>(RESTResponse.FAIL, "El titulo ya existe en el sistema.", null);
			titleService.add(title.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Title>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Title>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Title> patch(@RequestBody RESTRequest<Title> title) {
		try {
			titleService.update(title.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Title>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Title>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Title> put(@RequestBody RESTRequest<Title> title) {
		try {
			titleService.update(title.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Title>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Title>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Title> delete(@PathVariable Integer id) {
		try {
			titleService.delete(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Title>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Title>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
