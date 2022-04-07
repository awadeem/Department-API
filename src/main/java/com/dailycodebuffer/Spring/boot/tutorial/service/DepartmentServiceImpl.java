package com.dailycodebuffer.Spring.boot.tutorial.service;

import com.dailycodebuffer.Spring.boot.tutorial.entity.Department;
import com.dailycodebuffer.Spring.boot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Spring.boot.tutorial.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.lang.Object.*;

@Service //it has all the business logic
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;
    @Override
    public Department saveDepartment(Department saveDepartment) {
        return departmentRepo.save(saveDepartment);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepo.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> departmentOptional = departmentRepo.findById(id);
        if (!departmentOptional.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }

            return departmentOptional.get();
        }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Department depDB = departmentRepo.findById(id).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepo.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepo.findByDepartmentNameIgnoreCase(name);
    }
}



