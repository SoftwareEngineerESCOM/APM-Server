package com.apms.evaluationSystem;
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
@RequestMapping("/EvaluationSystem")
public class EvaluationSystemRestController {
    @Autowired
    private EvaluationSystemService evaluationSystemService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<EvaluationSystem>> getAll() {
    	return new RESTResponse<List<EvaluationSystem>>(1, "", evaluationSystemService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<EvaluationSystem> getOne(@PathVariable Integer id) {
    	return new RESTResponse<EvaluationSystem>(1,"", evaluationSystemService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<EvaluationSystem> req) {
    	evaluationSystemService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<EvaluationSystem> req) {
    	evaluationSystemService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	evaluationSystemService.delete(id);
    }
}
