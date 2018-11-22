package com.apms.schoolingGrade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;

@RestController
@RequestMapping("/schoolingGrade")
public class SchoolingGradeRestController {

	@Autowired
	private SchoolingGradeService schoolingGradeService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<SchoolingGrade>> getAll() {
		List<SchoolingGrade> res;
		try {
			res = schoolingGradeService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<SchoolingGrade>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<SchoolingGrade>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<SchoolingGrade>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<SchoolingGrade> getOne(@PathVariable Integer id) {
		SchoolingGrade res;
		try {
			res = schoolingGradeService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<SchoolingGrade>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<SchoolingGrade>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<SchoolingGrade>(RESTResponse.FAIL, "Grado de estudio no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<SchoolingGrade> post(@RequestBody RESTRequest<SchoolingGrade> schoolingGrade) {
		try {
			if(schoolingGradeService.getOne(schoolingGrade.getPayload().getId()) != null)
                return new RESTResponse<SchoolingGrade>(RESTResponse.FAIL, "El grado de estudio ya existe en el sistema.", null);
			schoolingGradeService.add(schoolingGrade.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<SchoolingGrade>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<SchoolingGrade>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<SchoolingGrade> patch(@RequestBody RESTRequest<SchoolingGrade> schoolingGrade) {
		try {
			schoolingGradeService.update(schoolingGrade.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<SchoolingGrade>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<SchoolingGrade>(RESTResponse.OK, "Grado de estudio modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<SchoolingGrade> put(@RequestBody RESTRequest<SchoolingGrade> schoolingGrade) {
		try {
			schoolingGradeService.update(schoolingGrade.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<SchoolingGrade>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<SchoolingGrade>(RESTResponse.OK, "Grado de estudio modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<SchoolingGrade> delete(@PathVariable Integer id) {
		try {
			schoolingGradeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<SchoolingGrade>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<SchoolingGrade>(RESTResponse.OK, "Grado de estudio modificado.", null);
	}
}
