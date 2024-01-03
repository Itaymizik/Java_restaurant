package q2;

import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class MenuOption extends HBox
{
	private MenuItem item;
	private CheckBox checked;
	private ComboBox<Integer> cmbQuantity;

	public MenuOption(MenuItem item)
	{
		this.item = item;
		int x, y;
		x = y = 10;
		getChildren().add(checked = new CheckBox(item.getItemName()));
		getChildren().add(cmbQuantity = new ComboBox<>(FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
		cmbQuantity.getSelectionModel().selectFirst();
	}

	@Override
	public String toString()
	{
		return item + " " + cmbQuantity.getSelectionModel().getSelectedItem();
	}

	public boolean isSelected()
	{
		return checked.selectedProperty().get();
	}

	public MenuItem getItem()
	{
		return item;
	}

	public int getQuantity()
	{
		return cmbQuantity.selectionModelProperty().get().getSelectedItem();
	}

	public void clear()
	{
		checked.selectedProperty().set(false);
		cmbQuantity.getSelectionModel().selectFirst();
	}

}
