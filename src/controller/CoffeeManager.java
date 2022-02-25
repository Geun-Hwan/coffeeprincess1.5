package controller;

import java.util.ArrayList;

import mode.dao.CoffeeDao;
import model.exception.CoffeeException;
import model.vo.Coffee;

public class CoffeeManager {
	private Coffee[] orderArr;
//	private int count;
	
	private ArrayList<Coffee> orderList;
	private CoffeeDao coDao;

	public CoffeeManager() {
		orderArr = new Coffee[10]; // 주문 10개 받는 객체 배열
		//orderList=new ArrayList<Coffee>();
		coDao=new CoffeeDao();
		orderList=coDao.openList();
	}

	
	
	public Coffee[] getOrderArr() {
		return orderArr;
	}

	public ArrayList<Coffee> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(ArrayList<Coffee> orderList) {
		this.orderList=orderList;
	}

	// 커피 주문 정보 등록
	public Coffee insertCoffee(Coffee coffee) {
		// 현재 주문된 커피의 주문번호 등록
		//coffee.setOrderNo(count + 1);

		// 주문 리스트에 현재 주문 추가하기
		//orderArr[count++] = coffee;

		coffee.setOrderNo(orderList.size()+1);
		orderList.add(coffee);
		
		return coffee;
	}

	// 주문 정보 확인
	public Coffee verifyCoffee(int orderNo) throws CoffeeException {
		/*
		if (orderNo > count || orderNo == 0) {
			throw new CoffeeException(("잘못된 주문 정보입니다."));
		}

		return orderArr[orderNo - 1];
		*/
		if(orderNo>orderList.size()) {
			throw new CoffeeException("잘못된 주문 정보입니다.");
		}
		
		return orderList.get(orderNo-1);
	}

	// 주문 정보 변경
	public void updateCoffee(int orderNo, Coffee coffee) {
		//orderArr[orderNo - 1] = coffee;
		coffee.setOrderNo(orderNo);
		orderList.set(orderNo-1, coffee);
	}

	// 주문 취소
	public void deleteCoffee(int idx) {
		//orderArr[idx] = null;
		orderList.remove(idx);
		
		if(idx!=orderList.size()) {
			for(int i=idx;i<orderList.size();i++) {
				orderList.get(i).setOrderNo(i+1);
			}
		}
		/*
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
		*/
	}
	
	public void close() {
		coDao.saveList(orderList);
	}
}
