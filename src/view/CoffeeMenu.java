package view;

import java.util.Scanner;

import controller.CoffeeManager;
import model.exception.CoffeeException;
import model.vo.Coffee;

public class CoffeeMenu {
	// 커피 주문 화면
	public static CoffeeManager cm = new CoffeeManager();

	public static void showMenu() {
		// #1 변수였을 때
		/*
		 * System.out.println("==길동이의 커피 프린세스 ver1.0==");
		 * System.out.println("-------------------------------");
		 * System.out.println("1.아메리카노"); System.out.println("2.카페라떼");
		 * System.out.println("3.카푸치노"); System.out.print("메뉴를 선택하세요:"); int
		 * sel=sc.nextInt(); System.out.print("주문할 잔의 수:"); int cups=sc.nextInt();
		 * String coffeeName=null; int price=0;
		 * 
		 * switch(sel) { case 1: coffeeName="아메리카노"; price=3000; break; case 2:
		 * coffeeName="카페라떼"; price=3500; break; case 3: coffeeName="카푸치노"; price=4000;
		 * break; } System.out.println("주문하신 커피는 "+coffeeName+" 이며");
		 * System.out.println("총 "+cups+"잔 이며");
		 * System.out.println("가격은 "+(price*cups)+"원 입니다.");
		 */

		// #2 배열을 사용했을 때
		/*
		 * int cup[]=new int[3];
		 * 
		 * System.out.println("==길동이의 커피 프린세스 ver1.5==");
		 * System.out.println("-------------------------------");
		 * System.out.println("1.아메리카노"); System.out.println("2.카페라떼");
		 * System.out.println("3.카푸치노"); System.out.print("메뉴를 선택하세요:");
		 * cup[0]=sc.nextInt(); System.out.print("주문할 잔의 수:"); cup[1]=sc.nextInt();
		 * String coffeeName=null;
		 * 
		 * switch(cup[0]) { case 1: coffeeName="아메리카노"; cup[2]=3000; break; case 2:
		 * coffeeName="카페라떼"; cup[2]=3500; break; case 3: coffeeName="카푸치노";
		 * cup[2]=4000; break; }
		 * 
		 * System.out.println("주문하신 커피는 "+coffeeName+" 이며");
		 * System.out.println("총 "+cup[1]+"잔 이며");
		 * System.out.println("가격은 "+(cup[2]*cup[1])+"원 입니다.");
		 */

		// #3 Coffee 객체를 사용할 경우
		/*
		 * System.out.println("==길동이의 커피 프린세스 ver1.8==");
		 * System.out.println("-------------------------------");
		 * System.out.println("1.아메리카노"); System.out.println("2.카페라떼");
		 * System.out.println("3.카푸치노"); System.out.print("메뉴를 선택하세요:"); int
		 * sel=sc.nextInt(); System.out.print("주문할 잔의 수:"); int cup=sc.nextInt();
		 * 
		 * System.out.println("주문하신 커피의 정보입니다.");
		 * 
		 * Coffee co = new Coffee(sel,cup); System.out.println(co);
		 */

		// #4.객체 배열을 사용할 경우
		Scanner sc = new Scanner(System.in);

		do {
			initMenu(3.0);
			System.out.print("메뉴 확인:");
			int sel = sc.nextInt();
			sc.nextLine();
			switch (sel) {
			case 1:
				insertCoffee();// 커피 주문 메서드
				break;
			case 2:
				selectCoffeeOne();// 주문 번호 확인 메서드
				break;
			case 3:
				updateCoffee();// 주문 내용 변경 메서드
				break;
			case 4:
				deleteCoffee();// 주문 취소 메서드
				break;
			case 5:
				selectCoffeeAll();// 주문 전체 내역 확인 메서드
				break;
			case 6:
				System.out.print("정말 종료 하시겠습니까? (Y/N): ");
				if (sc.nextLine().toUpperCase().charAt(0) == 'Y') {
					System.out.println("프로그램 종료!");
					sc.close();
					cm.close(); // ??
					return;
				} else
					System.out.println("메뉴를 다시 불러옵니다.");
			default:
			}
		} while (true);

	}

	public static void initMenu(double version) {

		System.out.println("==길동이의 커피 프린세스 ver" + version + "==");
		System.out.println("-----------------------------------");
		System.out.println("1.커피 주문");
		System.out.println("2.주문 번호 확인");
		System.out.println("3.주문 내용 변경");
		System.out.println("4.주문 취소");
		System.out.println("5.주문 전체 내역 확인");
		System.out.println("6.프로그램 종료");

	}

