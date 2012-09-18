package Reddit;

import java.util.LinkedList;
import java.util.List;

public class SubReddit {
	private String display_name;
	private String header_img;
	private String title;
	private String url;
	private String description;
	private double created;
	private double created_utc;
	private List<Integer> header_size;
	private boolean over18;
	private int subscribers;
	private int accounts_active;
	private String public_description;
	private String header_title;
	private String id;
	private String name;
	
	public List<Post> getPosts(PostsList kindOfList, PostsTime postsTime, int amount) {
		return new PostsRetriever().getPosts(this, amount, kindOfList, postsTime);
	}
	
	public List<Post> getPosts(NewPostsTime timeOfPosts, int amount) {
		return new PostsRetriever().getPosts(this, amount, timeOfPosts);
	}
	
	public String getDisplay_name() {
		return display_name;
	}
	public String getHeader_img() {
		return header_img;
	}
	public String getTitle() {
		return title;
	}
	public String getUrl() {
		return url;
	}
	public String getDescription() {
		return description;
	}
	public double getCreated() {
		return created;
	}
	public double getCreated_utc() {
		return created_utc;
	}
	public List<Integer> getHeader_size() {
		return header_size;
	}
	public boolean isOver18() {
		return over18;
	}
	public int getSubscribers() {
		return subscribers;
	}
	public int getAccounts_active() {
		return accounts_active;
	}
	public String getPublic_description() {
		return public_description;
	}
	public String getHeader_title() {
		return header_title;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
