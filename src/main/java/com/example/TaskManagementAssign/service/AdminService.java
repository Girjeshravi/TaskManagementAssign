package com.example.TaskManagementAssign.service;

import com.example.TaskManagementAssign.modal.Student;
import com.example.TaskManagementAssign.repository.AdminRepository;
import com.example.TaskManagementAssign.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    public String addAdmins(Student student)
    {
        if(adminRepository.findByStudentEmail(student.getStudentEmail())==null) {
            student.setPassword(passwordEncoder.encode(student.getPassword()));
            student.setRole("ROLE_ADMIN");
            adminRepository.save(student);
            return "Data added";
        }
        else {
            return "Data already exists";
        }
    }
}
