package com.example.studentmanagement;

import com.example.studentmanagement.model.Course;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.CourseRepository;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(StudentRepository studentRepository, CourseRepository courseRepository, CourseService courseService) {
        return args -> {
            // Only add test data if repositories are empty
            if (studentRepository.count() == 0) {
                // Create students
                Student john = new Student("John", "Doe", "john.doe@example.com", 20, "Computer Science");
                Student jane = new Student("Jane", "Smith", "jane.smith@example.com", 22, "Mathematics");
                Student alice = new Student("Alice", "Johnson", "alice.j@example.com", 19, "Computer Science");
                Student bob = new Student("Bob", "Williams", "bob.w@example.com", 21, "Physics");
                Student charlie = new Student("Charlie", "Brown", "charlie.b@example.com", 23, "Mathematics");

                studentRepository.save(john);
                studentRepository.save(jane);
                studentRepository.save(alice);
                studentRepository.save(bob);
                studentRepository.save(charlie);

                System.out.println("Sample students initialized!");
            }

            if (courseRepository.count() == 0) {
                // Create courses
                Course java = new Course("Java Programming", "CS101", 3);
                Course python = new Course("Python Programming", "CS102", 3);
                Course database = new Course("Database Systems", "CS201", 4);
                Course calculus = new Course("Calculus I", "MATH101", 4);
                Course physics = new Course("Physics I", "PHYS101", 4);

                courseRepository.save(java);
                courseRepository.save(python);
                courseRepository.save(database);
                courseRepository.save(calculus);
                courseRepository.save(physics);

                // Enroll students in courses
                courseService.enrollStudent(1L, 1L); // John in Java
                courseService.enrollStudent(1L, 2L); // John in Python
                courseService.enrollStudent(2L, 4L); // Jane in Calculus
                courseService.enrollStudent(3L, 1L); // Alice in Java
                courseService.enrollStudent(4L, 5L); // Bob in Physics
                courseService.enrollStudent(5L, 4L); // Charlie in Calculus

                System.out.println("Sample courses initialized and students enrolled!");
            }
        };
    }
}