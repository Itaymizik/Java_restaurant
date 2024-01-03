package q2;

import java.util.HashMap;
import java.util.Map;

public class Order
{
	private Map<MenuItem, Integer> items = new HashMap<>();

	public void addItem(MenuItem item, int quantity)
	{
		items.put(item, quantity);
	}

	public String toString()
	{
		String str = "";
		for (MenuItem menuItem : items.keySet())
		{
			str += menuItem.getItemName() + " - " + items.get(menuItem) + "\n";
		}

		return str;
	}
}
