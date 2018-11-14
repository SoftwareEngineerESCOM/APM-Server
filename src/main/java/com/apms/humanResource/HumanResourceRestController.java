package com.apms.humanResource;

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

import com.apms.restResponse.RESTRequest;
import com.apms.restResponse.RESTResponse;
import com.apms.user.UserService;

@RestController
@RequestMapping("/HumanResource")
public class HumanResourceRestController {

	@Autowired
	private HumanResourceService humanResourceService;
	@Autowired
	private UserService userService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<HumanResource>> getAll() {
		return new RESTResponse<List<HumanResource>>(1, "", humanResourceService.getAll());
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<HumanResource> getOne(@PathVariable String id) {
		return new RESTResponse<HumanResource>(1, "", humanResourceService.getOne(id));
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public void add(@RequestBody RESTRequest<HumanResource> req) {
		System.out.println("hola'");
		humanResourceService.add(req.getPayload());
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PatchMapping
	public void update(@RequestBody RESTRequest<HumanResource> req) {
		System.out.println("olaaaad erqw rdsfRR");
		humanResourceService.update(req.getPayload());
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		if (userService.getOne(id) != null)
			userService.delete(id);
		humanResourceService.delete(id);
	}

	@GetMapping("/HumanResourcesByWorkplaceIdAndPositionId/{idW}/{idP}")
	public RESTResponse<List<HumanResource>> getHumanResourcesByWorkplaceIdAndPositionId(@PathVariable Integer idW,
			@PathVariable Integer idP) {
		return new RESTResponse<List<HumanResource>>(1, "",
				humanResourceService.getHumanResourcesByWorkplaceIdAndPositionId(idW, idP));
	}

	@GetMapping("/HumanResourcesByWorkplaceId/{id}")
	public RESTResponse<List<HumanResource>> getHumanResourcesByWorkplaceId(@PathVariable Integer id) {
		return new RESTResponse<List<HumanResource>>(1, "", humanResourceService.getHumanResourcesByWorkplaceId(id));
	}
}
