package com.apms.workplace;

import java.util.ArrayList;
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
import com.apms.role.Role;
import com.apms.role.RoleService;
import com.apms.user.User;
import com.apms.user.UserService;

@RestController
@RequestMapping("/workplace")
public class WorkplaceRestController {

	@Autowired
	private WorkplaceService workplaceService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Workplace>> getAll() {
		List<Workplace> res;
		try {
			res = workplaceService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Workplace>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Workplace>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Workplace>>(RESTResponse.FAIL, "Servicios no disponibles.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Workplace> getOne(@PathVariable Integer id) {
		Workplace res;
		try {
			res = workplaceService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Workplace>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Workplace>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Workplace>(RESTResponse.FAIL, "Unidad no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Workplace> post(@RequestBody RESTRequest<Workplace> workplace) {
		try {
			if(workplaceService.getOne(workplace.getPayload().getId()) != null)
                return new RESTResponse<Workplace>(RESTResponse.FAIL, "La Unidad ya existe en el sistema.", null);
			workplaceService.add(workplace.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Workplace>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Workplace>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Workplace> patch(@RequestBody RESTRequest<Workplace> workplace) {
		try {
			workplaceService.update(workplace.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Workplace>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Workplace>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Workplace> put(@RequestBody RESTRequest<Workplace> workplace) {
		try {
			workplaceService.update(workplace.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Workplace>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Workplace>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Workplace> delete(@PathVariable Integer id) {
		try {
			workplaceService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Workplace>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Workplace>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	@GetMapping("/workplacesForUser/{id}")
	public RESTResponse<List<Workplace>> workplacesForUser(@PathVariable Integer id) {
		User res;
		try {
			res = userService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Workplace>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			List<Workplace> aux;
			try {
				Role userRole = roleService.getMaxRoleByUserId(res.getId());
				if (userRole.getRank() > 4) {
					aux = workplaceService.getAll();
				}else{
					aux = new ArrayList<Workplace>();
					aux.add(res.getHumanResource().getWorkplace());
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new RESTResponse<List<Workplace>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
			}
			if (!aux.isEmpty()) {
				return new RESTResponse<List<Workplace>>(RESTResponse.OK, "", aux);
			} else {
				return new RESTResponse<List<Workplace>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
			}
		} else {
			return new RESTResponse<List<Workplace>>(RESTResponse.FAIL, "Usuario no registrado.", null);
		}
	}

	@GetMapping("/academicUnits/{id}")
	public RESTResponse<List<Workplace>> academicUnits(@PathVariable Integer id) {
		User res;
		try {
			res = userService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Workplace>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			List<Workplace> aux;
			try {
				Role userRole = roleService.getMaxRoleByUserId(res.getId());
				if (userRole.getRank() > 4) {
					aux = workplaceService.getAcademicUnits();
				}else{
					aux = new ArrayList<Workplace>();
					aux.add(res.getHumanResource().getWorkplace());
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new RESTResponse<List<Workplace>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
			}
			if (!aux.isEmpty()) {
				return new RESTResponse<List<Workplace>>(RESTResponse.OK, "", aux);
			} else {
				return new RESTResponse<List<Workplace>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
			}
		} else {
			return new RESTResponse<List<Workplace>>(RESTResponse.FAIL, "Usuario no registrado.", null);
		}
	}
}
