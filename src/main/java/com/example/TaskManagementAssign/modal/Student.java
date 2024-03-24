package com.example.TaskManagementAssign.modal;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Table(name = "StudentInformation")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer studentId;

    String studentName;

    @Column(unique = true,nullable = false)
    String studentEmail;

    String dueDate;
    String taskName;
    String taskDescription;
    String taskStatus;

    @Column(unique = true,nullable = false)
    String username;

    String password;
    String role;
}
