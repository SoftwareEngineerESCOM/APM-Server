package com.apms.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/autor")
public class AutorController {
	@Autowired
	private AutorRepository autorRepository;

	@PostMapping("/crear")
	public @ResponseBody boolean crearAutor(@RequestBody Autor autor) {
		autorRepository.save(autor);
		return true;
	}
}
