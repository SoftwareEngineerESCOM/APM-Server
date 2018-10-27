package com.apms.tema;

//import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController() 
@RequestMapping("/tema")

public class TemaController {
	
	@Autowired 
	private TemaRepository repo; 
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearTema (@RequestBody Map<String, Object> datos) {
		Tema tema = new Tema();
		return true;
	}

	
}