package com.microservices.usermicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
        private Long Id;
        private String name;
        private String address;
        private String code;
    }

