package calculator;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

@ToString(callSuper = true)
public class RibbonCalculator extends StandardCalculator {
	@ToString.Include
	private final List<String> ribbon = new ArrayList<String>();

	private void out(double first, String operator, double second) {
		ribbon.add(String.format("%.2f %s %.2f = %.2f", first, operator, second, getAccumulator()));
	}

	@Override
	public void add(double number) {
		var memo = getAccumulator();
		super.add(number);
		out(memo, "+", number);
	}

	@Override
	public void div(double number) {
		var memo = getAccumulator();
		super.div(number);
		out(memo, ":", number);
	}

	@Override
	public void mul(double number) {
		var memo = getAccumulator();
		super.mul(number);
		out(memo, "x", number);
	}

	@Override
	public void sub(double number) {
		var memo = getAccumulator();
		super.sub(number);
		out(memo, "-", number);
	}
}
