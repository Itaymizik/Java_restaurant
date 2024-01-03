package q2;

public class MenuItem
{

	private String itemName;
	private ItemType itemType;
	private double price;

	public MenuItem(String itemName, ItemType itemType, double price)
	{
		this.itemName = itemName;
		this.itemType = itemType;
		this.price = price;
	}

	public String getItemName()
	{
		return itemName;
	}

	public ItemType getItemType()
	{
		return itemType;
	}

	public double getPrice()
	{
		return price;
	}

	@Override
	public String toString()
	{
		return "MenuItem [itemName=" + itemName + ", itemType=" + itemType + ", price=" + price + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		MenuItem other = (MenuItem) obj;
		if (itemName == null)
		{
			if (other.itemName != null) return false;
		}
		else
			if (!itemName.equals(other.itemName)) return false;
		return true;
	}

}