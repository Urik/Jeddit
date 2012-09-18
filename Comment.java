package Reddit;

import java.util.LinkedList;
import java.util.List;

public class Comment implements Commentable {

	private String body;
	private boolean edited;
	private String subreddit_id;
	private String author_flair_css_class;
	private double created;
	@Exclude private List<Comment> replies;
	private String banned_by;
	private Integer downs;
	private String author;
	private Double created_utc;
	private String body_html;
	private String link_id;
	private String parent_id;
	private String approved_by;
	private Integer likes;
	private String author_flair_text;
	private String id;
	private String subreddit;
	private int num_reports;
	private Integer ups;
	private String name;

	@Override
	public boolean addComment(String body, String userHash) {
		return new CommentableImpl(this).addComment(body, userHash);
	}

	public String getBody() {
		return body;
	}

	public boolean isEdited() {
		return edited;
	}

	public String getSubreddit_id() {
		return subreddit_id;
	}

	public String getAuthor_flair_css_class() {
		return author_flair_css_class;
	}

	public double getCreated() {
		return created;
	}
	@Exclude 
	public List<Comment> getReplies() {
		return replies;
	}

	public String getBanned_by() {
		return banned_by;
	}

	public int getDowns() {
		return downs;
	}

	public String getAuthor() {
		return author;
	}

	public double getCreated_utc() {
		return created_utc;
	}

	public String getBody_html() {
		return body_html;
	}

	public String getLink_id() {
		return link_id;
	}

	public String getParent_id() {
		return parent_id;
	}

	public String getApproved_by() {
		return approved_by;
	}

	public int getLikes() {
		return likes;
	}

	public String getAuthor_flair_text() {
		return author_flair_text;
	}

	public String getId() {
		return id;
	}

	public String getSubreddit() {
		return subreddit;
	}

	public int getNum_reports() {
		return num_reports;
	}

	public int getUps() {
		return ups;
	}

	public String getName() {
		return name;
	}

	public int getTotalChildrenCount() {
		int amount = 0;
		if (replies != null) {
			for (Comment comment : replies) {
				amount += comment.getTotalChildrenCount();
			}
		} else {
			amount = 1;
		}
		return amount;
	}

	public boolean getEdited() {
		return edited;
	}

	public void setEdited(boolean edited) {
		this.edited = edited;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setSubreddit_id(String subreddit_id) {
		this.subreddit_id = subreddit_id;
	}

	public void setAuthor_flair_css_class(String author_flair_css_class) {
		this.author_flair_css_class = author_flair_css_class;
	}

	public void setCreated(double created) {
		this.created = created;
	}
	@Exclude 
	public void setReplies(List<Comment> replies) {
		this.replies = replies;
	}

	public void setBanned_by(String banned_by) {
		this.banned_by = banned_by;
	}

	public void setDowns(int downs) {
		this.downs = downs;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCreated_utc(double created_utc) {
		this.created_utc = created_utc;
	}

	public void setBody_html(String body_html) {
		this.body_html = body_html;
	}

	public void setLink_id(String link_id) {
		this.link_id = link_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public void setAuthor_flair_text(String author_flair_text) {
		this.author_flair_text = author_flair_text;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSubreddit(String subreddit) {
		this.subreddit = subreddit;
	}

	public void setNum_reports(int num_reports) {
		this.num_reports = num_reports;
	}

	public void setUps(int ups) {
		this.ups = ups;
	}

	public void setName(String name) {
		this.name = name;
	}

}
