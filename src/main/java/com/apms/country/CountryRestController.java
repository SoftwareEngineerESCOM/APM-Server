package com.apms.country;

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
@RequestMapping("/country")
public class CountryRestController {

	@Autowired
	private CountryService countryService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Country>> getAll() {
		List<Country> res;
		try {
			res = countryService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Country>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Country>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Country>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Country> getOne(@PathVariable Integer id) {
		Country res;
		try {
			res = countryService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Country>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Country>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Country>(RESTResponse.FAIL, "País no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Country> post(@RequestBody RESTRequest<Country> country) {
		try {
			if(countryService.getOne(country.getPayload().getId()) != null)
                return new RESTResponse<Country>(RESTResponse.FAIL, "El país ya existe en el sistema.", null);
				countryService.add(country.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Country>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Country>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Country> patch(@RequestBody RESTRequest<Country> country) {
		try {
			countryService.update(country.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Country>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Country>(RESTResponse.OK, "País modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Country> put(@RequestBody RESTRequest<Country> country) {
		try {
			countryService.update(country.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Country>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Country>(RESTResponse.OK, "País modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Country> delete(@PathVariable Integer id) {
		try {
			countryService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Country>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Country>(RESTResponse.OK, "País eliminado.", null);
	}
}
