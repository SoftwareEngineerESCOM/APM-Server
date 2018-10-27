package com.apms.ensenansa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/ensenansa")
public class EnsenansaController {
	@Autowired
	private EnsenansaRepository ensenansaRepository;

	@PostMapping("/crear")
	public @ResponseBody boolean crearEnsenansa(@RequestBody Ensenansa ensenansa) {
		ensenansaRepository.save(ensenansa);
		return true;
	}
}
