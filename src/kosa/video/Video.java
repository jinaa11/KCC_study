package kosa.video;

// 1개의 비디오를 위한 클래스
public class Video {
	private int num;
	private String title;
	private String actor;

	public Video() {
	}

	public Video(int num, String title, String actor) {
		this.num = num;
		this.title = title;
		this.actor = actor;
	}

	public void show() {
		System.out.println("회원이 대여한 비디오 번호: " + num);
		System.out.println("회원이 대여한 비디오 제목: " + title);
		System.out.println("회원이 대여한 비디오 배우: " + actor);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}
}
