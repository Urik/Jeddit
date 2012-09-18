package Reddit;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class CommentsRetriever {
	public List<Comment> retrieveComments(Post post, int amount,
			CommentsOrder commentsOrder) {
		PetitionMaker jsonRetriever = new PetitionMaker();
		String json = jsonRetriever.getComments(post,
				commentsOrder);
		List<Comment> comments= new ArrayList<>();
		JsonArray commentsJson = new JsonParser().parse(json).getAsJsonArray().get(1).getAsJsonObject().get("data").getAsJsonObject().get("children").getAsJsonArray();
		Gson gson = new GsonBuilder().setExclusionStrategies(new CommentExclusionStrategy()).registerTypeAdapter(Comment.class, new CommentDeserializer()).create();
		for (JsonElement commentJson : commentsJson) {
			Comment comment = gson.fromJson(commentJson, Comment.class); 
			if (comment != null) {
				comments.add(comment);
			}
		}
		int totalCommentsCount = getTotalCommentsCount(comments);
		while(totalCommentsCount < amount) {
			//String moreCommentsJson = jsonRetriever.getMoreComments("t3_zavzt", post.getSubreddit());
		}
		return comments;
	}

	
	
	
	private int getTotalCommentsCount(List<Comment> comments) {
		int amount = 0;
		for (Comment comment : comments) {
			if (comment != null) {
				amount += comment.getTotalChildrenCount();
			}
		}
		return amount;
	}
}
