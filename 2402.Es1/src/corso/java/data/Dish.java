package corso.java.data;

import java.util.ArrayList;
import java.util.List;

public class Dish extends MenuItem {
	private List<String> ingredients = new ArrayList<String>();

	public Dish(String name, float price, List<String> ingredients) {
		super(name, price);
		this.ingredients = ingredients;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return String.format("Food(ingredients=%s, item=%s)", ingredients, super.toString());
	}

}
