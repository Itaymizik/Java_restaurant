package q2;

import java.util.ArrayList;

public class Menu {
	private ArrayList<MenuItem> deserts;
	private ArrayList<MenuItem> mainDishes;
	private ArrayList<MenuItem> starters;
	private ArrayList<MenuItem> drinks;

	public Menu() {
		deserts = new ArrayList<>();
		mainDishes = new ArrayList<>();
		starters = new ArrayList<>();
		drinks = new ArrayList<>();
	}

	public void add(MenuItem item) {
		switch (item.getItemType()) {
		case Desert:
			deserts.add(item);
			break;
		case MainDish:
			mainDishes.add(item);
			break;
		case Starter:
			starters.add(item);
			break;
		case Drink:
			drinks.add(item);
			break;
		}
	}

	public ArrayList<MenuItem> get(ItemType type) {
		switch (type) {
		case Desert:
			return deserts;
		case MainDish:
			return mainDishes;
		case Starter:
			return starters;
		default:
			return drinks;
		}
	}
}
