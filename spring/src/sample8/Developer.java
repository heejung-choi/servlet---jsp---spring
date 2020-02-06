package sample8;

public class Developer{
	private Emp emp;
	private String dept;
	
	public Developer() {
		super();
	}
	public Developer(Emp emp, String dept) {
		/* default가 아니라면 emp로 받아야만 객체생성을 할 수 있다. */
		super();
		this.emp = emp;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return emp.toString() + " Department : " + dept;
	}
}
