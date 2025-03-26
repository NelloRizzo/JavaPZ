package corso.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.Course;

public interface CoursesRepository extends JpaRepository<Course, Integer> {

}
