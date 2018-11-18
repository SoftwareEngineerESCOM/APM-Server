package com.apms.knowledge;
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
@RequestMapping("/Knowledge")
public class KnowledgeRestController {
    @Autowired
    private KnowledgeService knowledgeService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<Knowledge>> getAll() {
    	return new RESTResponse<List<Knowledge>>(1, "", knowledgeService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<Knowledge> getOne(@PathVariable Integer id) {
    	return new RESTResponse<Knowledge>(1,"", knowledgeService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<Knowledge> req) {
    	knowledgeService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<Knowledge> req) {
    	knowledgeService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	knowledgeService.delete(id);
    }
}
