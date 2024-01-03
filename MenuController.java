package q2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class MenuController {
	// These constants are used to index the options in the JOptionPane dialog.
	private static final int CANCEL_INDEX = 2;
	private static final int UPDATE_INDEX = 1;
	private static final int CONFIRM_INDEX = 0;
	
	@FXML
	private VBox vboxStarters;
	@FXML
	private VBox vboxMainDishes;
	@FXML
	private VBox vboxDeserts;
	@FXML
	private VBox vboxDrinks;
	private Menu menu;

	@FXML
	private void initialize() {
		menu = loadMenu();
		displayMenu();
	}
	
	// This method adds the menu items to the JavaFX components defined in the FXML
	private void displayMenu() {
		for (MenuItem item : menu.get(ItemType.MainDish)) {
			vboxMainDishes.getChildren().add(new MenuOption(item));
		}
		for (MenuItem item : menu.get(ItemType.Desert)) {
			vboxDeserts.getChildren().add(new MenuOption(item));
		}
		for (MenuItem item : menu.get(ItemType.Drink)) {
			vboxDrinks.getChildren().add(new MenuOption(item));
		}
		for (MenuItem item : menu.get(ItemType.Starter)) {
			vboxStarters.getChildren().add(new MenuOption(item));
		}
	}

	// This method loads the menu from the file and returns it as a Menu object.
	private Menu loadMenu() {
		// read all file
		Scanner input = null;
		Menu menu = new Menu();
		try {
			input = new Scanner(new File("src/q2/menu.txt"));
			while (input.hasNext()) {
				String itemName = input.next();
				ItemType itemType = Enum.valueOf(ItemType.class, input.next());
				double price = Double.valueOf(input.next());
				MenuItem item = new MenuItem(itemName, itemType, price);
				menu.add(item);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return menu;
	}

	@FXML
	private void order() {
		// When the user clicks the "Make Order" button, create a new Order object and add the selected items to it.
		Order order = new Order();
		addItems(order, ItemType.Starter);
		addItems(order, ItemType.MainDish);
		addItems(order, ItemType.Drink);
		addItems(order, ItemType.Desert);
		int userChoice = JOptionPane.showOptionDialog(null, order.toString(), "Your Order",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { "Confirm", "Update", "Cancel" }, "Confirm");
		switch (userChoice) {
		case CONFIRM_INDEX:
			String name = JOptionPane.showInputDialog(null, "Enter your name:");
			String id = JOptionPane.showInputDialog(null, "Enter your id:");
			writeOrderToFile(order, name, id);
			break;
		case UPDATE_INDEX:

			break;
		case CANCEL_INDEX:
			cancelOrder();
			break;
		}
	}

	//This method writes the order information to a file with a name and ID specified as parameters.
	private void writeOrderToFile(Order order, String name, String id) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(name + id))));
			bw.write(order.toString());
		} catch (Exception e) {
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void cancelOrder() {
		//For each MenuOption, it calls the clear() method to deselect the option.
		cancelOrder(ItemType.Starter);
		cancelOrder(ItemType.MainDish);
		cancelOrder(ItemType.Drink);
		cancelOrder(ItemType.Desert);
	}

	private void cancelOrder(ItemType type) {
		VBox vbox = null;
		switch (type) {
		case MainDish:
			vbox = vboxMainDishes;
			break;
		case Starter:
			vbox = vboxStarters;
			break;
		case Desert:
			vbox = vboxDeserts;
			break;
		case Drink:
			vbox = vboxDrinks;
			break;
		}

		for (Node node : vbox.getChildren()) {
			MenuOption menuOption = (MenuOption) node;
			menuOption.clear();
		}
	}

	private void addItems(Order order, ItemType type) {
		//For each MenuOption, it checks if it is selected and, if so, adds the corresponding item and quantity to the Order.
		VBox vbox = null;
		switch (type) {
		case MainDish:
			vbox = vboxMainDishes;
			break;
		case Starter:
			vbox = vboxStarters;
			break;
		case Desert:
			vbox = vboxDeserts;
			break;
		case Drink:
			vbox = vboxDrinks;
			break;
		}

		for (Node node : vbox.getChildren()) {
			MenuOption menuOption = (MenuOption) node;
			if (menuOption.isSelected()) {
				order.addItem(menuOption.getItem(), menuOption.getQuantity());
			}
		}
	}
}
