package com.apms.learningUnit;

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
@RequestMapping("/learningUnit")
public class LearningUnitRestController {
	
    @Autowired
    private LearningUnitService learningUnitService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
    public RESTResponse<List<LearningUnit>> getAll() {
	return new RESTResponse<List<LearningUnit>>(1, "", learningUnitService.getAll());
    }

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public RESTResponse<LearningUnit> getOne(@PathVariable Integer id) {
        return new RESTResponse<LearningUnit>(1, "", learningUnitService.getOne(id));
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public void add(@RequestBody RESTRequest<LearningUnit> learningUnit) {
        learningUnitService.add(learningUnit.getPayload());
    }

    /*
    **Update the specified resource in storage.
    */
    @PatchMapping
    public void update(@RequestBody RESTRequest<LearningUnit> learningUnit) {
        learningUnitService.update(learningUnit.getPayload());
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        learningUnitService.delete(id);
    }
    
    @GetMapping("LearningUnitsBySemesterId/{id}")
    public RESTResponse<List<LearningUnit>> getLearningUnitsBySemesterId(@PathVariable Integer id){
        return new RESTResponse<List<LearningUnit>>(1, "", learningUnitService.getLearningUnitsBySemesterId(id));
    }
    
}
