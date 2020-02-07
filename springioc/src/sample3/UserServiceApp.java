package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceApp {
	public static void main(String[] args) {
		ApplicationContext factory
        		=new ClassPathXmlApplicationContext("sample3/applicationContext.xml");
		System.out.println("** Container Initialization End **");
		
		UserService u1=(UserService)factory.getBean("userService");
		UserVo vo = (UserVo) factory.getBean("obj1"); /* getbeen 할때마다 객체가 생성된다. */
		u1.addUser(vo);
		System.out.println(u1);
		System.out.println("----------------------------------------------------");
		
		UserService u2=factory.getBean("userService", UserService.class);
		/* 두번째 아규먼트로 어떤 타입으로 받을것인지 지정해줘도 된다.(반드시 확장자까지 지정해줘야 한다.) 
		 * 조상형에서 자녀형으로 형변환을 하지 않고도 이렇게 하면 
		 * 가능하다. */
		UserVo vo2 = (UserVo)factory.getBean("obj2");
		u2.addUser(vo2);
		System.out.println(u2);		
		((ClassPathXmlApplicationContext)factory).close();
		/* 스프링 컨테이너는 외부자원이기 때문에 close를 해줘야 하는데 부모형은 갖고있지 않아서 자손형으로 형변환해서 해줘야 한다. */
	}
}





