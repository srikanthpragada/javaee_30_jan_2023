package springmvc.model;

public class Course {
	private String title;
	private int fee, duration;
	
	public Course() {
		super();
	}

	public Course(String title, int fee, int duration) {
		super();
		this.title = title;
		this.fee = fee;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
