package corso.java.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CityLoader {
	private final List<City> cities = new ArrayList<City>();

	public Stream<City> getCities() {
		return cities.stream();
	}

	public CityLoader(String fileName) {
		try (var r = new BufferedReader(new FileReader(fileName, Charset.forName("Windows-1252")))) {
			// salto la prima riga (intestazione)
			r.readLine(); // la leggo ma non la memorizzo da nessuna parte...
			String line;
			while ((line = r.readLine()) != null) {
				String[] parts = line.split(";");

				// trim() toglie spazi iniziali e finali (a sinistra e destra)
				int c = Integer.parseInt(parts[2].trim());
				
				float h = Float.parseFloat(parts[4].trim()
						// sostituisce tutti i . con una stringa vuota (in pratica elimina il .)
						.replace(".", "")
						// sostituisce la , con il punto per consentire la conversione in float
						.replace(",", "."));
				int p = Integer.parseInt(parts[7].trim().replace(".", ""));
				cities.add(new City(c, parts[3].trim(), h, p));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
