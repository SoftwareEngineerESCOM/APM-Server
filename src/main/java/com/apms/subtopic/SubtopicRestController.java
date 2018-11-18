package com.apms.subtopic;
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
@RequestMapping("/Subtopic")
public class SubtopicRestController {
    @Autowired
    private SubtopicService subtopicService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<Subtopic>> getAll() {
    	return new RESTResponse<List<Subtopic>>(1, "", subtopicService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<Subtopic> getOne(@PathVariable Integer id) {
    	return new RESTResponse<Subtopic>(1,"", subtopicService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<Subtopic> req) {
    	subtopicService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<Subtopic> req) {
    	subtopicService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	subtopicService.delete(id);
    }
}