	public static void insertCoffee() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("=====커피 주문 메뉴=====");
		System.out.println("1.아메리카노");
		System.out.println("2.카페라떼");
		System.out.println("3.카푸치노");
		System.out.print("메뉴 확인:");
		int sel = sc.nextInt();
		if (sel != 1 && sel != 2 && sel != 3) {
			System.out.println("선택된 메뉴가 없습니다.");
			return;
		}
		System.out.print("주문 잔 수:");
		int cups = sc.nextInt();

		System.out.println("주문 정보 확인:"); //
		System.out.println(cm.insertCoffee(new Coffee(sel, cups)));
	}

	public static void selectCoffeeOne() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("주문 번호 확인:");
		int orderNo = sc.nextInt();
		try {
			System.out.println("선택한 주문 내역");
			System.out.println(cm.verifyCoffee(orderNo));
		} catch (CoffeeException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void updateCoffee() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		// 내가 작성한 코드
		/*
		 * while (true) { System.out.println("1.주문 변경"); System.out.println("2.이전 메뉴로");
		 * System.out.print("메뉴 선택"); int sel = sc.nextInt(); switch (sel) { case 1:
		 * System.out.print("변경 할 주문번호:"); int orderNo = sc.nextInt(); if (cm.getCount()
		 * >= orderNo) { System.out.println(cm.getOrderArr()[orderNo - 1]);
		 * System.out.println("==변경 할 커피 목록=="); System.out.println("1.아메리카노");
		 * System.out.println("2.카페라떼"); System.out.println("3.카푸치노");
		 * System.out.print("변경 할 메뉴 확인:"); cm.getOrderArr()[orderNo -
		 * 1].setCoffeeName(sc.nextInt()); System.out.print("주문 잔 수:");
		 * cm.getOrderArr()[orderNo - 1].setCups(sc.nextInt()); cm.updateCoffee(orderNo,
		 * cm.getOrderArr()[orderNo - 1]); System.out.println("변경된 주문 확인");
		 * System.out.println(cm.getOrderArr()[orderNo - 1]); break; } else
		 * System.out.println("주문번호가 존재하지 않습니다."); continue; case 2: return; default:
		 * System.out.println("잘못 입력했습니다."); } }
		 */
		// try catch 간략화
		System.out.print("주문 번호 확인:");
		int orderNo = sc.nextInt();
		try {
			System.out.println("주문 내역 확인");
			System.out.println(cm.verifyCoffee(orderNo));
			System.out.println("---메뉴---");
			System.out.println("1.아메리카노");
			System.out.println("2.카페라떼");
			System.out.println("3.카푸치노");
			System.out.print("메뉴 확인:");
			int sel = sc.nextInt();
			System.out.print("주문 잔 수:");
			int cups = sc.nextInt();
			cm.updateCoffee(orderNo, new Coffee(sel, cups));
			System.out.println("변경 되었습니다.");
			System.out.println(cm.verifyCoffee(orderNo));
		} catch (CoffeeException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void deleteCoffee() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		// 내가 작성한 코드
		/*
		 * while (true) { System.out.println("1.주문 목록 보기");
		 * System.out.println("2.이전 메뉴로"); System.out.print("선택:"); int
		 * sel=sc.nextInt();
		 * 
		 * switch(sel) { case 1: System.out.println("어떤 주문을 취소하시겠습니까?"); allCoffee();
		 * break; case 2: System.out.println("이전 메뉴로 돌아갑니다."); return; default:
		 * continue; }
		 * 
		 * if (cm.getCount() < 1) { return; } else System.out.print("취소할 주문 번호 입력:");
		 * int orderNo = sc.nextInt(); sc.nextLine(); if (orderNo <= cm.getCount() &&
		 * orderNo > 0) { System.out.print("정말 취소 하시겠습니까? (Y/N):"); char ch =
		 * sc.nextLine().toUpperCase().charAt(0); switch (ch) { case 'Y':
		 * cm.deleteCoffee(orderNo); System.out.println("취소되었습니다."); allCoffee();
		 * return; case 'N': deleteCoffee(); return; default: continue; }
		 * 
		 * } }
		 */
		// try catch 간략화
		System.out.print("주문 번호 확인:");
		int orderNo = sc.nextInt();
		sc.nextLine();
		try {
			System.out.println("주문 내역확인");
			System.out.println(cm.verifyCoffee(orderNo));
			System.out.print("정말 취소 하시겠습니까? (Y/N):");
			if (sc.nextLine().toUpperCase().charAt(0) == 'Y') {
				cm.deleteCoffee(orderNo - 1);
				System.out.println("주문이 정상적으로 취소되었습니다.");
			} else {
				System.out.println("메인으로 돌아갑니다.");
			}
		} catch (CoffeeException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void selectCoffeeAll() {
		System.out.println("전체 주문 내역");
		for (Coffee cp : cm.getOrderList()) {
			System.out.println(cp);
		}

	}
}
