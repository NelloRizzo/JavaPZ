package corso.java.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import corso.java.entities.Course;
import corso.java.repository.CoursesRepository;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

	private final CoursesRepository repo;

	public CoursesController(CoursesRepository repo) {
		this.repo = repo;
	}

	// GET /api/courses
	@GetMapping
	public List<Course> readAllCourses() {
		return repo.findAll();
	}

	@GetMapping("{id}")
	public Course readCourseById(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
	}

	// POST /api/courses
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Course saveCourse(@RequestBody Course course) {
		return repo.save(course);
	}
}
