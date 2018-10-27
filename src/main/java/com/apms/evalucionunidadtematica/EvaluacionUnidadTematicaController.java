package com.apms.evalucionunidadtematica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/evaluacionunidadtematica")
public class EvaluacionUnidadTematicaController {
	@Autowired
	private EvaluacionUnidadTematicaRepository evaluacionUnidadTematicaRepository;

	@PostMapping("/crear")
	public @ResponseBody boolean crearEvaluacionUnidadTematica(
			@RequestBody EvaluacionUnidadTematica evaluacionUnidadTematica) {
		evaluacionUnidadTematicaRepository.save(evaluacionUnidadTematica);
		return true;
	}
}
