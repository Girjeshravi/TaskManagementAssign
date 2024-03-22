package com.example.TaskManagementAssign.controller;

import com.example.TaskManagementAssign.modal.Student;
import com.example.TaskManagementAssign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @GetMapping("/fetchAll")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/fetchById")
    public Student fetchByStudentId(Integer studentId)
    {
        return studentService.fetchByStudentId(studentId);
    }


    @PutMapping("/update/{id}/{title}")
    public ResponseEntity updateUserTitle(@PathVariable Integer id, @PathVariable String title){
        try{
            Student student=studentService.updateUserById(id,title);
            return new ResponseEntity(student, HttpStatus.FOUND);

        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}/{status}")
    public ResponseEntity updateUserStatus(@PathVariable Integer id,@PathVariable String status){
        try{
            Student user=studentService.updateUserStatus(id, status);
            return new ResponseEntity(user,HttpStatus.FOUND);

        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        String message=studentService.deleteUser(id);
        return message;
    }

}
