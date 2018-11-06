package com.apms.workplaceType;

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
@RequestMapping("/WorkplaceType")
public class WorkplaceTypeRestController {
	
    @Autowired
    private WorkplaceTypeService workplaceTypeService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
    public List<WorkplaceType> getAll() {
        return workplaceTypeService.getAll();
    }

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public WorkplaceType getOne(@PathVariable Long id) {
        return workplaceTypeService.getOne(id);
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public void add(@RequestBody WorkplaceType workplaceType) {
        workplaceTypeService.add(workplaceType);
    }

    /*
    **Update the specified resource in storage.
    */
    @PatchMapping
    public void update(@RequestBody WorkplaceType workplaceType) {
        workplaceTypeService.update(workplaceType);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        workplaceTypeService.delete(id);
    }
}
