package com.apms.ability;

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
@RequestMapping("/ability")
public class AbilityRestController {

	@Autowired
	private AbilityService abilityService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Ability>> getAll() {
		List<Ability> res;
		try {
			res = abilityService.getAll();
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<Ability>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Ability>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Ability>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Ability> getOne(@PathVariable Integer id) {
		Ability res;
		try {
			res = abilityService.getOne(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Ability>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Ability>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Ability>(RESTResponse.FAIL, "Habilidad no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Ability> post(@RequestBody RESTRequest<Ability> ability) {
		try {
			if (abilityService.getOne(ability.getPayload().getId()) != null)
				return new RESTResponse<Ability>(RESTResponse.FAIL, "La habilidad ya existe en el sistema.", null);
			Ability a = abilityService.add(ability.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Ability>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Ability>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Ability> patch(@RequestBody RESTRequest<Ability> ability) {
		try {
			abilityService.update(ability.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Ability>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Ability>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Ability> put(@RequestBody RESTRequest<Ability> ability) {
		try {
			abilityService.update(ability.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Ability>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Ability>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Ability> delete(@PathVariable Integer id) {
		try {
			abilityService.delete(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Ability>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Ability>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
