package calculator;

public interface Calculator {
	void add(double number);

	void sub(double number);

	void div(double number);

	void mul(double number);

	double getAccumulator();

	void clear();
}
