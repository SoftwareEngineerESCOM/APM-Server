package com.apms.experienciaprofesional;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController() 
@RequestMapping("/experienciaProfesional")

public class ExperienciaProfesionalController {
	@Autowired 
	private ExperienciaProfesionalRepository repo;
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearExperienciaProfesional(@RequestBody Map<String, Object> datos) {
		ExperienciaProfesional experienciaProfesional = new ExperienciaProfesional((String)datos.get("nombre"));
		repo.save(experienciaProfesional);
		return true;
	}
	
}
