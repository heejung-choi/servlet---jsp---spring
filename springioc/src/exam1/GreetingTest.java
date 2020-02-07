package exam1;

import java.time.LocalTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam1/beans.xml");		
		LocalTime local = (LocalTime)factory.getBean("localtime");			
		int hour = local.getHour(); 
		System.out.println(hour);		
		
		String time;			
		if(hour>=6 && hour<12) {
			time="Morning";				
		}else if(hour>=12 && hour<17) {
			time="After";			
		}else if(hour>=17 && hour<22){
			time="Even";					
		}else {		
			time="Night";				
		}
		Greeting gre = (Greeting)factory.getBean(time);
		gre.greet();
		((ClassPathXmlApplicationContext)factory).close();
	}
}
//main에서 실행시켜야 값이 나온다.