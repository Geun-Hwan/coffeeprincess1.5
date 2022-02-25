package mode.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.vo.Coffee;

//DAO(Data Access Object)
public class CoffeeDao {
	
	public ArrayList<Coffee> openList(){
		ArrayList<Coffee> list=new ArrayList<Coffee>();
		
		try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("coffee.dat"))){
			//ObjectInputStream객체 안에 FileInputStream("coffee.dat") 객체생성 
			while(in.available()!=-1) { //in.available() 읽을 데이터가 없으면 -1 반환 후 정지
				list.add((Coffee)in.readObject()); //데이터를 읽어들여 Coffee 타입으로 형변환 후 리스트에 추가
			}
		}catch(EOFException e) {
			System.out.println("불러오기에 성공하였습니다.");
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	public int saveList(ArrayList<Coffee> list) {  
		int result=-1;
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("coffee.dat"))){ 
			for(Coffee co:list) {
				out.writeObject(co);
			}
			result=1;
		}catch(IOException e) {
			System.out.println();
		}
		return result;
	}
	
	public void outStream(ObjectOutputStream out, Coffee co) { 
		try {
			out.writeObject(co);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
