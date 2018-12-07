package com.apms.learningUnit;

import java.util.List;

import com.apms.learningUnitStatus.LearningUnitStatusService;
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

	@Autowired
	private LearningUnitStatusService learningUnitStatusService;

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
			return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
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
	public RESTResponse<LearningUnit> post(@RequestBody RESTRequest<LearningUnit> req) {
		try {
			if (!learningUnitService.getLearningUnitByNameAndStudyPlanId(req.getPayload().getName(),
					req.getPayload().getSemester().getStudyPlan().getId()).isEmpty())
				return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
						"Unidad de Aprendizaje ya existe en el sistema.", null);
			req.getPayload().setLearningUnitStatus(learningUnitStatusService.getOne(req.getPayload().getLearningUnitStatus().getId()));
			learningUnitService.add(req.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnit>(RESTResponse.FAIL, "Por el momento no se puede realizar el registro.",
					null);
		}
		return new RESTResponse<LearningUnit>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<LearningUnit> patch(@RequestBody RESTRequest<LearningUnit> req) {
		try {
			LearningUnit dbLearningUnitById = learningUnitService.getOne(req.getPayload().getId());
			if (!req.getPayload().getName().equalsIgnoreCase(dbLearningUnitById.getName())) {
				if (learningUnitService.getLearningUnitByNameAndStudyPlanId(req.getPayload().getName(),
						req.getPayload().getSemester().getStudyPlan().getId()) != null)
					return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
							"Unidad de Aprendizaje ya existe en el sistema.", null);
			}
			learningUnitService.update(req.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);

	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<LearningUnit> put(@RequestBody RESTRequest<LearningUnit> req) {
		try {
			LearningUnit dbLearningUnitById = learningUnitService.getOne(req.getPayload().getId());
			if (!req.getPayload().getName().equalsIgnoreCase(dbLearningUnitById.getName())) {
				if (learningUnitService.getLearningUnitByNameAndStudyPlanId(req.getPayload().getName(),
						req.getPayload().getSemester().getStudyPlan().getId()) != null)
					return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
							"Unidad de Aprendizaje ya existe en el sistema.", null);
			}
			learningUnitService.update(req.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<LearningUnit>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<LearningUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
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
			return new RESTResponse<LearningUnit>(RESTResponse.FAIL, "Por el momento no se puede realizar el registro.",
					null);
		}
		return new RESTResponse<LearningUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	@GetMapping("/learningUnitsBySemesterId/{id}")
	public RESTResponse<List<LearningUnit>> getLearningUnitsBySemesterId(@PathVariable Integer id) {
		Semester res;
		try {
			res = semesterService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (res != null) {
			List<LearningUnit> aux;
			try {
				aux = learningUnitService.getLearningUnitsBySemesterId(id);
			} catch (Exception e) {
				e.printStackTrace();
				return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
						null);
			}
			if (!aux.isEmpty()) {
				return new RESTResponse<List<LearningUnit>>(RESTResponse.OK, "", aux);
			} else {
				return new RESTResponse<List<LearningUnit>>(RESTResponse.OK,
						"El semestre no cuenta con unidades de aprendizaje.", aux);
			}
		} else {
			return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL, "Semestre no registrado.", null);
		}
	}

	@GetMapping("/learningUnitByNameAndSemesterId/{name}/{id}")
	public RESTResponse<List<LearningUnit>> learningUnitByNameAndSemesterId(@PathVariable String name,
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
			return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
		}
	}

	@GetMapping("/learningUnitByNameAndStudyPlanId/{name}/{id}")
	public RESTResponse<List<LearningUnit>> learningUnitByNameAndStudyPlanId(@PathVariable String name,
			@PathVariable Integer id) {
		List<LearningUnit> res;
		try {
			res = learningUnitService.getLearningUnitByNameAndStudyPlanId(name, id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<LearningUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<LearningUnit>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<LearningUnit>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
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
		return new RESTResponse<LearningUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
