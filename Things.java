package Reddit;

public enum Things {
	COMMENT ("t1"),
	ACCOUNT ("t2"),
	LINK ("t3"),
	MESSAGE ("t4"),
	SUBREDDIT ("t5");
	
	private String value;
	private Things(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
