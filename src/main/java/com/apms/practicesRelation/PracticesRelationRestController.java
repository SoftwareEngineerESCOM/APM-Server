package com.apms.practicesRelation;

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
@RequestMapping("/practicesRelation")
public class PracticesRelationRestController {

	@Autowired
	private PracticesRelationService practicesRelationService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<PracticesRelation>> getAll() {
		List<PracticesRelation> res;
		try {
			res = practicesRelationService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<PracticesRelation>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<PracticesRelation>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<PracticesRelation>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<PracticesRelation> getOne(@PathVariable Integer id) {
		PracticesRelation res;
		try {
			res = practicesRelationService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PracticesRelation>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (res != null) {
			return new RESTResponse<PracticesRelation>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<PracticesRelation>(RESTResponse.FAIL, "Relacion de practicas no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<PracticesRelation> post(@RequestBody RESTRequest<PracticesRelation> practicesRelation) {
		try {
			if(practicesRelationService.getOne(practicesRelation.getPayload().getId()) != null)
                return new RESTResponse<PracticesRelation>(RESTResponse.FAIL, "La relacion de practicas ya existe en el sistema.", null);
			practicesRelationService.add(practicesRelation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PracticesRelation>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PracticesRelation>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<PracticesRelation> patch(@RequestBody RESTRequest<PracticesRelation> practicesRelation) {
		try {
			practicesRelationService.update(practicesRelation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PracticesRelation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PracticesRelation>(RESTResponse.OK, "Relacion de practicas modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<PracticesRelation> put(@RequestBody RESTRequest<PracticesRelation> practicesRelation) {
		try {
			practicesRelationService.update(practicesRelation.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PracticesRelation>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PracticesRelation>(RESTResponse.OK, "Relacion de practicas modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<PracticesRelation> delete(@PathVariable Integer id) {
		try {
			practicesRelationService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<PracticesRelation>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<PracticesRelation>(RESTResponse.OK, "Relacion de practicas modificado.", null);
	}
}
