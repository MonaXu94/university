package com.example.university.controller;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.entity.Teacher;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> findTeaById(@PathVariable String id) {
        return new ResponseEntity<>(teacherService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<CommonResponse> findAll() {
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> delete(@PathVariable String id) {
        return new ResponseEntity<>(teacherService.deleteById(id), HttpStatus.OK);
    }

    //path: /teacher, method: post ,  create teacher
    @PostMapping
    public ResponseEntity<CommonResponse> insert(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.insert(teacher), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> update(@PathVariable String id, @RequestBody String name) {
        return new ResponseEntity<>(teacherService.update(id, name), HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CommonResponse> handleNotFound() {
        return new ResponseEntity<>(
                    new CommonResponse(-1, new Date(), "resource not found"),
                    HttpStatus.NOT_FOUND
                );
    }
}
