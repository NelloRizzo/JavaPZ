package corso.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import corso.java.entities.City;
import corso.java.entities.Province;
import corso.java.entities.Region;
import corso.java.entities.Area;

public class CitiesLoader {
	private String fileName;

	public CitiesLoader(String fileName) {
		this.fileName = fileName;
	}

	public List<City> readFile() {
		var result = new ArrayList<City>();
		try {
			// apre un buffered reader sul file indicato da fileName
			try (var r = new BufferedReader(new FileReader(fileName))) {
				String line; // per leggere una riga del file
				// le prime tre righe non mi servono
				for (var i = 0; i < 3; ++i)
					line = r.readLine();
				// leggo il resto del file
				while ((line = r.readLine()) != null) {
					// System.out.println(line);
					String[] parts = line.split(";");
					var city = City.builder() //
							// nome
							.withName(parts[5])
							// codice
							.withId(Integer.parseInt(parts[4]))
							// capoluogo
							.withCapital(parts[13].charAt(0) == '1')
							// codice catastale
							.withCadastralCode(parts[19]).withProvince(
									// province
									Province.builder()
											// nome
											.withName(parts[11])
											// codice
											.withId(Integer.parseInt(parts[2]))
											// sigla
											.withAcronym(parts[14])
											// regione
											.withRegion(Region.builder()
													// nome
													.withName(parts[10])
													// codice
													.withId(Integer.parseInt(parts[0]))
													// area geografica
													.withArea(Area.builder()
															// nome
															.withName(parts[9])
															// codice
															.withId(Integer.parseInt(parts[8])) //
															.build()) //
													.build()) //
											.build())//
							.build();
					result.add(city);
				}
			}
		} catch (IOException e) {

		}
		return result;
	}
}
