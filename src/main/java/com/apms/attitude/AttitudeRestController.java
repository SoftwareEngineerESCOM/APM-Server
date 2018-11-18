package com.apms.attitude;
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
@RequestMapping("/Attitude")
public class AttitudeRestController {
    @Autowired
    private AttitudeService attitudeService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<Attitude>> getAll() {
    	return new RESTResponse<List<Attitude>>(1, "", attitudeService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<Attitude> getOne(@PathVariable Integer id) {
    	return new RESTResponse<Attitude>(1,"", attitudeService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<Attitude> req) {
    	attitudeService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<Attitude> req) {
    	attitudeService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	attitudeService.delete(id);
    }
}
