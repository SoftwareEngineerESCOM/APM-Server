package com.apms.topicHour;

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
@RequestMapping("/topicHour")
public class TopicHourRestController {

	@Autowired
	private TopicHourService topicHourService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<TopicHour>> getAll() {
		List<TopicHour> res;
		try {
			res = topicHourService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<TopicHour>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<TopicHour>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<TopicHour>>(RESTResponse.FAIL, "Servicios no disponibles.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<TopicHour> getOne(@PathVariable Integer id) {
		TopicHour res;
		try {
			res = topicHourService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<TopicHour>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<TopicHour>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<TopicHour>(RESTResponse.FAIL, "Horas de tema no registradas.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<TopicHour> post(@RequestBody RESTRequest<TopicHour> topicHour) {
		try {
			if(topicHourService.getOne(topicHour.getPayload().getId()) != null)
                return new RESTResponse<TopicHour>(RESTResponse.FAIL, "Las horas de tema ya existen en el sistema.", null);
			topicHourService.add(topicHour.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<TopicHour>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<TopicHour>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<TopicHour> patch(@RequestBody RESTRequest<TopicHour> topicHour) {
		try {
			topicHourService.update(topicHour.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<TopicHour>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<TopicHour>(RESTResponse.OK, "Horas de tema modificadas.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<TopicHour> put(@RequestBody RESTRequest<TopicHour> topicHour) {
		try {
			topicHourService.update(topicHour.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<TopicHour>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<TopicHour>(RESTResponse.OK, "Horas de tema modificadas.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<TopicHour> delete(@PathVariable Integer id) {
		try {
			topicHourService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<TopicHour>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<TopicHour>(RESTResponse.OK, "Horas de tema modificadas.", null);
	}
}
