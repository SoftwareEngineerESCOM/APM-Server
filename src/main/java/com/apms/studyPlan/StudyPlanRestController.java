package com.apms.studyPlan;

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
@RequestMapping("/studyPlan")
public class StudyPlanRestController {
	
    @Autowired
    private StudyPlanService studyPlanService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
    public RESTResponse<List<StudyPlan>> getAll() {
    	return new RESTResponse<List<StudyPlan>>(1, "", studyPlanService.getAll());
    }

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public RESTResponse<StudyPlan> getOne(@PathVariable Integer id) {
        return new RESTResponse<StudyPlan>(1, "", studyPlanService.getOne(id));
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public void add(@RequestBody RESTRequest<StudyPlan> studyPlan) {
        studyPlanService.add(studyPlan.getPayload());
    }

    /*
    **Update the specified resource in storage.
    */
    @PatchMapping
    public void update(@RequestBody RESTRequest<StudyPlan> studyPlan) {
        studyPlanService.update(studyPlan.getPayload());
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        studyPlanService.delete(id);
    }
    
    @GetMapping("StudyPlansByAcademicProgramId/{id}")
    public RESTResponse<List<StudyPlan>> getStudyPlansByAcademicProgramId(@PathVariable Integer id) {
    	return new RESTResponse<List<StudyPlan>>(1, "", studyPlanService.getStudyPlansByAcademicProgramId(id));
    }
}
