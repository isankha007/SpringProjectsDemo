package com.example.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServicefallaBakc(){
        return "User service is taking time longer than Expected";
    }

        @GetMapping("/departmentServiceFallBack")
        public String departmentServicefallaBak(){
            return "Department service is taking time longer than Expected";
        }
}
