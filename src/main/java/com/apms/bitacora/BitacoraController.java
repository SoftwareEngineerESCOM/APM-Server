package com.apms.bitacora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/bitacora")
public class BitacoraController {
	@Autowired
	private BitacoraRepository bitacoraRepository;

	@PostMapping("/crear")
	public @ResponseBody boolean crearBitacora(@RequestBody Bitacora bitacora) {
		bitacoraRepository.save(bitacora);
		return true;
	}
}
