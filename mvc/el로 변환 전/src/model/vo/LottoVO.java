package model.vo;

public class LottoVO {
	private String msg; /* VO에서는 직접 멤버에 접근 못하게 private를 사용한다. */
	private String imgUrl;
	private boolean linkDisplay;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public boolean isLinkDisplay() {
		return linkDisplay;
	}
	public void setLinkDisplay( boolean linkDisplay) {
		this.linkDisplay = linkDisplay;
	}
}
