package com.dailycodebuffer.department.controller;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        LOGGER.info("Inside saveDepartment method of DepartmentController");
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        LOGGER.info("Inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

}