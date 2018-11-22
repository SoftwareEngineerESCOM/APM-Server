package com.apms.type;

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
@RequestMapping("/type")
public class TypeRestController {

	@Autowired
	private TypeService typeService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Type>> getAll() {
		List<Type> res;
		try {
			res = typeService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Type>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Type>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Type>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Type> getOne(@PathVariable Integer id) {
		Type res;
		try {
			res = typeService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Type>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Type>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Type>(RESTResponse.FAIL, "Tipo no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Type> post(@RequestBody RESTRequest<Type> type) {
		try {
			if(typeService.getOne(type.getPayload().getId()) != null)
                return new RESTResponse<Type>(RESTResponse.FAIL, "El tipo ya existe en el sistema.", null);
			typeService.add(type.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Type>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Type>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Type> patch(@RequestBody RESTRequest<Type> type) {
		try {
			typeService.update(type.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Type>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Type>(RESTResponse.OK, "Tipo modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Type> put(@RequestBody RESTRequest<Type> type) {
		try {
			typeService.update(type.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Type>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Type>(RESTResponse.OK, "Tipo modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Type> delete(@PathVariable Integer id) {
		try {
			typeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Type>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Type>(RESTResponse.OK, "Tipo modificado.", null);
	}
}
