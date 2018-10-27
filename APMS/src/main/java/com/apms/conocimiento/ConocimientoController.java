package com.apms.conocimiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/conocimiento")
public class ConocimientoController {

	@Autowired
	private ConocimientoRepository conocimientoRepository;
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearConocimiento(@RequestBody Conocimiento conocimiento) {
		conocimientoRepository.save(conocimiento);
		return true;
	}
	
}
