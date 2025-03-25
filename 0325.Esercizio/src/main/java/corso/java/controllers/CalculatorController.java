package corso.java.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import corso.java.controllers.models.CalculatorModel;
import corso.java.controllers.models.OperatorModel;

@Controller
public class CalculatorController {

	@GetMapping
	public String showCalc(ModelMap map) {
		map.addAttribute("operators",
				List.of(OperatorModel.builder().withName("addizione").withSymbol('+').build(),
						OperatorModel.builder().withName("sottrazione").withSymbol('-').build(),
						OperatorModel.builder().withName("moltiplicazione").withSymbol('*').build(),
						OperatorModel.builder().withName("divisione").withSymbol('/').build()));
		map.addAttribute("data", new CalculatorModel());
		return "calculator";
	}

	@PostMapping("/execute")
	public String executeOperation(@ModelAttribute CalculatorModel model, ModelMap map) {
		switch (model.getOperator()) {
		case '+':
			model.setResult(model.getFirst() + model.getSecond());
			break;
		case '-':
			model.setResult(model.getFirst() - model.getSecond());
			break;
		case '*':
			model.setResult(model.getFirst() * model.getSecond());
			break;
		case '/':
			model.setResult(model.getFirst() / model.getSecond());
			break;
		default:
		}
		map.addAttribute("data", model);
		return "result";
	}
}
