package calculator;

import lombok.ToString;

@ToString
public class StandardCalculator implements Calculator {
	private double accumulator = 0;

	@Override
	public void add(double number) {
		accumulator += number;
	}

	@Override
	public void sub(double number) {
		accumulator -= number;
	}

	@Override
	public void div(double number) {
		accumulator /= number;
	}

	@Override
	public void mul(double number) {
		accumulator *= number;
	}

	@Override
	public double getAccumulator() {
		return accumulator;
	}

	@Override
	public void clear() {
		accumulator = 0;
	}

}
