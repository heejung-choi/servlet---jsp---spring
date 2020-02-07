package exam1;

public class AfternoonGreetingImpl implements Greeting{
	public AfternoonGreetingImpl() {		
		super();	
	}
	@Override
	public void greet() {
		System.out.println("즐거운 오후되세요.");		
	}
}
