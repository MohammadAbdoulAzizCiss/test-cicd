package com.microservices.departmentmicroservice.repository;

import com.microservices.departmentmicroservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
