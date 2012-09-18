package Reddit;

import java.util.List;

public class Listing<E> {
	private String before;
	private String after;
	private String modhash;
	private List<Thing<E>> children;
	public String getBefore() {
		return before;
	}
	public String getAfter() {
		return after;
	}
	public String getModhash() {
		return modhash;
	}
	public List<Thing<E>> getChildren() {
		return children;
	}
}
