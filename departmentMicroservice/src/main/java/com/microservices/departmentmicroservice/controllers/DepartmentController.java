package com.microservices.departmentmicroservice.controllers;

import com.microservices.departmentmicroservice.entity.Department;
import com.microservices.departmentmicroservice.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("inside DepartmentController -saveDepartment ");
        return departmentService.saveDepartment(department);

    }
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        log.info("inside DepartmentController -getDepartmentById ");
        return departmentService.getDepartmentById(id);
    }
}
