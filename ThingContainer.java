package Reddit;

import java.util.List;

public class ThingContainer<E> {
	private String modhash;
	private List<Thing<E>> children;
	private String after;
	private String before;
	
	public String getModhash() {
		return modhash;
	}
	public List<Thing<E>> getChildren() {
		return children;
	}
	
	
}
