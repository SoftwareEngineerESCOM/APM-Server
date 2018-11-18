package com.apms.professionalExperience;
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
@RequestMapping("/ProfessionalExperience")
public class ProfessionalExperienceRestController {
    @Autowired
    private ProfessionalExperienceService professionalExperienceService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<ProfessionalExperience>> getAll() {
    	return new RESTResponse<List<ProfessionalExperience>>(1, "", professionalExperienceService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<ProfessionalExperience> getOne(@PathVariable Integer id) {
    	return new RESTResponse<ProfessionalExperience>(1,"", professionalExperienceService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<ProfessionalExperience> req) {
    	professionalExperienceService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<ProfessionalExperience> req) {
    	professionalExperienceService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	professionalExperienceService.delete(id);
    }
}
