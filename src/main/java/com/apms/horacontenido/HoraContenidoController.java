package com.apms.horacontenido;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController() 
@RequestMapping("/horaContenido")

public class HoraContenidoController {
	
	@Autowired
	private HoraContenidoRepository repo;
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearHoraContenido(@RequestBody Map<String, Object> datos) {
		HoraContenido horaContenido = new HoraContenido(Double.parseDouble((String)datos.get("teoricaDocencia")),
				Double.parseDouble((String)datos.get("practicaDocencia")),
				Double.parseDouble((String)datos.get("autonomo")));
		repo.save(horaContenido);
		return true;
	}
}
