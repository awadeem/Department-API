package com.dailycodebuffer.Spring.boot.tutorial.repo;

import com.dailycodebuffer.Spring.boot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepoTest {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("Math")
                                .departmentAddress("Maryland")
                                .departmentCode("MA-01")
                                .build();
        testEntityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepo.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Math");

    }

}