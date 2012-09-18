package Reddit;

public enum PostsTime {
	ALL_TIME ("all"),
	THIS_HOUR ("hour"),
	TODAY ("day"),
	THIS_WEEK("week"),
	THIS_MONTH("month"),
	THIS_YEAR("year");
	
	private String time;
	private PostsTime(String time) {
		this.time = time;
	}
	
	public String getValue() {
		return time;
	}
}
