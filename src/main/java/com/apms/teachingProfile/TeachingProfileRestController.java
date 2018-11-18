package com.apms.teachingProfile;
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
@RequestMapping("/TeachingProfile")
public class TeachingProfileRestController {
    @Autowired
    private TeachingProfileService teachingProfileService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<TeachingProfile>> getAll() {
    	return new RESTResponse<List<TeachingProfile>>(1, "", teachingProfileService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<TeachingProfile> getOne(@PathVariable Integer id) {
    	return new RESTResponse<TeachingProfile>(1,"", teachingProfileService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<TeachingProfile> req) {
    	teachingProfileService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<TeachingProfile> req) {
    	teachingProfileService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	teachingProfileService.delete(id);
    }
}
