package com.dailycodebuffer.Spring.boot.tutorial.controller;

import com.dailycodebuffer.Spring.boot.tutorial.entity.Department;
import com.dailycodebuffer.Spring.boot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Spring.boot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//Simple restful api
//@Component // this annotation add this class in spring container
//@Controller has component


@RestController// create RestFull API.//it has controller anf responseBody
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("inside saveDepartment of controller");
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        logger.info("inside fetchDepartmentList of controller");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(id);

    }

    @DeleteMapping ("/departments/{id}")
    public String deleteDepartmentById(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
        return "Departments deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable Long id,@RequestBody Department department){
       return departmentService.updateDepartmentById(id,department);

    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable String name){
        return departmentService.fetchDepartmentByName(name);

    }
}
