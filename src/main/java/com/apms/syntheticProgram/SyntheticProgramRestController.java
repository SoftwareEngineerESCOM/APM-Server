package com.apms.syntheticProgram;
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
@RequestMapping("/SyntheticProgram")
public class SyntheticProgramRestController {
    @Autowired
    private SyntheticProgramService syntheticProgramService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<SyntheticProgram>> getAll() {
    	return new RESTResponse<List<SyntheticProgram>>(1, "", syntheticProgramService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<SyntheticProgram> getOne(@PathVariable Integer id) {
    	return new RESTResponse<SyntheticProgram>(1,"", syntheticProgramService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<SyntheticProgram> req) {
    	syntheticProgramService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<SyntheticProgram> req) {
    	syntheticProgramService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	syntheticProgramService.delete(id);
    }
}
