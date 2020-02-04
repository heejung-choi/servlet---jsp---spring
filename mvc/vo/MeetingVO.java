package model.vo;

public class MeetingVO {
	private int id;
	private String name;
	private String title;
	private String meetingDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	@Override
	public String toString() {
		return "아이디: "+this.id+", 이름: "+this.name
				+",제목: "+this.title+", 미팅날짜: "+this.meetingDate;
	}
}
