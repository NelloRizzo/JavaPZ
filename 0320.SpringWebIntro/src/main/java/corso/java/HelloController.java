package corso.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	// GET /hello
	@GetMapping("/hello")
	public @ResponseBody String sayHello() {
		return "Hello, World!";
	}

	// GET /hello-name?name=Nello&lang=it
	@GetMapping("/hello-name")
	public @ResponseBody String sayHelloByQuery(@RequestParam String name,
			@RequestParam(defaultValue = "it") String lang) {
		return String.format("%s, %s!", lang.equals("it") ? "Ciao" : "Hello", name == null ? "World" : name);
	}

	// GET /hello/Nello?lang=it
	@GetMapping("/hello/{name}")
	public @ResponseBody String sayHello(@PathVariable String name, @RequestParam(defaultValue = "it") String lang) {
		return String.format("%s, %s!", lang.equals("it") ? "Ciao" : "Hello", name == null ? "World" : name);
	}
}
