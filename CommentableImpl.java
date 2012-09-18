package Reddit;

import java.net.URISyntaxException;

public class CommentableImpl {
	private Commentable commentable;
	
	public CommentableImpl(Commentable commentable) {
		super();
		this.commentable = commentable;
	}

	public boolean addComment(String body, String userHash) {
		try {
			new PetitionMaker().addComment(commentable.getName(), body, userHash);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
