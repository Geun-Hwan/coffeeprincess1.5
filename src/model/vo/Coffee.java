package model.vo;

@SuppressWarnings("serial")
public class Coffee implements java.io.Serializable {
	private int orderNo;// 커피 주문 번호
	private String coffeeName; // 커피명
	private int cups; // 잔 수
	private int price; // 가격

	public Coffee() {

	}

	public Coffee(int type, int cups) {
		setCoffeeName(type);
		setCups(cups);
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(int type) {
		switch (type) {
		case 1:
			this.coffeeName = "아메리카노";
			this.price = 3000;
			break;
		case 2:
			this.coffeeName = "카페라떼";
			this.price = 3500;
			break;
		case 3:
			this.coffeeName = "카푸치노";
			this.price = 4000;
			break;
		default:
			
		}
	}

	public int getCups() {
		return cups;
	}

	public void setCups(int cups) {
		this.cups = cups;
		setPrice(price * cups);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "[주문번호:" + orderNo + ", 커피명:" + coffeeName + ", 잔수:" + cups + ", 가격:" + price + "]";
	}

}
