package com.apms.accreditationType;

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
@RequestMapping("/accreditationtype")
public class AccreditationTypeRestController {

	@Autowired
	private AccreditationTypeService accreditationService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<AccreditationType>> getAll() {
		List<AccreditationType> res;
		try {
			res = accreditationService.getAll();
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<AccreditationType>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<AccreditationType>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<AccreditationType>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<AccreditationType> getOne(@PathVariable Integer id) {
		AccreditationType res;
		try {
			res = accreditationService.getOne(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<AccreditationType>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<AccreditationType>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<AccreditationType>(RESTResponse.FAIL, "Acreditacion no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<AccreditationType> post(@RequestBody RESTRequest<AccreditationType> accreditation) {
		try {
			if(accreditationService.getAccreditationTypeByName(accreditation.getPayload().getName()) != null)
                return new RESTResponse<AccreditationType>(RESTResponse.FAIL, "Acreditacion ya existe en el sistema.", null);
			accreditationService.add(accreditation.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<AccreditationType>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<AccreditationType>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<AccreditationType> patch(@RequestBody RESTRequest<AccreditationType> accreditation) {
		try {
			accreditationService.update(accreditation.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<AccreditationType>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<AccreditationType>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<AccreditationType> put(@RequestBody RESTRequest<AccreditationType> accreditation) {
		try {
			accreditationService.update(accreditation.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<AccreditationType>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<AccreditationType>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<AccreditationType> delete(@PathVariable Integer id) {
		try {
			accreditationService.delete(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<AccreditationType>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<AccreditationType>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
