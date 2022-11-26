package com.dailycodebuffer.department.service;
import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentService.class);

    public Department saveDepartment(Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        LOGGER.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
