package Reddit;

import java.util.List;

public class Thing<E> {
	private String kind;
	private E data;
	public String getKind() {
		return kind;
	}
	public E getData() {
		return data;
	}
}
