package Reddit;

public enum NewPostsTime {
	RISING("rising"),
	NEW("new");
	
	private NewPostsTime(String value) {
		this.value = value;
	}
	
	private String value;
	public String getValue() {
		return value;
	}
}
