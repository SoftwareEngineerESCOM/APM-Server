package com.apms.schoolingGrade;
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
@RequestMapping("/SchoolingGrade")
public class SchoolingGradeRestController {
    @Autowired
    private SchoolingGradeService schoolingGradeService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<SchoolingGrade>> getAll() {
    	return new RESTResponse<List<SchoolingGrade>>(1, "", schoolingGradeService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<SchoolingGrade> getOne(@PathVariable Integer id) {
    	return new RESTResponse<SchoolingGrade>(1,"", schoolingGradeService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<SchoolingGrade> req) {
    	schoolingGradeService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<SchoolingGrade> req) {
    	schoolingGradeService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	schoolingGradeService.delete(id);
    }
}
