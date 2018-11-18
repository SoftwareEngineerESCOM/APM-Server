package com.apms.practicesRelation;
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
@RequestMapping("/PracticesRelation")
public class PracticesRelationRestController {
    @Autowired
    private PracticesRelationService practicesRelationService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<PracticesRelation>> getAll() {
    	return new RESTResponse<List<PracticesRelation>>(1, "", practicesRelationService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<PracticesRelation> getOne(@PathVariable Integer id) {
    	return new RESTResponse<PracticesRelation>(1,"", practicesRelationService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<PracticesRelation> req) {
    	practicesRelationService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<PracticesRelation> req) {
    	practicesRelationService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	practicesRelationService.delete(id);
    }
}
