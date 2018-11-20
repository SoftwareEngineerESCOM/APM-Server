package com.apms.extensiveProgram;

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
@RequestMapping("/extensiveProgram")
public class ExtensiveProgramRestController {

	@Autowired
	private ExtensiveProgramService extensiveProgramService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<ExtensiveProgram>> getAll() {
		List<ExtensiveProgram> res;
		try {
			res = extensiveProgramService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<ExtensiveProgram>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<ExtensiveProgram>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<ExtensiveProgram>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<ExtensiveProgram> getOne(@PathVariable Integer id) {
		ExtensiveProgram res;
		try {
			res = extensiveProgramService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ExtensiveProgram>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<ExtensiveProgram>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<ExtensiveProgram>(RESTResponse.FAIL, "Programa en extenso no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<ExtensiveProgram> post(@RequestBody RESTRequest<ExtensiveProgram> extensiveProgram) {
		try {
			if(extensiveProgramService.getOne(extensiveProgram.getPayload().getId()) != null)
                return new RESTResponse<ExtensiveProgram>(RESTResponse.FAIL, "Programa en extenso ya existe en el sistema.", null);
			extensiveProgramService.add(extensiveProgram.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ExtensiveProgram>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ExtensiveProgram>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<ExtensiveProgram> patch(@RequestBody RESTRequest<ExtensiveProgram> extensiveProgram) {
		try {
			extensiveProgramService.update(extensiveProgram.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ExtensiveProgram>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ExtensiveProgram>(RESTResponse.OK, "Programa en extenso modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<ExtensiveProgram> put(@RequestBody RESTRequest<ExtensiveProgram> extensiveProgram) {
		try {
			extensiveProgramService.update(extensiveProgram.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ExtensiveProgram>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ExtensiveProgram>(RESTResponse.OK, "Programa en extenso modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<ExtensiveProgram> delete(@PathVariable Integer id) {
		try {
			extensiveProgramService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ExtensiveProgram>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ExtensiveProgram>(RESTResponse.OK, "Programa en extenso modificado.", null);
	}
}
