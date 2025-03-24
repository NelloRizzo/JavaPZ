package corso.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	// GET /hello
	@GetMapping("/hello")
	public @ResponseBody String sayHello() {
		return "Hello, World!";
	}
}
