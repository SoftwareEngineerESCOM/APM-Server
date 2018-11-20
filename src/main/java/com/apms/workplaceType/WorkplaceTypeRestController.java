package com.apms.workplaceType;

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
@RequestMapping("/workplaceType")
public class WorkplaceTypeRestController {

	@Autowired
	private WorkplaceTypeService workplaceTypeService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<WorkplaceType>> getAll() {
		List<WorkplaceType> res;
		try {
			res = workplaceTypeService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<WorkplaceType>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<WorkplaceType>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<WorkplaceType>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<WorkplaceType> getOne(@PathVariable Integer id) {
		WorkplaceType res;
		try {
			res = workplaceTypeService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<WorkplaceType>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<WorkplaceType>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<WorkplaceType>(RESTResponse.FAIL, "Tipo de unidad no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<WorkplaceType> post(@RequestBody RESTRequest<WorkplaceType> workplaceType) {
		try {
			if(workplaceTypeService.getOne(workplaceType.getPayload().getId()) != null)
                return new RESTResponse<WorkplaceType>(RESTResponse.FAIL, "El tipo de unidad ya existe en el sistema.", null);
			workplaceTypeService.add(workplaceType.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<WorkplaceType>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<WorkplaceType>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<WorkplaceType> patch(@RequestBody RESTRequest<WorkplaceType> workplaceType) {
		try {
			workplaceTypeService.update(workplaceType.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<WorkplaceType>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<WorkplaceType>(RESTResponse.OK, "Tipo de unidad modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<WorkplaceType> put(@RequestBody RESTRequest<WorkplaceType> workplaceType) {
		try {
			workplaceTypeService.update(workplaceType.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<WorkplaceType>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<WorkplaceType>(RESTResponse.OK, "Tipo de unidad modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<WorkplaceType> delete(@PathVariable Integer id) {
		try {
			workplaceTypeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<WorkplaceType>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<WorkplaceType>(RESTResponse.OK, "Tipo de unidad modificado.", null);
	}
}
