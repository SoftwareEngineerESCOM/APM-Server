package com.apms.subtema;

//import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController() 
@RequestMapping("/subtema")

public class SubtemaController {
	
	@Autowired 
	private SubtemaRepository repo; 
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearSubtema (@RequestBody Map<String, Object> datos) {
		Subtema subtema = new Subtema();
		return true;
	}

	
}