package com.microservices.departmentmicroservice.services;

import com.microservices.departmentmicroservice.entity.Department;
import com.microservices.departmentmicroservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public Department saveDepartment(Department department) {
        log.info("inside DepartmentService - saveDepartment");
       return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        log.info("inside DepartmentService - getDepartmentById");
        Optional<Department> departmentOptional= departmentRepository.findById(id);
        return departmentOptional.orElse(null);
    }
}
