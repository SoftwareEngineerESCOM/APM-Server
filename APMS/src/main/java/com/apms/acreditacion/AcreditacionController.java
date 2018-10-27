package com.apms.acreditacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/acreditacion")
public class AcreditacionController {
	@Autowired
	private AcreditacionRepository acreditacionRepository;
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearAcreditacion (@RequestBody Acreditacion acreditacion) {
		acreditacionRepository.save(acreditacion);
		return true;
	}
}
