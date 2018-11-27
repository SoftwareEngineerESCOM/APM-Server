package com.apms.teachingProfile;

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
@RequestMapping("/teachingProfile")
public class TeachingProfileRestController {

	@Autowired
	private TeachingProfileService teachingProfileService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<TeachingProfile>> getAll() {
		List<TeachingProfile> res;
		try {
			res = teachingProfileService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<TeachingProfile>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<TeachingProfile>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<TeachingProfile>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<TeachingProfile> getOne(@PathVariable Integer id) {
		TeachingProfile res;
		try {
			res = teachingProfileService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<TeachingProfile>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<TeachingProfile>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<TeachingProfile>(RESTResponse.FAIL, "Perfil docente no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<TeachingProfile> post(@RequestBody RESTRequest<TeachingProfile> teachingProfile) {
		try {
			if(teachingProfileService.getOne(teachingProfile.getPayload().getId()) != null)
                return new RESTResponse<TeachingProfile>(RESTResponse.FAIL, "El perfil docente ya existe en el sistema.", null);
			teachingProfileService.add(teachingProfile.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<TeachingProfile>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<TeachingProfile>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<TeachingProfile> patch(@RequestBody RESTRequest<TeachingProfile> teachingProfile) {
		try {
			teachingProfileService.update(teachingProfile.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<TeachingProfile>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<TeachingProfile>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<TeachingProfile> put(@RequestBody RESTRequest<TeachingProfile> teachingProfile) {
		try {
			teachingProfileService.update(teachingProfile.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<TeachingProfile>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<TeachingProfile>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<TeachingProfile> delete(@PathVariable Integer id) {
		try {
			teachingProfileService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<TeachingProfile>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<TeachingProfile>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
}
