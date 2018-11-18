package com.apms.learningUnitEvaluation;
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
import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;
@RestController
@RequestMapping("/LearningUnitEvaluation")
public class LearningUnitEvaluationRestController {
    @Autowired
    private LearningUnitEvaluationService learningUnitEvaluationService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<LearningUnitEvaluation>> getAll() {
    	return new RESTResponse<List<LearningUnitEvaluation>>(1, "", learningUnitEvaluationService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<LearningUnitEvaluation> getOne(@PathVariable Integer id) {
    	return new RESTResponse<LearningUnitEvaluation>(1,"", learningUnitEvaluationService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<LearningUnitEvaluation> req) {
    	learningUnitEvaluationService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<LearningUnitEvaluation> req) {
    	learningUnitEvaluationService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	learningUnitEvaluationService.delete(id);
    }
}
