package exam1;

public class EveningGreetingImpl implements Greeting{
	public EveningGreetingImpl() {		
		super();	
	}
	@Override
	public void greet() {
		System.out.println("편안한 저녁되세요.");		
	}
}
