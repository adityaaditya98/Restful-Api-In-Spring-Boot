package com.example.springboot.service;

import com.example.springboot.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartment();

    public Department DepartmentById(Long DepartmentId);

    public String deleteDepartmentById(Long departmentById);

    public Department updateDepartmentById(long departmentByID, Department department);
}
