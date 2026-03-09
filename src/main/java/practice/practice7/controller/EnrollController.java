package practice.practice7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import practice.practice7.service.EnrollService;

@RestController
public class EnrollController {

    @Autowired
    private EnrollService enrollService;
}
