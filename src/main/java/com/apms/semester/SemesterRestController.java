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
@RequestMapping("/Semester")
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
    public void add(@RequestBody RESTRequest<Semester> req) {
        semesterService.add(req.getPayload());
    }

    /*
    **Update the specified resource in storage.
    */
    @PatchMapping
    public void update(@RequestBody RESTRequest<Semester> req) {
        semesterService.update(req.getPayload());
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        semesterService.delete(id);
    }

    @GetMapping("/SemestersByStudyPlanId/{id}")
    public RESTResponse<List<Semester>> getSemestersByStudyPlanId(@PathVariable Integer id){
        return new RESTResponse<List<Semester>>(1, "", semesterService.getSemestersByStudyPlanId(id));
    }
    
}
