package com.example.university.service.impl;

import com.example.university.domain.CommonResponse;
import com.example.university.service.EmpService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;

class Response {
    @JsonProperty("status")
    String status;
    @JsonProperty("data")
    Employee[] data;
    @JsonProperty("message")
    String message;

    public Response(String status, Employee[] data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public Response(){}
}

class Employee{
    @JsonProperty("id")
    private int id;
    @JsonProperty("employee_name")
    private String employee_name;
    @JsonProperty("employee_salary")
    private int employee_salary;
    @JsonProperty("employee_age")
    private int employee_age;
    @JsonProperty("profile_image")
    private String profile_image;

    public int getAge(){
        return this.employee_age;
    }

    public Employee(){}

    public Employee(int id, String employee_name, int employee_salary, int employee_age, String profile_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

}
@Service
public class EmpServiceImpl implements EmpService{
    private final RestTemplate restTemplate;
    private String url = "https://dummy.restapiexample.com/api/v1/employees";

    @Autowired
    public EmpServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public CommonResponse findAll() {
        Response res = restTemplate.getForObject(url,Response.class);
        return new CommonResponse(200, new Date(), res.data);
    }

    @Override
    public CommonResponse findOldEmployee() {
        Response res = restTemplate.getForObject(url,Response.class);
        return new CommonResponse(200, new Date(), Arrays.stream(res.data).filter((emp) -> emp.getAge() > 30));
    }
}
