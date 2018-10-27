package com.apms.funcionmapacurricular;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController() 
@RequestMapping("/funcionMapaCurricular")

public class FuncionMapaCurricularController {
	@Autowired 
	private FuncionMapaCurricularRepository repo;
	
	@PostMapping("/crear")
	public @ResponseBody boolean crearFuncionMapaCurricular(@RequestBody Map<String, Object> datos) {
		FuncionMapaCurricular funcionMapaCurricular = new FuncionMapaCurricular();
		return true;
	}
}
