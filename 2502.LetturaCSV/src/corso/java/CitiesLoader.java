package corso.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitiesLoader {
	private String fileName;

	public CitiesLoader(String fileName) {
		this.fileName = fileName;
	}

	public List<City> readFile() {
		var result = new ArrayList<City>();
		try {
			// apre un buffered reader sul file indicato da fileName
			var r = new BufferedReader(new FileReader(fileName));
			String line; // per leggere una riga del file
			// le prime tre righe non mi servono
			for (var i = 0; i < 3; ++i)
				line = r.readLine();
			// leggo il resto del file
			while ((line = r.readLine()) != null) {
				// System.out.println(line);
				String[] parts = line.split(";");
				var city = new City( //
						// nome
						parts[5],
						// codice
						parts[4],
						// capoluogo
						parts[13].charAt(0) == '1',
						// codice catastale
						parts[19],
						// province
						new Province(
								// nome
								parts[11],
								// codice
								parts[2],
								// sigla
								parts[14],
								// regione
								new Region(
										// nome
										parts[10],
										// codice
										parts[0],
										// area geografica
										new Area(
												// nome
												parts[9],
												// codice
												parts[8]))));
				result.add(city);
			}
			// non dimenitchiamo di chidere il reader
			r.close();
		} catch (IOException e) {

		}
		return result;
	}
}
