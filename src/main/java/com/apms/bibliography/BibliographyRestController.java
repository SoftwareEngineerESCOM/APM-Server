package com.apms.bibliography;

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
@RequestMapping("/bibliography")
public class BibliographyRestController {

	@Autowired
	private BibliographyService bibliographyService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Bibliography>> getAll() {
		List<Bibliography> res;
		try {
			res = bibliographyService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Bibliography>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Bibliography>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Bibliography>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Bibliography> getOne(@PathVariable String isbn) {
		Bibliography res;
		try {
			res = bibliographyService.getOne(isbn);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Bibliography>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Bibliography>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Bibliography>(RESTResponse.FAIL, "Bibliografia no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Bibliography> post(@RequestBody RESTRequest<Bibliography> bibliography) {
		try {
			if(bibliographyService.getOne(bibliography.getPayload().getISBN()) != null)
                return new RESTResponse<Bibliography>(RESTResponse.FAIL, "La bibliografia ya existe en el sistema.", null);
			bibliographyService.add(bibliography.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Bibliography>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Bibliography>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Bibliography> patch(@RequestBody RESTRequest<Bibliography> bibliography) {
		try {
			bibliographyService.update(bibliography.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Bibliography>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Bibliography>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Bibliography> put(@RequestBody RESTRequest<Bibliography> bibliography) {
		try {
			bibliographyService.update(bibliography.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Bibliography>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Bibliography>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Bibliography> delete(@PathVariable String isbn) {
		try {
			bibliographyService.delete(isbn);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Bibliography>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Bibliography>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
