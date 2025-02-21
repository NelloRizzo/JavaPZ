package corso.java;

import java.util.Random;

public class Program {

	public static float min(float[] t) {
		float m = t[0];
		for (int i = 0; i < t.length; ++i) {
			if (m > t[i])
				m = t[i];
		}
		return m;
	}

	public static float max(float[] t) {
		float m = t[0];
		for (int i = 0; i < t.length; ++i) {
			if (m < t[i])
				m = t[i];
		}
		return m;
	}

	static float avg(float[] t) {
		float sum = 0;
		for (int i = 0; i < t.length; ++i) {
			sum += t[i];
		}
		return sum / t.length;
	}

	static int lower(float[] t, float bound) {
		int counter = 0;
		for (int i = 0; i < t.length; ++i) {
			if (t[i] < bound) {
				counter++;
			}
		}
		return counter;
	}

	static int between(float[] t, float min, float max) {
		int counter = 0;
		for (int i = 0; i < t.length; ++i) {
			if (t[i] < max && t[i] > min) {
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		Random rnd = new Random(1);
		float[] temperature = new float[100];
		for (int i = 0; i < temperature.length; ++i)
			temperature[i] = rnd.nextFloat() * 30 + 18;

		for (int i = 0; i < temperature.length; ++i)
			System.out.println(temperature[i]);

		float minTemp = min(temperature);
		System.out.println("Temperatura minima: " + minTemp);
		float maxTemp = max(temperature);
		System.out.println("Temperatura massima: " + maxTemp);
		float avgTemp = avg(temperature);
		System.out.println("Temperatura media: " + avgTemp);

		// data una soglia minima
		float sMin = 25;
		// contare quante temperature sono al di sotto di tale soglia
		System.out.printf("Temperature al di sotto di %f°: %d\n", sMin, lower(temperature, sMin));
		float sMax = 36;
		System.out.printf("Temperature comprese tra %.2f° e %.2f°: %d\n", sMin, sMax, between(temperature, sMin, sMax));
	}

}
