package com.apms.assignedTime;

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
@RequestMapping("/assignedTime")
public class AssignedTimeRestController {

	@Autowired
	private AssignedTimeService assignedTimeService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<AssignedTime>> getAll() {
		List<AssignedTime> res;
		try {
			res = assignedTimeService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<AssignedTime>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<AssignedTime>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<AssignedTime>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<AssignedTime> getOne(@PathVariable Integer id) {
		AssignedTime res;
		try {
			res = assignedTimeService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<AssignedTime>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<AssignedTime>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<AssignedTime>(RESTResponse.FAIL, "Tiempo asignado no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<AssignedTime> post(@RequestBody RESTRequest<AssignedTime> assignedTime) {
		try {
			if(assignedTimeService.getOne(assignedTime.getPayload().getId()) != null)
                return new RESTResponse<AssignedTime>(RESTResponse.FAIL, "Tiempo asignado ya existe en el sistema.", null);
			assignedTimeService.add(assignedTime.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<AssignedTime>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<AssignedTime>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<AssignedTime> patch(@RequestBody RESTRequest<AssignedTime> assignedTime) {
		try {
			assignedTimeService.update(assignedTime.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<AssignedTime>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<AssignedTime>(RESTResponse.OK, "Tiempo asignado modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<AssignedTime> put(@RequestBody RESTRequest<AssignedTime> assignedTime) {
		try {
			assignedTimeService.update(assignedTime.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<AssignedTime>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<AssignedTime>(RESTResponse.OK, "Tiempo asignado modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<AssignedTime> delete(@PathVariable Integer id) {
		try {
			assignedTimeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<AssignedTime>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<AssignedTime>(RESTResponse.OK, "Tiempo asignado modificado.", null);
	}
}
