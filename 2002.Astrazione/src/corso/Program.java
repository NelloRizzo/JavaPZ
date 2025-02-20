package corso;

import corso.java.data.Animal;
import corso.java.data.Dog;
import corso.java.data.Elephant;
import corso.java.data.InsertableInZoo;
import corso.java.data.Lion;
import corso.java.data.Singer;

public class Program {

	public static void zoo(InsertableInZoo[] a) {
		for (int i = 0; i < a.length; ++i) {
			a[i].makeNoise();
			a[i].bark();
		}
	}

	public static void main(String[] args) {
		// Vogliamo gestire uno zoo in cui tutti gli animali possano produrre il loro
		// verso.
		InsertableInZoo[] animals = { //
				//new Animal("Leone", "ruggisco"), //
				new Lion(),
				new Lion(),
				//new Animal("Elefante", "barrisco"), //
				new Elephant(),
				// new Animal("Cane", "abbaio"), //
				new Dog("Fido"),
				new Elephant(),
				//new Animal("Minollo", "boh!!!!") //
				new Singer("D'Alessio", "Le domeniche d'agosto quanta neve che cadrà")
		};

		zoo(animals);
	}

}
