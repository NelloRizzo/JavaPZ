package corso.java.securitysample.controllers;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class DataController {

	@GetMapping
	public ResponseEntity<List<String>> test() {
		return ResponseEntity.ok( //
				IntStream.range(0, 100) //
						.mapToObj(n -> String.format("Stringa %s", n)) //
						.toList());
	}
}
