package corso.java.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import corso.java.entities.Alumn;
import corso.java.repository.AlumnsRepository;
import corso.java.repository.CoursesRepository;

@RestController
@RequestMapping("/api/alumns")
public class AlumnsController {

	private final AlumnsRepository alumns;
	private final CoursesRepository courses;

	public AlumnsController(AlumnsRepository alumns, CoursesRepository courses) {
		this.alumns = alumns;
		this.courses = courses;
	}

	@PostMapping
	public Alumn register(@RequestBody Alumn alumn) {
		return alumns.save(alumn);
	}

	@PostMapping("{alumnId}/course/{courseId}")
	public Alumn linkToCourse(@PathVariable int alumnId, @PathVariable int courseId) {
		var alumn = alumns.findById(alumnId).orElseThrow();
		var course = courses.findById(courseId).orElseThrow();
		alumn.getCourses().add(course);
		return alumns.save(alumn);
	}
}
