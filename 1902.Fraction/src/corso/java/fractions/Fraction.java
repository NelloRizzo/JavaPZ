package corso.java.fractions;

public class Fraction {
	private int signum;
	private int numerator;
	private int denominator;

	public Fraction(int number) {
		this(number, 1);
	}

	public Fraction(double number) {
		this((int) (number * 10000), 10000);
	}

	public Fraction(int numerator, int denominator) {
		this.signum = 1;
		if (numerator < 0) {
			this.signum = this.signum * -1;
			numerator = -numerator;
		}
		if (denominator < 0) {
			this.signum = this.signum * -1;
			denominator = -denominator;
		}
		int d = gcd(numerator, denominator);
		numerator = numerator / d;
		denominator = denominator / d;
		this.numerator = numerator;
		this.denominator = denominator;
	}

	int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public int getSignum() {
		return signum;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public String asString() {
		String result = "";
		if (signum < 0)
			result = result + "-";
		result = result + numerator;
		if (denominator != 1) {
			result = result + "/" + denominator;
		}
		return result;
	}

	public String latex() {
		return "\\dfrac{" + (signum * numerator) + "}{" + denominator + "}";
	}

	public Fraction add(Fraction other) {
		return new Fraction(
				this.signum * this.numerator * other.denominator + other.signum * other.numerator * this.denominator,
				this.denominator * other.denominator);
	}

	public Fraction opposite() {
		return new Fraction(-signum * numerator, denominator);
	}

	public Fraction sub(Fraction other) {
		return add(other.opposite());
	}

	public Fraction mul(Fraction other) {
		return new Fraction(this.numerator * other.numerator * this.signum * other.signum,
				this.denominator * other.denominator);
	}

	public Fraction inverse() {
		return new Fraction(signum * denominator, numerator);
	}

	public Fraction div(Fraction other) {
		return mul(other.inverse());
	}
}
