package sampleanno10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component   //스프링컨테이너가 객체생성을 대신해주도록 하고있다.
public class MyMessage {
	@Autowired
	String message; /* 객체를 넣어주는 것을 인젝션 한다고 한다. */
	
	public MyMessage(){
		System.out.println("Create object 0 : "+message);		
	}
	@Autowired
	public MyMessage(String m){
		System.out.println("Create object 1 : "+m);		
	}
	@Autowired
	public void setMessage(String message) {
		System.out.println("SETTER : "+message);
		this.message = message;
	}
	@Autowired // 만들어질때 생성자를 자동으로 String m으로 하게 한다.
	public void ccc(String message) {
		System.out.println("ccc : "+message);
		this.message = message;
	}
	@Autowired
	public void aaa(String message) {
		System.out.println("aaa : "+message);
		this.message = message;
	}
	@Autowired
	public void bbb(String message) {
		System.out.println("bbb : "+message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}	
}
