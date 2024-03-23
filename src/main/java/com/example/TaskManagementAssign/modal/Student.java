package com.example.TaskManagementAssign.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "StudentInformation")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;
    private String studentEmail;
    private String dueDate;
    private String taskName;
    private String taskDescription;
    private String taskStatus;

    @Column(unique = true,nullable = false)
    private String username;
    private String password;
    private String role;
}
