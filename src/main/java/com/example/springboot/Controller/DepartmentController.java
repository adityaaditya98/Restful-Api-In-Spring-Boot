package com.example.springboot.Controller;

import com.example.springboot.entity.Department;
import com.example.springboot.service.DepartmentService;
import com.example.springboot.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private  DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/getdepartments")
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }
    @GetMapping("/departments/{id}")
    public Department departmentById(@PathVariable("id") Long DepartmentId){
        return departmentService.DepartmentById(DepartmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentById){
        System.out.println("Deleted Successfully");
        return departmentService.deleteDepartmentById(departmentById);
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") long departmentByID,@RequestBody Department department){
    return departmentService.updateDepartmentById(departmentByID,department);
    }
}
