package com.apms.user;

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
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<User>> getAll() {
		List<User> res;
		try {
			res = userService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<User>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<User>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<User>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<User> getOne(@PathVariable Integer id) {
		User res;
		try {
			res = userService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<User>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<User>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<User>(RESTResponse.FAIL, "Usuario no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<User> post(@RequestBody RESTRequest<User> user) {
		try {
<<<<<<< HEAD
			if(userService.getOne(user.getPayload().getId()) != null)
                return new RESTResponse<User>(RESTResponse.FAIL, "Usuario ya existe en el sistema.", null);
=======
			if (userService.getOne(user.getPayload().getId()) != null)
				return new RESTResponse<User>(RESTResponse.FAIL, "User ya existe en el sistema.", null);
>>>>>>> 7c6e410c28dd5093f0267832745286e730bf6fae
			userService.add(user.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<User>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<User>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<User> patch(@RequestBody RESTRequest<User> user) {
		try {
			userService.update(user.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<User>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<User>(RESTResponse.OK, "Usuario modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<User> put(@RequestBody RESTRequest<User> user) {
		try {
			userService.update(user.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<User>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<User>(RESTResponse.OK, "Usuario modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<User> delete(@PathVariable Integer id) {
		User res;
		try {
			res = userService.getOne(id);
			res.setAccountBlocked(true);
			userService.update(res);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<User>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<User>(RESTResponse.OK, "Usuario modificado.", null);
	}

	@GetMapping("/usersByWorkplaceIdAndPositionId/{idW}/{idP}")
	public RESTResponse<List<User>> getUsersByWorkplaceIdAndPositionId(@PathVariable Integer idW,
			@PathVariable Integer idP) {
		List<User> res = userService.getUsersByWorkplaceIdAndPositionId(idW, idP);
		if (!res.isEmpty()) {
			return new RESTResponse<List<User>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<User>>(RESTResponse.FAIL, "No hay usuarios registrados con ese cargo.", res);
		}
	}

	@PostMapping("/userByEmailAndPassword")
	public RESTResponse<User> getUserByEmailAndPassword(@RequestBody RESTRequest<User> req) {
		List<User> res;
		try {
			res = userService.getUserByEmailAndPassword(req.getPayload().getEmail(), req.getPayload().getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<User>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<User>(RESTResponse.OK, "", res.get(0));
		} else {
			return new RESTResponse<User>(RESTResponse.FAIL, "Correo y/o contraseña no válidas.", null);
		}
	}

	@GetMapping("/usersByWorkplaceId/{id}")
	public RESTResponse<List<User>> getUsersByWorkplaceId(@PathVariable Integer id) {
		List<User> res;
		try {
			res = userService.getUsersByWorkplaceId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<User>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<User>>(RESTResponse.OK, "", res);
		} else {
<<<<<<< HEAD
			return new RESTResponse<List<User>>(RESTResponse.FAIL, "Los cátalogos necesarios no se han cargado.", null);
=======
			return new RESTResponse<List<User>>(RESTResponse.FAIL,
					"Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.", null);
>>>>>>> 7c6e410c28dd5093f0267832745286e730bf6fae
		}
	}

	@GetMapping("/userByEmail/{email}")
	public RESTResponse<User> userByEmail(@PathVariable String email) {
		User res;
		try {
			res = userService.getOne(email);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<User>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<User>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<User>(RESTResponse.FAIL, "Usuario no registrado.", null);
		}
	}

	@GetMapping("/userByName/{name}/{first_surname}/{second_surname}")
	public RESTResponse<User> userByName(@PathVariable String name, @PathVariable String first_surname,
			@PathVariable String second_surname) {
		User res;
		try {
			res = userService.getOne(name, first_surname, second_surname);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<User>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<User>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<User>(RESTResponse.FAIL, "Usuario no registrado.", null);
		}
	}

	@GetMapping("/activeUsers")
	public RESTResponse<List<User>> activeUsers() {
		List<User> res;
		try {
			res = userService.getActiveUsers();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<User>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<User>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<User>>(RESTResponse.FAIL, "Usuario no registrado.", null);
		}
	}

	@GetMapping("/activeUsersForUser/{id}")
	public RESTResponse<List<User>> activeUsersForUser(@PathVariable Integer id) {
		User res;
		try {
			res = userService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<User>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			List<User> aux;
			try {
				if (res.getHumanResource().getWorkplace().getAbbreviation() == "DES") {
					aux = userService.getActiveUsersForUserForDES(id);
				}else{
					aux = userService.getActiveUsersForUser(id, res.getHumanResource().getWorkplace().getId());
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new RESTResponse<List<User>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
			}
			if (!aux.isEmpty()) {
				return new RESTResponse<List<User>>(RESTResponse.OK, "", aux);
			} else {
				return new RESTResponse<List<User>>(RESTResponse.FAIL, "Los cátalogos necesarios no se han cargado.", null);
			}
		} else {
			return new RESTResponse<List<User>>(RESTResponse.FAIL, "Usuario no registrado.", null);
		}
	}

	@GetMapping("/activeUsersForUserByRole/{id}/{id_role}")
	public RESTResponse<List<User>> activeUsersForUserByRole(@PathVariable Integer id, @PathVariable Integer id_role) {
		User res;
		try {
			res = userService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<User>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			List<User> aux;
			try {
				if (res.getHumanResource().getWorkplace().getAbbreviation() == "DES") {
					aux = userService.getActiveUsersForUserByRoleForDES(id_role);
				}else{
					aux = userService.getActiveUsersForUserByRole(res.getHumanResource().getWorkplace().getId(), id_role);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new RESTResponse<List<User>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
			}
			if (!aux.isEmpty()) {
				return new RESTResponse<List<User>>(RESTResponse.OK, "", aux);
			} else {
				return new RESTResponse<List<User>>(RESTResponse.FAIL, "Los cátalogos necesarios no se han cargado.", null);
			}
		} else {
			return new RESTResponse<List<User>>(RESTResponse.FAIL, "Usuario no registrado.", null);
		}
	}
}
