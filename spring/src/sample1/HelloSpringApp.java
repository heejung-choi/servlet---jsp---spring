package sample1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class HelloSpringApp {
	public static void main(String[] args) {
		ApplicationContext factory
		    	= new ClassPathXmlApplicationContext("sample1/beans.xml");//스프링을 초기화하는 것 
		// beans.xml만 준다면 src에서 찾는다.
		//초기화할때 스프링컨테이너에게 요구하고 싶은것을 bean에 담고 있다.
		System.out.println("**** Container Initialization End ****");		
		MessageBean bean = (MessageBean) factory.getBean("messageBean"); /* 메세지빈이라는 객체를 찾아와서 */
		bean.sayHello(); /* sayHello 실행 */ /* strawberry 3000 출력 */
		bean.sayHello("banana", 1500); /* 빈이라는 태그때문에 sayhello를 미리 생성했다. spring이 초기화 될때 */
		/* banana 1500 출력 */
		System.out.println(bean); /* 객체를 호출하시요 -> 자동으로 tostring -> string 이 없으므로 object에 있는 것이 출력된다. */
		System.out.println(factory.getBean("messageBean"));
		System.out.println(factory.getBean("messageBean"));
		((ClassPathXmlApplicationContext)factory).close();
	}
}





