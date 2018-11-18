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
			return new RESTResponse<List<User>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.", null);
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
			return new RESTResponse<User>(RESTResponse.FAIL, "User no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<User> post(@RequestBody RESTRequest<User> user) {
		try {
			if(userService.getOne(user.getPayload().getId()) != null)
                return new RESTResponse<User>(RESTResponse.FAIL, "User ya existe en el sistema.", null);
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
		return new RESTResponse<User>(RESTResponse.OK, "User modificado.", null);
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
		return new RESTResponse<User>(RESTResponse.OK, "User modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<User> delete(@PathVariable Integer id) {
		try {
			userService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<User>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<User>(RESTResponse.OK, "User modificado.", null);
	}

	@GetMapping("/usersByWorkplaceIdAndPositionId/{idW}/{idP}")
	public RESTResponse<List<User>> getUsersByWorkplaceIdAndPositionId(@PathVariable Integer idW,
			@PathVariable Integer idP) {
		List<User> res = userService.getUsersByWorkplaceIdAndPositionId(idW, idP);
		if (!res.isEmpty()) {
			return new RESTResponse<List<User>>(200, "OK", res);
		} else {
			return new RESTResponse<List<User>>(500, "No hay usuarios registrados con ese cargo.", res);
		}
	}

	@PostMapping("/userByIdAndPassword")
	public RESTResponse<User> getUserByIdAndPassword(@RequestBody RESTRequest<User> req) {
		List<User> res = userService.getUserByIdAndPassword(req.getPayload().getEmail(), req.getPayload().getPassword());
		if (!res.isEmpty())
			return new RESTResponse<User>(200, "", res.get(0));
		else
			return new RESTResponse<User>(500, "", null);
	}

	@GetMapping("/usersByWorkplaceId/{id}")
	public RESTResponse<List<User>> getUsersByWorkplaceId(@PathVariable Integer id) {
		return new RESTResponse<List<User>>(1, "", userService.getUsersByWorkplaceId(id));
	}
}
