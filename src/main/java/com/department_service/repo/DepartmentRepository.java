package com.department_service.repo;

import com.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DepartmentRepository
            extends JpaRepository<Department, Long> {

        boolean existsByNameIgnoreCase(String name);
    }

