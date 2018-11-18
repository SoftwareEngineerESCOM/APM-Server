package com.apms.bibliographyType;
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
@RequestMapping("/BibliographyType")
public class BibliographyTypeRestController {
    @Autowired
    private BibliographyTypeService bibliographyTypeService;
    /*
     ** Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<BibliographyType>> getAll() {
    	return new RESTResponse<List<BibliographyType>>(1, "", bibliographyTypeService.getAll());
    }
    /*
     ** Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<BibliographyType> getOne(@PathVariable Integer id) {
    	return new RESTResponse<BibliographyType>(1,"", bibliographyTypeService.getOne(id));
    }
    /*
     ** Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<BibliographyType> req) {
    	bibliographyTypeService.add(req.getPayload());
    }
    /*
     ** Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<BibliographyType> req) {
    	bibliographyTypeService.update(req.getPayload());
    }
    /*
     ** Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	bibliographyTypeService.delete(id);
    }
}
