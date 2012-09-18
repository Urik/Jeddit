package Reddit;

public enum CommentsOrder {
	BEST ("confidence"),
	NEW ("new"),
	OLD ("old"),
	HOT ("hot"),
	CONTROVERSIAL ("controversial"),
	TOP ("top");
	
	private String value;
	private CommentsOrder(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
