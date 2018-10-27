package com.apms.bibliografia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/bibliografia")
public class BibliografiaController {

	@Autowired
	private BibliografiaRepository bibliografiaRepository;

	@PostMapping("/crear")
	public @ResponseBody boolean crearBibliografia(@RequestBody Bibliografia bibliografia) {
		bibliografiaRepository.save(bibliografia);
		return true;
	}

}
