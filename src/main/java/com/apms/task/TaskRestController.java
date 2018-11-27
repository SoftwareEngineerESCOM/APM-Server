package com.apms.task;

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
import java.util.List;;

@RestController
@RequestMapping("/task")
public class TaskRestController {
	
	private TaskService taskService;
	
	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Task>> getAll() {
		List<Task> res;
		try {
			res = taskService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Task>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Task>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Task>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Task> getOne(@PathVariable Integer id) {
		Task res;
		try {
			res = taskService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Task>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Task>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Task>(RESTResponse.FAIL, "Tarea no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Task> post(@RequestBody RESTRequest<Task> task) {
		try {
			if (taskService.getOne(task.getPayload().getId()) != null)
				return new RESTResponse<Task>(RESTResponse.FAIL, "La tarea ya existe en el sistema.", null);
			taskService.add(task.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Task>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Task>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Task> patch(@RequestBody RESTRequest<Task> task) {
		try {
			taskService.update(task.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Task>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Task>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Task> put(@RequestBody RESTRequest<Task> task) {
		try {
			taskService.update(task.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Task>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Task>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Task> delete(@PathVariable Integer id) {
		try {
			taskService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Task>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Task>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
	
}
