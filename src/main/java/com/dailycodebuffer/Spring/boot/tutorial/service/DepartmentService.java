package com.dailycodebuffer.Spring.boot.tutorial.service;

import com.dailycodebuffer.Spring.boot.tutorial.entity.Department;
import com.dailycodebuffer.Spring.boot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department saveDepartment);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long id);

   public Department updateDepartmentById(Long id, Department department);

   public Department fetchDepartmentByName(String name);
}
