package com.department_service.controller;

import com.department_service.entity.Department;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id){
        return new Department(id,"IT");
    }
}
