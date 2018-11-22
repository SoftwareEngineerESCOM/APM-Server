package com.apms.academicProgram;

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
@RequestMapping("/academicProgram")
public class AcademicProgramRestController {

	@Autowired
	private AcademicProgramService academicProgramService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<AcademicProgram>> getAll() {
		List<AcademicProgram> res;
		try {
			res = academicProgramService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<AcademicProgram>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<AcademicProgram>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<AcademicProgram>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<AcademicProgram> getOne(@PathVariable Integer id) {
		AcademicProgram res;
		try {
			res = academicProgramService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<AcademicProgram>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<AcademicProgram>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<AcademicProgram>(RESTResponse.FAIL, "Programa academico no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<AcademicProgram> post(@RequestBody RESTRequest<AcademicProgram> academicProgram) {
		try {
			if(!academicProgramService.getAcademicProgramByNameAndWorkplaceId(academicProgram.getPayload().getName(), academicProgram.getPayload().getWorkplace().getId()).isEmpty())
                return new RESTResponse<AcademicProgram>(RESTResponse.FAIL, "Programa academico ya existe en el sistema.", null);
			academicProgramService.add(academicProgram.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<AcademicProgram>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<AcademicProgram>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<AcademicProgram> patch(@RequestBody RESTRequest<AcademicProgram> academicProgram) {
		try {
			academicProgramService.update(academicProgram.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<AcademicProgram>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<AcademicProgram>(RESTResponse.OK, "Programa academico modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<AcademicProgram> put(@RequestBody RESTRequest<AcademicProgram> academicProgram) {
		try {
			academicProgramService.update(academicProgram.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<AcademicProgram>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<AcademicProgram>(RESTResponse.OK, "Programa academico modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<AcademicProgram> delete(@PathVariable Integer id) {
		try {
			academicProgramService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<AcademicProgram>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<AcademicProgram>(RESTResponse.OK, "Programa academico modificado.", null);
	}

	@GetMapping("/academicProgramsByWorkPlaceId/{id}")
	public RESTResponse<List<AcademicProgram>> getAcademicProgramsByWorkPlaceId(@PathVariable Integer id) {
		return new RESTResponse<List<AcademicProgram>>(RESTResponse.OK, "",
				academicProgramService.getAcademicProgramsByWorkPlaceId(id));
	}
}
