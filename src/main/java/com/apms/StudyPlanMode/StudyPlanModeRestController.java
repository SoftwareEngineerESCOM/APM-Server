package com.apms.StudyPlanMode;

import java.util.List;

import com.apms.restResponse.RESTRequest;
import com.apms.restResponse.RESTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/StudyPlanMode")
public class StudyPlanModeRestController {

    @Autowired
    private StudyPlanModeService studyPlanModeService;

    /*
     **Return a listing of all the resources
     */
    @GetMapping
    public RESTResponse<List<StudyPlanMode>> getAll() {
        return new RESTResponse<>(1, "", studyPlanModeService.getAll());
    }

    /*
     **Return one resource
     */
    @GetMapping("/{id}")
    public RESTResponse<StudyPlanMode> getOne(@PathVariable Long id) {
        return new RESTResponse<StudyPlanMode>(1, "", studyPlanModeService.getOne(id));
    }

    /*
     **Store a newly created resource in storage.
     */
    @PostMapping
    public void add(@RequestBody RESTRequest<StudyPlanMode> studyPlanMode) {
        studyPlanModeService.add(studyPlanMode.getPayload());
    }

    /*
     **Update the specified resource in storage.
     */
    @PatchMapping
    public void update(@RequestBody RESTRequest<StudyPlanMode> studyPlanMode) {
        studyPlanModeService.update(studyPlanMode.getPayload());
    }

    /*
     **Remove the specified resource from storage.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studyPlanModeService.delete(id);
    }
}