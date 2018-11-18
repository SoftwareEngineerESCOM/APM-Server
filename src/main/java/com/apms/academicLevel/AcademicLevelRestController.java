package com.apms.academicLevel;
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
@RequestMapping("/AcademicLevel")
public class AcademicLevelRestController {
    @Autowired
    private AcademicLevelService academicLevelService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<AcademicLevel>> getAll() {
    	return new RESTResponse<List<AcademicLevel>>(1, "", academicLevelService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<AcademicLevel> getOne(@PathVariable Integer id) {
    	return new RESTResponse<AcademicLevel>(1,"", academicLevelService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<AcademicLevel> req) {
    	academicLevelService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<AcademicLevel> req) {
    	academicLevelService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	academicLevelService.delete(id);
    }
}
