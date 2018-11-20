package com.apms.position;

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
@RequestMapping("/position")
public class PositionRestController {

	@Autowired
	private PositionService positionService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Position>> getAll() {
		List<Position> res;
		try {
			res = positionService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Position>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Position>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Position>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Position> getOne(@PathVariable Integer id) {
		Position res;
		try {
			res = positionService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Position>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Position>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Position>(RESTResponse.FAIL, "Cargo no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Position> post(@RequestBody RESTRequest<Position> position) {
		try {
			if(positionService.getOne(position.getPayload().getId()) != null)
                return new RESTResponse<Position>(RESTResponse.FAIL, "El cargo ya existe en el sistema.", null);
			positionService.add(position.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Position>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Position>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Position> patch(@RequestBody RESTRequest<Position> position) {
		try {
			positionService.update(position.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Position>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Position>(RESTResponse.OK, "Cargo modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Position> put(@RequestBody RESTRequest<Position> position) {
		try {
			positionService.update(position.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Position>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Position>(RESTResponse.OK, "Cargo modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Position> delete(@PathVariable Integer id) {
		try {
			positionService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Position>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Position>(RESTResponse.OK, "Cargo modificado.", null);
	}
}
