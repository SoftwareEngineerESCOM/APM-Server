package com.apms.semester;

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

@RestController
@RequestMapping("/semester")
public class SemesterRestController {
	
    @Autowired
    private SemesterService semesterService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
    public RESTResponse<List<Semester>> getAll() {
	return new RESTResponse<List<Semester>>(1, "", semesterService.getAll());
    }

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public RESTResponse<Semester> getOne(@PathVariable Integer id) {
        return new RESTResponse<Semester>(1, "", semesterService.getOne(id));
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public void add(@RequestBody RESTRequest<Semester> semester) {
        semesterService.add(semester.getPayload());
    }

    /*
    **Update the specified resource in storage.
    */
    @PatchMapping
    public void update(@RequestBody RESTRequest<Semester> semester) {
        semesterService.update(semester.getPayload());
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        semesterService.delete(id);
    }
}
