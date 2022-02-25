package model.vo;

public class Drink {
	private int orderNo;
	private String drinkName; 
	private int cups;  
	private int price;
	
	public Drink() {
		
	}
	
	public Drink(int orderNo, String drinkName, int cups, int price) {
		this.orderNo = orderNo;
		this.drinkName = drinkName;
		this.cups = cups;
		this.price = price;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public int getCups() {
		return cups;
	}

	public void setCups(int cups) {
		this.cups = cups;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Drink [orderNo=" + orderNo + ", drinkName=" + drinkName + ", cups=" + cups + ", price=" + price + "]";
	}
	
}
