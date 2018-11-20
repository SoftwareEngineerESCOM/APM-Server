package com.apms.accreditation;

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
@RequestMapping("/accreditation")
public class AccreditationRestController {

	@Autowired
	private AccreditationService accreditationService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Accreditation>> getAll() {
		List<Accreditation> res;
		try {
			res = accreditationService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Accreditation>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Accreditation>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Accreditation>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Accreditation> getOne(@PathVariable Integer id) {
		Accreditation res;
		try {
			res = accreditationService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Accreditation>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Accreditation>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Accreditation>(RESTResponse.FAIL, "Accreditation no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Accreditation> post(@RequestBody RESTRequest<Accreditation> accreditation) {
		try {
			if(accreditationService.getOne(accreditation.getPayload().getId()) != null)
                return new RESTResponse<Accreditation>(RESTResponse.FAIL, "Accreditation ya existe en el sistema.", null);
			accreditationService.add(accreditation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Accreditation>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Accreditation>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Accreditation> patch(@RequestBody RESTRequest<Accreditation> accreditation) {
		try {
			accreditationService.update(accreditation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Accreditation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Accreditation>(RESTResponse.OK, "Accreditation modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Accreditation> put(@RequestBody RESTRequest<Accreditation> accreditation) {
		try {
			accreditationService.update(accreditation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Accreditation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Accreditation>(RESTResponse.OK, "Accreditation modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Accreditation> delete(@PathVariable Integer id) {
		try {
			accreditationService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Accreditation>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Accreditation>(RESTResponse.OK, "Accreditation modificado.", null);
	}
}
