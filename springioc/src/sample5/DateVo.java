package sample5;
public class DateVo {
	private String name;
	private String birth;

	/*
	 * defalut생성자만 있고 생성자 메서드가 없다. setter 인젝션과 관련이 있다.
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return name + "'s birthday : " + birth;
	}
}
