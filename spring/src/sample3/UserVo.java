package sample3;

public class UserVo {
	private String userName;

	public UserVo(String userName) {
		super();
		this.userName = userName;
		System.out.println("UserVO Constructor Call");
	}

	/* 객체생성시 반드시 spring형 전달해야 한다. */
	public String getUserName() {
		return userName;
	}
}
