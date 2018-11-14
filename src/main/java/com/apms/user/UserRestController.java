package com.apms.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apms.humanResource.HumanResourceService;
import com.apms.restResponse.RESTRequest;
import com.apms.restResponse.RESTResponse;

@RestController
@RequestMapping("/User")
public class UserRestController {

	@Autowired
	private UserService userService;
	@Autowired
	private HumanResourceService humanResourceService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<User>> getAll() {
		return new RESTResponse<List<User>>(1, "", userService.getAll());
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<User> getOne(@PathVariable String id) {
		return new RESTResponse<User>(1, "", userService.getOne(id));
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public void add(@RequestBody RESTRequest<User> req) {
		User payload = req.getPayload();
		System.out.println("LASDKLDSKAFKWE UIOREW UI WR WEF JD JKDS");
		humanResourceService.add(payload.getHumanResource());
		userService.add(req.getPayload());
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PatchMapping
	public void update(@RequestBody RESTRequest<User> req) {
		userService.update(req.getPayload());
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		userService.delete(id);
	}

	@GetMapping("/UsersByWorkplaceIdAndPositionId/{idW}/{idP}")
	public RESTResponse<List<User>> getUsersByWorkplaceIdAndPositionId(@PathVariable Integer idW,
			@PathVariable Integer idP) {
		List<User> res = userService.getUsersByWorkplaceIdAndPositionId(idW, idP);
		if (!res.isEmpty()) {
			return new RESTResponse<List<User>>(200, "OK", res);
		} else {
			return new RESTResponse<List<User>>(500, "No hay usuarios registrados con ese cargo.", res);
		}
	}

	@PostMapping("/UserByIdAndPassword")
	public RESTResponse<User> getUserByIdAndPassword(@RequestBody RESTRequest<User> req) {
		System.out.println(req.getPayload().getId() + req.getPayload().getPassword());
		return new RESTResponse<User>(1, "",
				userService.getUserByIdAndPassword(req.getPayload().getId(), req.getPayload().getPassword()));
	}

	@GetMapping("/UsersByWorkplaceId/{id}")
	public RESTResponse<List<User>> getUsersByWorkplaceId(@PathVariable Integer id) {
		return new RESTResponse<List<User>>(1, "", userService.getUsersByWorkplaceId(id));
	}
}
