package com.apms.learningUnit;

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
import com.apms.semester.Semester;
import com.apms.semester.SemesterService;

@RestController
@RequestMapping("/learningUnit")
public class LearningUnitRestController {

	@Autowired
	private LearningUnitService learningUnitService;

	@Autowired
	private SemesterService semesterService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<LearningUnit>> getAll() {
		List<LearningUnit> res;
		try {
			res = learningUnitService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<LearningUnit>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<LearningUnit> getOne(@PathVariable Integer id) {
		LearningUnit res;
		try {
			res = learningUnitService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnit>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<LearningUnit>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<LearningUnit>(RESTResponse.FAIL, "Unidad de apredizaje no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<LearningUnit> post(@RequestBody RESTRequest<LearningUnit> learningUnit) {
		try {
			if (!learningUnitService.getLearningUnitByNameAndSemesterId(learningUnit.getPayload().getName(),
					learningUnit.getPayload().getSemester().getId()).isEmpty())
				return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
						"Unidad de Aprendizaje ya existe en el sistema.", null);
			learningUnitService.add(learningUnit.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnit>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<LearningUnit> patch(@RequestBody RESTRequest<LearningUnit> learningUnit) {
		try {
			learningUnitService.update(learningUnit.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnit>(RESTResponse.OK, "Unidad de aprendizaje modificada.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<LearningUnit> put(@RequestBody RESTRequest<LearningUnit> learningUnit) {
		try {
			learningUnitService.update(learningUnit.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnit>(RESTResponse.OK, "Unidad de aprendizaje modificada.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<LearningUnit> delete(@PathVariable Integer id) {
		try {
			learningUnitService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnit>(RESTResponse.OK, "Unidad de aprendizaje modificada.", null);
	}

	@GetMapping("/learningUnitsBySemesterId/{id}")
	public RESTResponse<List<LearningUnit>> getLearningUnitsBySemesterId(@PathVariable Integer id) {
		List<LearningUnit> res;
		try {
			res = learningUnitService.getLearningUnitsBySemesterId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<LearningUnit>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

	@GetMapping("/learningUnitByNameAndSemesterId/{name}/{id}")
	public RESTResponse<List<LearningUnit>> getLearningUnitByNameAndSemesterId(@PathVariable String name,
			@PathVariable Integer id) {
		List<LearningUnit> res;
		try {
			res = learningUnitService.getLearningUnitByNameAndSemesterId(name, id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<LearningUnit>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

	@GetMapping("/changeLearningUnitToSemester/{learningUnitId}/{semesterId}")
	public RESTResponse<LearningUnit> changeLearningUnitToSemester(@PathVariable Integer learningUnitId,
			@PathVariable Integer semesterId) {
		Semester semester;
		LearningUnit res;
		try {
			semester = semesterService.getOne(semesterId);
			res = learningUnitService.getOne(learningUnitId);
			res.setSemester(semester);
			learningUnitService.update(res);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnit>(RESTResponse.OK, "Unidad de aprendizaje modificada.", null);
	}
}
