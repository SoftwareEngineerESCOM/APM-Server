package com.apms.assignedTime;
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
@RequestMapping("/AssignedTime")
public class AssignedTimeRestController {
    @Autowired
    private AssignedTimeService assignedTimeService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<AssignedTime>> getAll() {
    	return new RESTResponse<List<AssignedTime>>(1, "", assignedTimeService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<AssignedTime> getOne(@PathVariable Integer id) {
    	return new RESTResponse<AssignedTime>(1,"", assignedTimeService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<AssignedTime> req) {
    	assignedTimeService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<AssignedTime> req) {
    	assignedTimeService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	assignedTimeService.delete(id);
    }
}
