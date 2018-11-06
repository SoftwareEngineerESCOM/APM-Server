package com.apms.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Position")
public class PositionRestController {
	
    @Autowired
    private PositionService positionService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
    public List<Position> getAll() {
        return positionService.getAll();
    }

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public Position getOne(@PathVariable Long id) {
        return positionService.getOne(id);
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public void add(@RequestBody Position position) {
        positionService.add(position);
    }

    /*
    **Update the specified resource in storage.
    */
    @PatchMapping
    public void update(@RequestBody Position position) {
        positionService.update(position);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        positionService.delete(id);
    }
}
