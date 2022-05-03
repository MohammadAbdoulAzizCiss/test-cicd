package com.microservices.cloudgateway.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallbackMethod(){
        return "user Service is taking longer than expected\nPlease try again later";
    }
    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallbackMethod(){
        return "Department  Service is taking longer than expected\nPlease try again later";
    }
}
