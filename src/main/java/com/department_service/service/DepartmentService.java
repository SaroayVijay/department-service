package com.department_service.service;

import com.department_service.exception.DepartmentNotFoundException;
import com.department_service.repo.DepartmentRepository;
import com.department_service.entity.Department;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(
            DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department) {
        department.setId(null);
        return departmentRepository.save(department);
    }

    @Transactional(readOnly = true)
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new DepartmentNotFoundException(id));
    }

    public Department updateDepartment(
            Long id,
            Department updatedDepartment) {

        Department existingDepartment =
                getDepartmentById(id);

        existingDepartment.setName(
                updatedDepartment.getName());

        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(Long id) {
        Department department = getDepartmentById(id);
        departmentRepository.delete(department);
    }


}