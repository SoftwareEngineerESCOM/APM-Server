package com.apms.gradodeestudio;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController() 
@RequestMapping("/gradoDeEstudio")

public class GradoDeEstudioController {

	@Autowired
	private GradoDeEstudioRepository repo;
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearGradoDeEstudio(@RequestBody Map<String, Object> datos) {
		GradoDeEstudio gradoDeEstudio = new GradoDeEstudio((String)datos.get("nivelAcademico"),
				(String)datos.get("especialidad"));
		repo.save(gradoDeEstudio);
		return true;
	}
	

}
