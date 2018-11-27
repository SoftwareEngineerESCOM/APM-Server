package com.apms.topic;

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
@RequestMapping("/topic")
public class TopicRestController {

	@Autowired
	private TopicService topicService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Topic>> getAll() {
		List<Topic> res;
		try {
			res = topicService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Topic>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Topic>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Topic>>(RESTResponse.FAIL, "Servicios no disponibles.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Topic> getOne(@PathVariable Integer id) {
		Topic res;
		try {
			res = topicService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Topic>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Topic>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Topic>(RESTResponse.FAIL, "Tema no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Topic> post(@RequestBody RESTRequest<Topic> topic) {
		try {
			if(topicService.getOne(topic.getPayload().getId()) != null)
                return new RESTResponse<Topic>(RESTResponse.FAIL, "El tema ya existe en el sistema.", null);
			topicService.add(topic.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Topic>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Topic>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Topic> patch(@RequestBody RESTRequest<Topic> topic) {
		try {
			topicService.update(topic.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Topic>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Topic>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Topic> put(@RequestBody RESTRequest<Topic> topic) {
		try {
			topicService.update(topic.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Topic>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Topic>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Topic> delete(@PathVariable Integer id) {
		try {
			topicService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Topic>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Topic>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
