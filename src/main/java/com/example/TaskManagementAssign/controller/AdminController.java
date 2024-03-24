package com.example.TaskManagementAssign.controller;

import com.example.TaskManagementAssign.modal.Student;
import com.example.TaskManagementAssign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student)
    {
        return adminService.addAdmins(student);
    }
}
