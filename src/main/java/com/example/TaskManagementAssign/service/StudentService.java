package com.example.TaskManagementAssign.service;

import com.example.TaskManagementAssign.Exceptions.StudentNotFoundException;
import com.example.TaskManagementAssign.modal.Student;
import com.example.TaskManagementAssign.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired StudentRepository studentRepository;
    public String addStudent(Student student)
    {
        if(studentRepository.findByStudentEmail(student.getStudentEmail())==null) {

            studentRepository.save(student);
            return "Data added successfully";
        }
        else {
            return "Data already exists";
        }
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        if (!studentList.isEmpty()) {
            return studentList;
        }
        else {
            return new ArrayList<>();
        }
    }

    public Student fetchByStudentId(Integer studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        else {
            return null;
        }
    }


    public Student updateStudentTaskName(Integer id, String title) {
        Student student =studentRepository.findById(id).get();
        if(student==null){
            throw new StudentNotFoundException("Invalid id");
        }
        student.setTaskName(title);
        studentRepository.save(student);
        return student;
    }
    public Student updateStudentStatus(Integer id, String status) {
        Student student =studentRepository.findById(id).get();
        if(student==null){
            throw new StudentNotFoundException("Invalid id");
        }
        student.setTaskStatus(status);
        studentRepository.save(student);
        return student;
    }

    public String deleteStudent(Integer id) {
        studentRepository.deleteById(id);
        return "user deleted successfully";
    }
}
