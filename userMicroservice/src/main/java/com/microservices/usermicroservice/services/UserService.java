package com.microservices.usermicroservice.services;

import com.microservices.usermicroservice.DTO.Department;
import com.microservices.usermicroservice.DTO.ResponseTemplate;
import com.microservices.usermicroservice.entity.User;
import com.microservices.usermicroservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate ;
    private static final String departmentUri = "http://DEPARTMENT-MICROSERVICE/departments/";
    public User saveUser(User user) {
        log.info("inside UserService-- saveUser");
        return  userRepository.save(user);
    }

    public ResponseTemplate getUserWithDepartment(Long id) {
        log.info("inside UserService --- getUserWithDepartment");
        ResponseTemplate responseTemplate = new ResponseTemplate();
         Optional<User> userOpt = userRepository.findById(id);
         if (userOpt.isEmpty()){
             return null;
         }
         User user = userOpt.get();
         Department department = restTemplate.getForObject(departmentUri+user.getDepartmentId(), Department.class);
         responseTemplate.setUser(user);
         responseTemplate.setDepartment(department);
         return responseTemplate;
    }
}
