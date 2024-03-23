package com.example.TaskManagementAssign.config;


import com.example.TaskManagementAssign.modal.Student;
import com.example.TaskManagementAssign.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student =studentRepository.findByUsername(username);
        if(student ==null){
            throw new UsernameNotFoundException("Invalid username");
        }
        return new UserDetailCreator(student);
    }
}
