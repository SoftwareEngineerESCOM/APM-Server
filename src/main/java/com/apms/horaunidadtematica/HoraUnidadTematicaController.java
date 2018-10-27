package com.apms.horaunidadtematica;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController() 
@RequestMapping("/horaUnidadTematica")
public class HoraUnidadTematicaController {

	@Autowired
	private HoraUnidadTematicaRepository repo;
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearHoraUnidadTematica(@RequestBody Map<String, Object> datos) {
		HoraUnidadTematica horaUnidadTematica = new HoraUnidadTematica(Double.parseDouble((String)datos.get("teoricaTotalDocencia")),
				Double.parseDouble((String)datos.get("practicaTotalDocencia")),
				Double.parseDouble((String)datos.get("totalAutonomo")));
		repo.save(horaUnidadTematica);
		return true;
	}
}
