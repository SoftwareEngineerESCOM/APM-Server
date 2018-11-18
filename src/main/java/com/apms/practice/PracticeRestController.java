package com.apms.practice;
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
@RequestMapping("/Practice")
public class PracticeRestController {
    @Autowired
    private PracticeService practiceService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<Practice>> getAll() {
    	return new RESTResponse<List<Practice>>(1, "", practiceService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<Practice> getOne(@PathVariable Integer id) {
    	return new RESTResponse<Practice>(1,"", practiceService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<Practice> req) {
    	practiceService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<Practice> req) {
    	practiceService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	practiceService.delete(id);
    }
}