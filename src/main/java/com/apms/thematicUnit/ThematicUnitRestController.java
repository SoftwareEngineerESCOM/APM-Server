package com.apms.thematicUnit;
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
@RequestMapping("/ThematicUnit")
public class ThematicUnitRestController {
    @Autowired
    private ThematicUnitService thematicUnitService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<ThematicUnit>> getAll() {
    	return new RESTResponse<List<ThematicUnit>>(1, "", thematicUnitService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<ThematicUnit> getOne(@PathVariable Integer id) {
    	return new RESTResponse<ThematicUnit>(1,"", thematicUnitService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<ThematicUnit> req) {
    	thematicUnitService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<ThematicUnit> req) {
    	thematicUnitService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	thematicUnitService.delete(id);
    }
}