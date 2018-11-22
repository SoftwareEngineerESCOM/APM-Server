package com.apms.bibliographyType;

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
@RequestMapping("/bibliographyType")
public class BibliographyTypeRestController {

	@Autowired
	private BibliographyTypeService bibliographyTypeService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<BibliographyType>> getAll() {
		List<BibliographyType> res;
		try {
			res = bibliographyTypeService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<BibliographyType>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<BibliographyType>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<BibliographyType>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<BibliographyType> getOne(@PathVariable Integer id) {
		BibliographyType res;
		try {
			res = bibliographyTypeService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<BibliographyType>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<BibliographyType>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<BibliographyType>(RESTResponse.FAIL, "Tipo de bibliografia no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<BibliographyType> post(@RequestBody RESTRequest<BibliographyType> bibliographyType) {
		try {
			if(bibliographyTypeService.getOne(bibliographyType.getPayload().getId()) != null)
                return new RESTResponse<BibliographyType>(RESTResponse.FAIL, "Tipo de bibliografia ya existe en el sistema.", null);
			bibliographyTypeService.add(bibliographyType.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<BibliographyType>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<BibliographyType>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<BibliographyType> patch(@RequestBody RESTRequest<BibliographyType> bibliographyType) {
		try {
			bibliographyTypeService.update(bibliographyType.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<BibliographyType>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<BibliographyType>(RESTResponse.OK, "Tipo de bibliografia modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<BibliographyType> put(@RequestBody RESTRequest<BibliographyType> bibliographyType) {
		try {
			bibliographyTypeService.update(bibliographyType.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<BibliographyType>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<BibliographyType>(RESTResponse.OK, "Tipo de bibliografia modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<BibliographyType> delete(@PathVariable Integer id) {
		try {
			bibliographyTypeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<BibliographyType>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<BibliographyType>(RESTResponse.OK, "Tipo de bibliografia modificado.", null);
	}
}
