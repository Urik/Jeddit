package Reddit;

import java.util.Calendar;


public interface Posteable {
	public Calendar getDate();
	public User getAuthor();
	public String getBody();
}
