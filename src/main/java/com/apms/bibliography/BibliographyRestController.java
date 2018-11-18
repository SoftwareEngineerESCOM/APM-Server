package com.apms.bibliography;
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
@RequestMapping("/Bibliography")
public class BibliographyRestController {
    @Autowired
    private BibliographyService bibliographyService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<Bibliography>> getAll() {
    	return new RESTResponse<List<Bibliography>>(1, "", bibliographyService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<Bibliography> getOne(@PathVariable Integer id) {
    	return new RESTResponse<Bibliography>(1,"", bibliographyService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<Bibliography> req) {
    	bibliographyService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<Bibliography> req) {
    	bibliographyService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	bibliographyService.delete(id);
    }
}
