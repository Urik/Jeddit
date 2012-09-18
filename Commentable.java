package Reddit;

public interface Commentable {
	
	public String getName();
	/**
	 * Makes a comment.
	 * @param body Text of the comment
	 * @param userHash Modhash of the logged in user. 
	 * @return true if the comment was posted.
	 */
	public boolean addComment(String body, String userHash);
}
