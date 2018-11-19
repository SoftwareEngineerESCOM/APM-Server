package com.apms.content;

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
@RequestMapping("/content")
public class ContentRestController {

	@Autowired
	private ContentService contentService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Content>> getAll() {
		List<Content> res;
		try {
			res = contentService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Content>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Content>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Content>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Content> getOne(@PathVariable Integer id) {
		Content res;
		try {
			res = contentService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Content>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Content>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Content>(RESTResponse.FAIL, "Content no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Content> post(@RequestBody RESTRequest<Content> content) {
		try {
			if(contentService.getOne(content.getPayload().getId()) != null)
                return new RESTResponse<Content>(RESTResponse.FAIL, "Content ya existe en el sistema.", null);
			contentService.add(content.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Content>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Content>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Content> patch(@RequestBody RESTRequest<Content> content) {
		try {
			contentService.update(content.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Content>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Content>(RESTResponse.OK, "Content modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Content> put(@RequestBody RESTRequest<Content> content) {
		try {
			contentService.update(content.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Content>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Content>(RESTResponse.OK, "Content modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Content> delete(@PathVariable Integer id) {
		try {
			contentService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Content>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Content>(RESTResponse.OK, "Content modificado.", null);
	}
}
