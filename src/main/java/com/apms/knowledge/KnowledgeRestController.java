package com.apms.knowledge;

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
@RequestMapping("/knowledge")
public class KnowledgeRestController {

	@Autowired
	private KnowledgeService knowledgeService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Knowledge>> getAll() {
		List<Knowledge> res;
		try {
			res = knowledgeService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Knowledge>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Knowledge>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Knowledge>>(RESTResponse.FAIL, "Servicios no disponibles.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Knowledge> getOne(@PathVariable Integer id) {
		Knowledge res;
		try {
			res = knowledgeService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Knowledge>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Knowledge>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Knowledge>(RESTResponse.FAIL, "Conocimiento no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Knowledge> post(@RequestBody RESTRequest<Knowledge> knowledge) {
		try {
			if(knowledgeService.getOne(knowledge.getPayload().getId()) != null)
                return new RESTResponse<Knowledge>(RESTResponse.FAIL, "El Conocimiento ya existe en el sistema.", null);
			knowledgeService.add(knowledge.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Knowledge>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Knowledge>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Knowledge> patch(@RequestBody RESTRequest<Knowledge> knowledge) {
		try {
			knowledgeService.update(knowledge.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Knowledge>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Knowledge>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Knowledge> put(@RequestBody RESTRequest<Knowledge> knowledge) {
		try {
			knowledgeService.update(knowledge.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Knowledge>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Knowledge>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Knowledge> delete(@PathVariable Integer id) {
		try {
			knowledgeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Knowledge>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Knowledge>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
