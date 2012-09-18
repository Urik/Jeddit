package Reddit;

public enum PostsList {
	HOT ("hot"), 
	NEW ("new"),
	CONTROVERSIAL ("controversial"),
	TOP ("top");
	
	private String value;
	private PostsList(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
