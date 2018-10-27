package com.apms.evaluacionunidaddeaprendizaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/evaluacionunidaddeaprendizaje")
public class EvaluacionUnidadDeAprendizajeController {

	@Autowired
	private EvaluacionUnidadDeAprendizajeRepository evaluacionUnidadDeAprendizajeRepository;

	@PostMapping("/crear")
	public @ResponseBody boolean crearEvaluacionUnidadDeAprendizaje(
			@RequestBody EvaluacionUnidadDeAprendizaje evaluacionUnidadDeAprendizaje) {
		evaluacionUnidadDeAprendizajeRepository.save(evaluacionUnidadDeAprendizaje);
		return true;
	}

}
