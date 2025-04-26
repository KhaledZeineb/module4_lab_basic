// CourseService.java
package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAllCourses();
    Page<Course> getAllCourses(Pageable pageable);
    Optional<Course> getCourseById(Long id);
    Optional<Course> getCourseByCode(String code);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    boolean enrollStudent(Long studentId, Long courseId);
    boolean unenrollStudent(Long studentId, Long courseId);
    List<Course> getCoursesForStudent(Long studentId);
}

