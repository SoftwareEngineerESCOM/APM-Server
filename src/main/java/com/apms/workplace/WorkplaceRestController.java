package com.apms.workplace;

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

@RestController
@RequestMapping("/Workplace")
public class WorkplaceRestController {
	
    @Autowired
    private WorkplaceService workplaceService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
    public List<Workplace> getAll() {
        return workplaceService.getAll();
    }

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public Workplace getOne(@PathVariable Integer id) {
        return workplaceService.getOne(id);
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public void add(@RequestBody Workplace workplace) {
        workplaceService.add(workplace);
    }

    /*
    **Update the specified resource in storage.
    */
    @PatchMapping
    public void update(@RequestBody Workplace workplace) {
        workplaceService.update(workplace);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        workplaceService.delete(id);
    }
}
