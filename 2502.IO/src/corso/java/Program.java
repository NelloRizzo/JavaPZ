package corso.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		var input = ".\\Esempio.txt";
		var output = ".\\Copia.txt";
		try {
//			var fis = new FileInputStream(input);
//			var fos = new FileOutputStream(output);
			var r = new BufferedReader(new FileReader(input));
			var w = new BufferedWriter(new FileWriter(output));
//			int content;
//			while ((content = r.read()) != -1) {
//				fos.write(content);
//			}
			String line;
			while ((line = r.readLine()) != null) {
				System.out.println(line);
				w.write(line.toUpperCase()); w.write('\n');
			}
			r.close();
			w.close();
//			fos.close();
//			fis.close();
		} catch (IOException e) {
			System.out.println(
					"Problema di I/O... forse il file non è disponibile o non hai permessi o c'è un errore sul disco...");
		} 
	}

}
