package com.apms.academia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/academia")
public class AcademiaController {

	@Autowired
	private AcademiaRepository academiaRepository;

	@PostMapping("/crear")
	public @ResponseBody boolean crearAcademia(@RequestBody Academia academia) {
		academiaRepository.save(academia);
		return true;
	}

}
