package com.apms.placePublication;
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
@RequestMapping("/PlacePublication")
public class PlacePublicationRestController {
    @Autowired
    private PlacePublicationService placePublicationService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<PlacePublication>> getAll() {
    	return new RESTResponse<List<PlacePublication>>(1, "", placePublicationService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<PlacePublication> getOne(@PathVariable Integer id) {
    	return new RESTResponse<PlacePublication>(1,"", placePublicationService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<PlacePublication> req) {
    	placePublicationService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<PlacePublication> req) {
    	placePublicationService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	placePublicationService.delete(id);
    }
}
