package com.apms.subtopic;

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
@RequestMapping("/subtopic")
public class SubtopicRestController {

	@Autowired
	private SubtopicService subtopicService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Subtopic>> getAll() {
		List<Subtopic> res;
		try {
			res = subtopicService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Subtopic>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Subtopic>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Subtopic>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Subtopic> getOne(@PathVariable Integer id) {
		Subtopic res;
		try {
			res = subtopicService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Subtopic>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Subtopic>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Subtopic>(RESTResponse.FAIL, "Subtema no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Subtopic> post(@RequestBody RESTRequest<Subtopic> subtopic) {
		try {
			if(subtopicService.getOne(subtopic.getPayload().getId()) != null)
                return new RESTResponse<Subtopic>(RESTResponse.FAIL, "El subtema ya existe en el sistema.", null);
			subtopicService.add(subtopic.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Subtopic>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Subtopic>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Subtopic> patch(@RequestBody RESTRequest<Subtopic> subtopic) {
		try {
			subtopicService.update(subtopic.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Subtopic>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Subtopic>(RESTResponse.OK, "Subtema modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Subtopic> put(@RequestBody RESTRequest<Subtopic> subtopic) {
		try {
			subtopicService.update(subtopic.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Subtopic>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Subtopic>(RESTResponse.OK, "Subtema modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Subtopic> delete(@PathVariable Integer id) {
		try {
			subtopicService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Subtopic>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Subtopic>(RESTResponse.OK, "Subtema modificado.", null);
	}
}
