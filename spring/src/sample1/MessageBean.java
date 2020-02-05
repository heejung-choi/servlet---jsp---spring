package sample1;

public interface MessageBean {
	public void sayHello();
	public void sayHello(String a, int b);
}

/* 스프링컨테이너가 관리해주는 것 bean */
/* 인터페이스를 사용하면 유지보수성이 좋다. */