package com.apms.statusStudyPlan;

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
@RequestMapping("/statusStudyPlan")
public class StatusStudyPlanRestController {

	@Autowired
	private StatusStudyPlanService statusStudyPlanService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<StatusStudyPlan>> getAll() {
		List<StatusStudyPlan> res;
		try {
			res = statusStudyPlanService.getAll();
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<StatusStudyPlan>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<StatusStudyPlan>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<StatusStudyPlan>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<StatusStudyPlan> getOne(@PathVariable Integer id) {
		StatusStudyPlan res;
		try {
			res = statusStudyPlanService.getOne(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<StatusStudyPlan>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<StatusStudyPlan>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<StatusStudyPlan>(RESTResponse.FAIL, "StatusStudyPlan no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<StatusStudyPlan> post(@RequestBody RESTRequest<StatusStudyPlan> statusStudyPlan) {
		try {
			if (statusStudyPlanService.getOne(statusStudyPlan.getPayload().getId()) != null)
				return new RESTResponse<StatusStudyPlan>(RESTResponse.FAIL, "StatusStudyPlan ya existe en el sistema.",
						null);
			statusStudyPlanService.add(statusStudyPlan.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<StatusStudyPlan>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<StatusStudyPlan>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<StatusStudyPlan> patch(@RequestBody RESTRequest<StatusStudyPlan> statusStudyPlan) {
		try {
			statusStudyPlanService.update(statusStudyPlan.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<StatusStudyPlan>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<StatusStudyPlan>(RESTResponse.OK, "StatusStudyPlan modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<StatusStudyPlan> put(@RequestBody RESTRequest<StatusStudyPlan> statusStudyPlan) {
		try {
			statusStudyPlanService.update(statusStudyPlan.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<StatusStudyPlan>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<StatusStudyPlan>(RESTResponse.OK, "StatusStudyPlan modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<StatusStudyPlan> delete(@PathVariable Integer id) {
		try {
			statusStudyPlanService.delete(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<StatusStudyPlan>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<StatusStudyPlan>(RESTResponse.OK, "StatusStudyPlan modificado.", null);
	}
}
