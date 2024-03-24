package com.example.TaskManagementAssign.repository;

import com.example.TaskManagementAssign.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Student,Integer> {
    public Student findByStudentEmail(String studentEmail);
    Student findByUsername(String username);
}
