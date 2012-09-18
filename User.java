package Reddit;

import java.util.ArrayList;
import java.util.List;


public class User {
	private String nick;
	private char[] password;
	private String email;
	
	public List<Comment> getComments() {
		//TODO retrieve comments
		return new ArrayList<Comment>();
	}
	
	public List<Post> getPosts() {
		//TODO retrieve posts
		return new ArrayList<Post>();
	}
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
