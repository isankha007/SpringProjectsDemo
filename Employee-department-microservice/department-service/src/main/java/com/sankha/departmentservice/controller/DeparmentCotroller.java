package com.sankha.departmentservice.controller;

import com.sankha.departmentservice.entity.Department;
import com.sankha.departmentservice.service.DepartMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DeparmentCotroller {
    @Autowired
    private DepartMentService service;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
            log.info("inside DeparmentCotroller ...save  ");
            return service.saveDeparment(department);
    }

    @GetMapping("/{deptId}")
    public Department findDepartmentById(@PathVariable Long deptId){
        log.info("inside DeparmentCotroller ...findDepartmentById  ");
        return service.findDepartmentById(deptId);

    }
}
