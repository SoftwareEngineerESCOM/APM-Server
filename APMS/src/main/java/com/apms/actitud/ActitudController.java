package com.apms.actitud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/actitud")
public class ActitudController {
	@Autowired
	private ActitudRepository actitudRepository;

	@PostMapping("/crear")
	public @ResponseBody boolean crearActitud(@RequestBody Actitud actitud) {
		actitudRepository.save(actitud);
		return true;
	}
}
