package com.apms.topicHour;
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
@RequestMapping("/TopicHour")
public class TopicHourRestController {
    @Autowired
    private TopicHourService topicHourService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<TopicHour>> getAll() {
    	return new RESTResponse<List<TopicHour>>(1, "", topicHourService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<TopicHour> getOne(@PathVariable Integer id) {
    	return new RESTResponse<TopicHour>(1,"", topicHourService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<TopicHour> req) {
    	topicHourService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<TopicHour> req) {
    	topicHourService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	topicHourService.delete(id);
    }
}
