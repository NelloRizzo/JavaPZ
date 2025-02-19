package corso.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class Program {

	public static void main(String[] args) {
		int age = 16;
		String status = (age < 18) ? "Minorenne" : "Maggiorenne";

		System.out.println(status);

		int sum = 0;
		sum = sum + 10;
		sum += 10;

		String msg = String.format("L'età dell'utente è %d e quindi l'utente è %s", age, status);
		System.out.println(msg);

		StringBuilder sb = new StringBuilder() //
				.append("Quest\\o ").append("è ").append("un pezzo\n di stringa").append("\tL'età è ").append(age)
				.append(" quindi l'utente è ").append(status);

		String result = sb.toString();
		System.out.println(result);
		System.out.printf("L'età dell'utente è %d e quindi l'utente è %s\n", age, status);
		System.out.println(status.substring(0, 4).toUpperCase());

		Calendar cal = Calendar.getInstance();
		cal.set(2025, 3, 18, 17, 0, 0);
		System.out.println(cal.get(Calendar.DATE));

		LocalDate ld = LocalDate.of(2025, 3, 15); //LocalDate.now();
		System.out.println(ld);
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		LocalTime lt1 = LocalTime.of(15, 10, 14);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println(ldt.getDayOfMonth());
	}

}
