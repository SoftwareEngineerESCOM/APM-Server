package com.apms.professionalExperience;

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
@RequestMapping("/professionalExperience")
public class ProfessionalExperienceRestController {

	@Autowired
	private ProfessionalExperienceService professionalExperienceService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<ProfessionalExperience>> getAll() {
		List<ProfessionalExperience> res;
		try {
			res = professionalExperienceService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<ProfessionalExperience>>(RESTResponse.DBFAIL,
					"Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<ProfessionalExperience>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<ProfessionalExperience>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<ProfessionalExperience> getOne(@PathVariable Integer id) {
		ProfessionalExperience res;
		try {
			res = professionalExperienceService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ProfessionalExperience>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (res != null) {
			return new RESTResponse<ProfessionalExperience>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<ProfessionalExperience>(RESTResponse.FAIL, "Experiencia profesional no registrada.",
					null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<ProfessionalExperience> post(
			@RequestBody RESTRequest<ProfessionalExperience> professionalExperience) {
		try {
			if(professionalExperienceService.getOne(professionalExperience.getPayload().getId()) != null)
                return new RESTResponse<ProfessionalExperience>(RESTResponse.FAIL, "Experiencia profesional ya existe en el sistema.", null);
			professionalExperienceService.add(professionalExperience.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ProfessionalExperience>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ProfessionalExperience>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<ProfessionalExperience> patch(
			@RequestBody RESTRequest<ProfessionalExperience> professionalExperience) {
		try {
			professionalExperienceService.update(professionalExperience.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ProfessionalExperience>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ProfessionalExperience>(RESTResponse.OK, "Experiencia profesional modificada.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<ProfessionalExperience> put(
			@RequestBody RESTRequest<ProfessionalExperience> professionalExperience) {
		try {
			professionalExperienceService.update(professionalExperience.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ProfessionalExperience>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ProfessionalExperience>(RESTResponse.OK, "Experiencia profesional modificada.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<ProfessionalExperience> delete(@PathVariable Integer id) {
		try {
			professionalExperienceService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ProfessionalExperience>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ProfessionalExperience>(RESTResponse.OK, "Experiencia profesional modificada.", null);
	}
}
