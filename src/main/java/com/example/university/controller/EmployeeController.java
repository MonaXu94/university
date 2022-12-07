package com.example.university.controller;


import com.example.university.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmpService empService;

    @Autowired
    public EmployeeController(EmpService empService){
        this.empService = empService;
    }
    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity<>(empService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/old")
    public ResponseEntity findOldEmployee(){
        return new ResponseEntity<>(empService.findOldEmployee(), HttpStatus.OK);
    }

}
