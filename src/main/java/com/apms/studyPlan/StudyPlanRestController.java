package com.apms.studyPlan;

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

import com.apms.academicProgram.AcademicProgram;
import com.apms.academicProgram.AcademicProgramService;
import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;
import com.apms.semester.Semester;
import com.apms.semester.SemesterService;
import com.apms.statusStudyPlan.StatusStudyPlanService;

@RestController
@RequestMapping("/studyPlan")
public class StudyPlanRestController {

	@Autowired
	private StudyPlanService studyPlanService;

	@Autowired
	private AcademicProgramService academicProgramService;

	@Autowired
	private SemesterService semesterService;

	@Autowired
	private StatusStudyPlanService statusStudyPlanService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<StudyPlan>> getAll() {
		List<StudyPlan> res;
		try {
			res = studyPlanService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<StudyPlan>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<StudyPlan>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<StudyPlan>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<StudyPlan> getOne(@PathVariable Integer id) {
		StudyPlan res;
		try {
			res = studyPlanService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlan>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<StudyPlan>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<StudyPlan>(RESTResponse.FAIL, "Plan de estudio no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage. Estado de creacion
	 */
	@PostMapping
	public RESTResponse<StudyPlan> post(@RequestBody RESTRequest<StudyPlan> req) {
		if (req.getPayload().getTotalTEPICCredits() >= 350 && req.getPayload().getTotalTEPICCredits() <= 450) {
			try {
				StudyPlan aux = studyPlanService.getNewStudyPlan(req.getPayload().getAcademicProgram().getId());
				if (aux != null) {
					return new RESTResponse<StudyPlan>(RESTResponse.FAIL, "Ya se encuentra un Plan de Estudios en proceso.", null);
				}
				req.getPayload().setStatusStudyPlan(statusStudyPlanService.getOne(1));
				studyPlanService.add(req.getPayload());
			} catch (Exception e) {
				e.printStackTrace();
				return new RESTResponse<StudyPlan>(RESTResponse.FAIL,
						"Por el momento no se puede realizar el registro.", null);
			}
			return new RESTResponse<StudyPlan>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
		} else {
			return new RESTResponse<StudyPlan>(RESTResponse.FAIL, "Creditos TEPIC fuera de rango.", null);
		}
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<StudyPlan> patch(@RequestBody RESTRequest<StudyPlan> req) {
		if (req.getPayload().getTotalTEPICCredits() >= 350 && req.getPayload().getTotalTEPICCredits() <= 450) {
			try {
				studyPlanService.update(req.getPayload());
			} catch (Exception e) {
				e.printStackTrace();
				return new RESTResponse<StudyPlan>(RESTResponse.FAIL,
						"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
			}
			return new RESTResponse<StudyPlan>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
		} else {
			return new RESTResponse<StudyPlan>(RESTResponse.FAIL, "Creditos TEPIC fuera de rango.", null);
		}
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<StudyPlan> put(@RequestBody RESTRequest<StudyPlan> req) {
		if (req.getPayload().getTotalTEPICCredits() >= 350 && req.getPayload().getTotalTEPICCredits() <= 450) {
			try {
				studyPlanService.update(req.getPayload());
			} catch (Exception e) {
				e.printStackTrace();
				return new RESTResponse<StudyPlan>(RESTResponse.FAIL,
						"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
			}
			return new RESTResponse<StudyPlan>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
		} else {
			return new RESTResponse<StudyPlan>(RESTResponse.FAIL, "Creditos TEPIC fuera de rango.", null);
		}
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<StudyPlan> delete(@PathVariable Integer id) {
		try {
			studyPlanService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlan>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<StudyPlan>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	@GetMapping("/studyPlansByAcademicProgramId/{id}")
	public RESTResponse<List<StudyPlan>> getStudyPlansByAcademicProgramId(@PathVariable Integer id) {
		AcademicProgram res;
		try {
			res = academicProgramService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<StudyPlan>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			List<StudyPlan> aux;
			try {
				aux = studyPlanService.getStudyPlansByAcademicProgramId(id);
			} catch (Exception e) {
				e.printStackTrace();
				return new RESTResponse<List<StudyPlan>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
						null);
			}
			if (!aux.isEmpty()) {
				return new RESTResponse<List<StudyPlan>>(RESTResponse.OK, "", aux);
			} else {
				return new RESTResponse<List<StudyPlan>>(RESTResponse.FAIL, "No se encuentran planes de estudios registrados.", null);
			}
		} else {
			return new RESTResponse<List<StudyPlan>>(RESTResponse.FAIL, "Programa Académico no registrado.", null);
		}
	}

	// Redisenio

	@GetMapping("/createCopy/{id}")
	public RESTResponse<StudyPlan> createCopy(@PathVariable Integer id) {
		StudyPlan res;
		try {
			res = studyPlanService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<StudyPlan>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			StudyPlan checkAcademicProgram = studyPlanService.getNewStudyPlan(res.getAcademicProgram().getId());
			if (checkAcademicProgram != null) {
				return new RESTResponse<StudyPlan>(RESTResponse.FAIL, "Ya se encuentra un Plan de Estudios en proceso.", null);
			}
			StudyPlan aux = new StudyPlan();
			aux.setYear(res.getYear());
			aux.setTotalTEPICCredits(res.getTotalTEPICCredits());
			aux.setTotalSATCACredits(res.getTotalSATCACredits());
			aux.setTotalTheoryHours(res.getTotalTheoryHours());
			aux.setTotalPracticeHours(res.getTotalPracticeHours());
			aux.setModality(res.getModality());
			aux.setAcademicProgram(res.getAcademicProgram());
			aux.setStatusStudyPlan(statusStudyPlanService.getOne(2));
			try {
				studyPlanService.add(aux);
				List<Semester> auxSemester = semesterService.getSemestersByStudyPlanId(res.getId());
				studyPlanService.setSemestersToCopy(res.getId(), aux.getId());
				auxSemester.forEach(semester -> {
					studyPlanService.setLearningUnitsToCopy(res.getId(), aux.getId(), semester.getSemesterNumber());
				});
			} catch (Exception e) {
				e.printStackTrace();
				return new RESTResponse<StudyPlan>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
			}
			if (aux != null) {
				return new RESTResponse<StudyPlan>(RESTResponse.OK, "", aux);
			} else {
				return new RESTResponse<StudyPlan>(RESTResponse.FAIL, "Servicios no disponibles.", null);
			}
		} else {
			return new RESTResponse<StudyPlan>(RESTResponse.FAIL, "Plan de Estudios no registrado.", null);
		}
	}
}
