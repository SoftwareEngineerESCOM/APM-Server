package com.apms.role;

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

import com.apms.rest.RESTRequest;import java.util.logging.Logger;
import com.apms.rest.RESTResponse;

import com.apms.user.User;
import com.apms.user.UserService;
import com.apms.workplace.Workplace;
import com.apms.workplace.WorkplaceService;

@RestController
@RequestMapping("/role")
public class RoleRestController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Autowired
	private WorkplaceService workplaceService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Role>> getAll() {
		List<Role> res;
		try {
			res = roleService.getAll();
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<Role>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Role>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Role>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Role> getOne(@PathVariable Integer id) {
		Role res;
		try {
			res = roleService.getOne(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Role>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Role>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Role>(RESTResponse.FAIL, "Cargo no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Role> post(@RequestBody RESTRequest<Role> role) {
		try {
			if(roleService.getOne(role.getPayload().getId()) != null)
                return new RESTResponse<Role>(RESTResponse.FAIL, "El cargo ya existe en el sistema.", null);
			roleService.add(role.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Role>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Role>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Role> patch(@RequestBody RESTRequest<Role> role) {
		try {
			roleService.update(role.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Role>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Role>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Role> put(@RequestBody RESTRequest<Role> role) {
		try {
			roleService.update(role.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Role>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Role>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Role> delete(@PathVariable Integer id) {
		try {
			roleService.delete(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Role>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Role>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	@GetMapping("/rolesByUserId/{id}")
	public RESTResponse<List<Role>> rolesByUserId(@PathVariable Integer id) {
		List<Role> res;
		try {
			res = roleService.getRolesByUserId(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<Role>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Role>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Role>>(RESTResponse.FAIL, "Permisos insuficientes para ejecutar la operación.", null);
		}
	}

	@GetMapping("/rolesByUserIdAndWorkplaceId/{userId}/{workplaceId}")
	public RESTResponse<List<Role>> rolesByUserId(@PathVariable Integer userId, @PathVariable Integer workplaceId) {
		Workplace res = workplaceService.getOne(workplaceId);
		System.out.println(res.getAbbreviation());
		List<Role> auxRoles;
		try {
			if (res.getAbbreviation().equalsIgnoreCase("DES")) {
				auxRoles = roleService.getRolesByUserIdAndWorkplaceForDES(userId);
			}else{
				auxRoles = roleService.getRolesByUserIdAndWorkplace(userId);
			}
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<Role>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!auxRoles.isEmpty()) {
			return new RESTResponse<List<Role>>(RESTResponse.OK, "", auxRoles);
		} else {
			return new RESTResponse<List<Role>>(RESTResponse.FAIL, "Permisos insuficientes para ejecutar la operación.", null);
		}
	}

	@GetMapping("/maxRoleByUserId/{id}")
	public RESTResponse<Role> maxRoleByUserId(@PathVariable Integer id) {
		Role res;
		try {
			res = roleService.getMaxRoleByUserId(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Role>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Role>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Role>(RESTResponse.FAIL, "Servicios no disponibles.", null);
		}
	}
}
