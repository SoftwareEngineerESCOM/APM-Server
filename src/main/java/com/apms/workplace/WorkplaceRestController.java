package com.apms.workplace;

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
@RequestMapping("/workplace")
public class WorkplaceRestController {

	@Autowired
	private WorkplaceService workplaceService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Workplace>> getAll() {
		List<Workplace> res;
		try {
			res = workplaceService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Workplace>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Workplace>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Workplace>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Workplace> getOne(@PathVariable Integer id) {
		Workplace res;
		try {
			res = workplaceService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Workplace>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Workplace>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Workplace>(RESTResponse.FAIL, "Workplace no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Workplace> post(@RequestBody RESTRequest<Workplace> workplace) {
		try {
			if(workplaceService.getOne(workplace.getPayload().getId()) != null)
                return new RESTResponse<Workplace>(RESTResponse.FAIL, "Workplace ya existe en el sistema.", null);
			workplaceService.add(workplace.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Workplace>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Workplace>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Workplace> patch(@RequestBody RESTRequest<Workplace> workplace) {
		try {
			workplaceService.update(workplace.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Workplace>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Workplace>(RESTResponse.OK, "Workplace modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Workplace> put(@RequestBody RESTRequest<Workplace> workplace) {
		try {
			workplaceService.update(workplace.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Workplace>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Workplace>(RESTResponse.OK, "Workplace modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Workplace> delete(@PathVariable Integer id) {
		try {
			workplaceService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Workplace>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Workplace>(RESTResponse.OK, "Workplace modificado.", null);
	}
}
