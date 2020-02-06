package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudyApp {
	public static void main(String[] args) {
		ApplicationContext factory =
				   new ClassPathXmlApplicationContext("exam2/bean1.xml");
		
		Student b1 = (Student)factory.getBean("st1");		
		System.out.println(b1.getName()+"는 "+b1.getMyHomework().getHomeworkName()+"를 학습합니다.");		
		
		Student b2 = (Student)factory.getBean("st2");
		System.out.println(b2.getName()+"는 "+b2.getMyHomework().getHomeworkName()+"를 학습합니다.");
		
		Student b3 = (Student)factory.getBean("st3");
		System.out.println(b3.getName()+"는 "+b1.getMyHomework().getHomeworkName()+"를 학습합니다.");
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
