package com.apms.semester;

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

import com.apms.learningUnit.LearningUnit;
import com.apms.learningUnit.LearningUnitService;
import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;

@RestController
@RequestMapping("/semester")
public class SemesterRestController {

	@Autowired
	private SemesterService semesterService;

	@Autowired
	private LearningUnitService learningUnitService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Semester>> getAll() {
		List<Semester> res;
		try {
			res = semesterService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Semester>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Semester>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Semester>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Semester> getOne(@PathVariable Integer id) {
		Semester res;
		try {
			res = semesterService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Semester>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Semester>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Semester>(RESTResponse.FAIL, "Semestre no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Semester> post(@RequestBody RESTRequest<Semester> semester) {
		try {
			if (semesterService.getOne(semester.getPayload().getId()) != null)
				return new RESTResponse<Semester>(RESTResponse.FAIL, "El semestre ya existe en el sistema.", null);
			Semester aux = semesterService
					.getMaxSemesterNumberByStudyPlanId(semester.getPayload().getStudyPlan().getId());
			if (aux != null) {
				String sAcademicProgram = semester.getPayload().getStudyPlan().getAcademicProgram().getName();
				if (sAcademicProgram.equalsIgnoreCase("Médico Cirujano y Homeópata")
						|| sAcademicProgram.equalsIgnoreCase("Médico Cirujano y Partero")) {
					if (aux.getSemesterNumber() == 14) {
						return new RESTResponse<Semester>(RESTResponse.FAIL,
								"Se alcanzó el número máximo de semestres.", null);
					}
				} else if (aux.getSemesterNumber() == 8) {
					return new RESTResponse<Semester>(RESTResponse.FAIL, "Se alcanzó el número máximo de semestres.",
							null);
				}
				semester.getPayload().setSemesterNumber(aux.getSemesterNumber() + 1);
			} else {
				semester.getPayload().setSemesterNumber(1);
			}
			semesterService.add(semester.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Semester>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Semester>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Semester> patch(@RequestBody RESTRequest<Semester> semester) {
		try {
			semesterService.update(semester.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Semester>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Semester>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Semester> put(@RequestBody RESTRequest<Semester> semester) {
		try {
			semesterService.update(semester.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Semester>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Semester>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Semester> delete(@PathVariable Integer id) {
		List<LearningUnit> learningUnits;
		try {
			learningUnits = learningUnitService.getLearningUnitsBySemesterId(id);
			if (learningUnits.isEmpty()) {
				semesterService.delete(id);
			} else {
				return new RESTResponse<Semester>(RESTResponse.FAIL,
						"El semestre no se puede eliminar debido a que contiene unidades de aprendizaje.", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Semester>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Semester>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	@GetMapping("/semestersByStudyPlanId/{id}")
	public RESTResponse<List<Semester>> getSemestersByStudyPlanId(@PathVariable Integer id) {
		List<Semester> res;
		try {
			res = semesterService.getSemestersByStudyPlanId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Semester>>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Semester>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Semester>>(RESTResponse.FAIL, "Semestres no registrados.", null);
		}
	}
}
