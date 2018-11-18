package com.apms.accreditation;
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
@RequestMapping("/Accreditation")
public class AccreditationRestController {
    @Autowired
    private AccreditationService accreditationService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<Accreditation>> getAll() {
    	return new RESTResponse<List<Accreditation>>(1, "", accreditationService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<Accreditation> getOne(@PathVariable Integer id) {
    	return new RESTResponse<Accreditation>(1,"", accreditationService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<Accreditation> req) {
    	accreditationService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<Accreditation> req) {
    	accreditationService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	accreditationService.delete(id);
    }
}
