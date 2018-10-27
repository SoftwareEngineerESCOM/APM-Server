package com.apms.perfil;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController() 
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilRepository repo;
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearPerfil(@RequestBody Map<String, Object> datos) {
		Perfil perfil = new Perfil((String)datos.get("nombre"));
		repo.save(perfil);
		return true;
	}
}
