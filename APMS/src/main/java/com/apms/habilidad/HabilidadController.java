package com.apms.habilidad;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController() 
@RequestMapping("/habilidad")
public class HabilidadController {

	@Autowired
	private HabilidadRepository repo;
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearHabilidad(@RequestBody Map<String, Object> datos) {
		Habilidad habilidad = new Habilidad((String)datos.get("nombre"));
		repo.save(habilidad);
		return true;
	}
}
