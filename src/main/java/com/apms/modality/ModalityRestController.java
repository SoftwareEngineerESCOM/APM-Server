package com.apms.modality;

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
@RequestMapping("/modality")
public class ModalityRestController {

	@Autowired
	private ModalityService modalityService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Modality>> getAll() {
		List<Modality> res;
		try {
			res = modalityService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Modality>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Modality>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Modality>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Modality> getOne(@PathVariable Integer id) {
		Modality res;
		try {
			res = modalityService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Modality>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Modality>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Modality>(RESTResponse.FAIL, "Modality no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Modality> post(@RequestBody RESTRequest<Modality> modality) {
		try {
			if(modalityService.getOne(modality.getPayload().getId()) != null)
                return new RESTResponse<Modality>(RESTResponse.FAIL, "Modality ya existe en el sistema.", null);
			modalityService.add(modality.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Modality>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Modality>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Modality> patch(@RequestBody RESTRequest<Modality> modality) {
		try {
			modalityService.update(modality.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Modality>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Modality>(RESTResponse.OK, "Modality modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Modality> put(@RequestBody RESTRequest<Modality> modality) {
		try {
			modalityService.update(modality.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Modality>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Modality>(RESTResponse.OK, "Modality modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Modality> delete(@PathVariable Integer id) {
		try {
			modalityService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Modality>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Modality>(RESTResponse.OK, "Modality modificado.", null);
	}
}
