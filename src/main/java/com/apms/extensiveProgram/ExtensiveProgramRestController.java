package com.apms.extensiveProgram;
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
@RequestMapping("/ExtensiveProgram")
public class ExtensiveProgramRestController {
    @Autowired
    private ExtensiveProgramService extensiveProgramService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<ExtensiveProgram>> getAll() {
    	return new RESTResponse<List<ExtensiveProgram>>(1, "", extensiveProgramService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<ExtensiveProgram> getOne(@PathVariable Integer id) {
    	return new RESTResponse<ExtensiveProgram>(1,"", extensiveProgramService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<ExtensiveProgram> req) {
    	extensiveProgramService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<ExtensiveProgram> req) {
    	extensiveProgramService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	extensiveProgramService.delete(id);
    }
}
