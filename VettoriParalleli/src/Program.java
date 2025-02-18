
public class Program {

	static float max_vote(float v[]) {
		float max = v[0];
		for (int i = 0; i < v.length; ++i) {
			if (max < v[i])
				max = v[i];
		}
		return max;
	}

	public static void main(String[] args) {
		String[] nomi = { "Paperino", "Topolino", "Pluto", "Archimede" };
		float[] voti = { 5, 6, 7.4f, 6 };
		for (int i = 0; i < nomi.length; ++i) {
			System.out.println("Alunno -> Nome: " + nomi[i] + " - Voto: " + voti[i]);
		}

		// come si chiamano gli alunni che hanno il voto più alto?
		// individuare il voto più alto
		float mv = max_vote(voti);
		// e poi scorre l'array per trovare gli alunni corrispondenti
		for (int i = 0; i < nomi.length; ++i) {
			if (voti[i] == mv)
				System.out.println(nomi[i] + " " + voti[i]);
		}
		// come si chiamano gli alunni che hanno il voto più alto della media?
	}

}
