package com.dailycodebuffer.Spring.boot.tutorial.service;

import com.dailycodebuffer.Spring.boot.tutorial.entity.Department;
import com.dailycodebuffer.Spring.boot.tutorial.repo.DepartmentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepo departmentRepo;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                               .departmentName("IT")
                               .departmentAddress("Delaware")
                               .departmentCode("IT-06")
                               .departmentId(1L)
                                .build();
        Mockito.when(departmentRepo.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
       String departmentName = "IT";
       Department found = departmentService.fetchDepartmentByName(departmentName);
       assertEquals(departmentName,found.getDepartmentName());
    }
}