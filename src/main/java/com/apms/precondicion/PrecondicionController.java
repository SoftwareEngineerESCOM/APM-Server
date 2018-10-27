package com.apms.precondicion;

//import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController() 
@RequestMapping("/precondicion")

public class PrecondicionController {
	
	@Autowired 
	private PrecondicionRepository repo; 
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearPrecondicion (@RequestBody Map<String, Object> datos) {
		Precondicion precondicion = new Precondicion();
		return true;
	}

	
}