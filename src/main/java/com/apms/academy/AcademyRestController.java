package com.apms.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/academy")
public class AcademyRestController {
	
	@Autowired
    private AcademyService academyService;
}
