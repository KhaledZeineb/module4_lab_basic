package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();

    Page<Student> getAllStudents(Pageable pageable);

    Optional<Student> getStudentById(Long id);

    Student saveStudent(Student student);

    void deleteStudent(Long id);

    List<Student> findByMajor(String major);

    Page<Student> findByMajor(String major, Pageable pageable);

    List<Student> getStudentsEnrolledInCourse(Long courseId);
}