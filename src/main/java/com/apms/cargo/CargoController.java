package com.apms.cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/cargo")
public class CargoController {
	@Autowired
	private CargoRepository cargoRepository;

	@PostMapping("/crear")
	public @ResponseBody boolean crearCargo(@RequestBody Cargo cargo) {
		cargoRepository.save(cargo);
		return true;
	}

}
