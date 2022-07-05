package com.sankha.departmentservice.service;

import com.sankha.departmentservice.entity.Department;
import com.sankha.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartMentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDeparment(Department department) {
        log.info("inside DepartMentService ... save");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long deptId) {
        log.info("inside DepartMentService ... findDepartmentById");
        return  departmentRepository.findByDepartmentId(deptId);
    }
}
