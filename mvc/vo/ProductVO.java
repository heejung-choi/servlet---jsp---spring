package model.vo;

public class ProductVO {
	private int banana;
	private int halabong;
	private int apple;	
	public int getBanana() {
		return banana;
	}
	public void setBanana(int banana) {
		this.banana = this.banana + banana;
	}
	public int getHalabong() {
		return halabong;
	}
	public void setHalabong(int halabong) {
		this.halabong = this.halabong + halabong;
	}
	public int getApple() {
		return apple;
	}
	public void setApple(int apple) {
		this.apple = this.apple + apple;
	}	
}
