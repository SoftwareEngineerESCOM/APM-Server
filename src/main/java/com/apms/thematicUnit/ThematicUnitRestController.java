package com.apms.thematicUnit;

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
@RequestMapping("/thematicUnit")
public class ThematicUnitRestController {

	@Autowired
	private ThematicUnitService thematicUnitService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<ThematicUnit>> getAll() {
		List<ThematicUnit> res;
		try {
			res = thematicUnitService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<ThematicUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<ThematicUnit>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<ThematicUnit>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<ThematicUnit> getOne(@PathVariable Integer id) {
		ThematicUnit res;
		try {
			res = thematicUnitService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ThematicUnit>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<ThematicUnit>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<ThematicUnit>(RESTResponse.FAIL, "Unidad tematica no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<ThematicUnit> post(@RequestBody RESTRequest<ThematicUnit> thematicUnit) {
		try {
			if(thematicUnitService.getOne(thematicUnit.getPayload().getId()) != null)
                return new RESTResponse<ThematicUnit>(RESTResponse.FAIL, "La Unidad tematica ya existe en el sistema.", null);
			thematicUnitService.add(thematicUnit.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<ThematicUnit> patch(@RequestBody RESTRequest<ThematicUnit> thematicUnit) {
		try {
			thematicUnitService.update(thematicUnit.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<ThematicUnit> put(@RequestBody RESTRequest<ThematicUnit> thematicUnit) {
		try {
			thematicUnitService.update(thematicUnit.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<ThematicUnit> delete(@PathVariable Integer id) {
		try {
			thematicUnitService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
