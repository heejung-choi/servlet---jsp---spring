package sample1;

public class MessageBeanImpl implements MessageBean{
	private String fruit;
	private int cost;	
	public MessageBeanImpl() {
		super(); //조상의 생성자 호출
		System.out.println("MessageBeanImpl Default Constructor Call");
	}
	public MessageBeanImpl(String fruit) {
		super();
		this.fruit = fruit;
		System.out.println(fruit + " :  MessageBeanImpl Constructor Call");
	}

	public void setCost(int cost) {
		this.cost = cost;
		System.out.println("setCost() Call");
	}

	@Override //오버라이딩
	public void sayHello() {      
		System.out.println(fruit + "   " + cost);
	}

	@Override                     
	public void sayHello(String fruit, int cost) {   
		System.out.println(fruit + "   " + cost);
	}
}






