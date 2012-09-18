package Reddit;

import java.util.ArrayList;
import java.util.List;

public class Post implements Commentable {
	private String domain;
	private String banned_by;
	private String subreddit;
	private String selftext_html;
	private String selftext;
	private String likes;
	private String link_flair_text;
	private String id;
	private boolean clicked;
	private String title;
	private int num_comments;
	private int score;
	private String approved_by;
	private boolean over_18;
	private boolean hidden;
	private String thumbnail;
	private String subreddit_id;
	private boolean edited;
	private String link_flair_css_class;
	private String author_flair_css_class;
	private int downs;
	private boolean saved;
	private boolean is_self;
	private String permalink;
	private String name;
	private double created;
	private double created_utc;
	private String url;
	private String author_flair_text;
	private String author;
	private String media;
	private int num_reports;
	private int ups;
	
	@Override
	public boolean addComment(String body, String userHash) {
		return new CommentableImpl(this).addComment(body, userHash);
	}

	public String getDomain() {
		return domain;
	}

	public String getBanned_by() {
		return banned_by;
	}

	public String getSubreddit() {
		return subreddit;
	}

	public String getSelftext_html() {
		return selftext_html;
	}

	public String getSelftext() {
		return selftext;
	}

	public String getLikes() {
		return likes;
	}

	public String getLink_flair_text() {
		return link_flair_text;
	}

	public String getId() {
		return id;
	}

	public boolean isClicked() {
		return clicked;
	}

	public String getTitle() {
		return title;
	}

	public int getNum_comments() {
		return num_comments;
	}

	public int getScore() {
		return score;
	}

	public String getApproved_by() {
		return approved_by;
	}

	public boolean isOver_18() {
		return over_18;
	}

	public boolean isHidden() {
		return hidden;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public String getSubreddit_id() {
		return subreddit_id;
	}

	public boolean isEdited() {
		return edited;
	}

	public String getLink_flair_css_class() {
		return link_flair_css_class;
	}

	public String getAuthor_flair_css_class() {
		return author_flair_css_class;
	}

	public int getDowns() {
		return downs;
	}

	public boolean isSaved() {
		return saved;
	}

	public boolean isIs_self() {
		return is_self;
	}

	public String getPermalink() {
		return permalink;
	}

	public String getName() {
		return name;
	}

	public double getCreated() {
		return created;
	}

	public double getCreated_utc() {
		return created_utc;
	}

	public String getUrl() {
		return url;
	}

	public String getAuthor_flair_text() {
		return author_flair_text;
	}

	public String getAuthor() {
		return author;
	}

	public String getMedia() {
		return media;
	}

	public int getNum_reports() {
		return num_reports;
	}

	public int getUps() {
		return ups;
	}
	
	public List<Comment> getComments(int amout, CommentsOrder order) {
		return new CommentsRetriever().retrieveComments(this, 0, order);
	}
}
