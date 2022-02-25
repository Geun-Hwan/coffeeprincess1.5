package controller;

import mode.dao.CoffeeDao;
import model.exception.CoffeeException;
import model.vo.Coffee;

public class CoffeeManager {
	private Coffee[] orderArr;
	private CoffeeDao coDao;

	public CoffeeManager() {
		orderArr = new Coffee[10]; // 주문 10개 받는 객체 배열
	}

	public int getCount() {
		return count;
	}

	public Coffee[] getOrderArr() {
		return orderArr;
	}

	public void setOrderArr(Coffee[] orderArr) {
		this.orderArr = orderArr;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// 커피 주문 정보 등록
	public Coffee insertCoffee(Coffee coffee) {
		// 현재 주문된 커피의 주문번호 등록
		coffee.setOrderNo(count + 1);

		// 주문 리스트에 현재 주문 추가하기
		orderArr[count++] = coffee;

		return coffee;
	}

	// 주문 정보 확인
	public Coffee verifyCoffee(int orderNo) throws CoffeeException {
		if (orderNo > count || orderNo == 0) {
			throw new CoffeeException(("잘못된 주문 정보입니다."));
		}

		return orderArr[orderNo - 1];
	}

	// 주문 정보 변경
	public void updateCoffee(int orderNo, Coffee coffee) {
		orderArr[orderNo - 1] = coffee;
		coffee.setOrderNo(orderNo);
	}

	// 주문 취소
	public void deleteCoffee(int idx) {
		orderArr[idx] = null;

		for (int i = idx; i < count; i++) {
			if (i == count - 1) {			
				break;
			} else if (count <= orderArr.length && orderArr[i + 1] != null) {
				orderArr[i] = orderArr[i + 1];
				orderArr[i].setOrderNo(i + 1);
				orderArr[i+1] = null;
			}
		}
		count--;
	}
}
