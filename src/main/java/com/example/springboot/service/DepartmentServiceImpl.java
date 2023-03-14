package com.example.springboot.service;

import com.example.springboot.entity.Department;
import com.example.springboot.repository.DepartmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRespository departmentRepository;
    @Override
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department DepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public String deleteDepartmentById(Long departmentById) {
        departmentRepository.deleteById(departmentById);
        return null;
    }

    @Override
    public Department updateDepartmentById(long departmentByID, Department department) {
        Department depDb = departmentRepository.findById(departmentByID).get();
        if(Objects.nonNull(department.getDepartmentName())
        && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDb.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress())
                && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(depDb);
    }
}
