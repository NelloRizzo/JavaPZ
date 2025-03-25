package corso.java.controllers;

import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello( //
			@RequestParam(defaultValue = "World") String name, //
			Map<String, Object> modelMap) {
		modelMap.put("name", name);
		return "hello";
	}

	@GetMapping("/hello/{name}")
	public String helloWithName( //
			@PathVariable String name, //
			@RequestParam(defaultValue = "it") String language, //
			Map<String, Object> modelMap) {
		modelMap.put("greet", language.equals("it") ? "Ciao" : "Hello");
		modelMap.put("name", name);
		return "hello2";
	}

	@GetMapping("/hello2/{name}")
	public String helloWithName2( //
			@PathVariable String name, //
			@RequestParam(defaultValue = "it") String language, //
			Map<String, Object> modelMap) {
		modelMap.put("language", language);
		modelMap.put("name", name);
		return "hello3";
	}
	
	@GetMapping("/table/{number}")
	public String table(@PathVariable int number, Map<String, Object> map) {
		var l = IntStream.rangeClosed(1, 10).mapToObj( //
				n -> String.format("%s x %s = %s", n, number, n * number));
		map.put("number", number);
		map.put("list", l);
		return "table";
	}

	@GetMapping("/table/{number}/adv")
	public String tableAdv(@PathVariable int number, Map<String, Object> map) {
		var l = IntStream.rangeClosed(1, 10).mapToObj( //
				n -> TableModel.builder() //
						.withFactor(number) //
						.withNumber(n) //
						.withResult(number * n).build());
		map.put("number", number);
		map.put("list", l);
		return "table2";
	}
}
