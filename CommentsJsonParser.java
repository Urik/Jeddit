package Reddit;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class CommentsJsonParser {
	
	public List<Comment> processJson(JsonArray commentsJson) {
		List<Comment> commentsThing = new LinkedList<>();
		JsonParser parser = new JsonParser();
		Thing<Listing<Comment>> commentsListingAux = null;
		Gson gson = new GsonBuilder().setExclusionStrategies(new CommentExclusionStrategy()).registerTypeAdapter(Comment.class, new CommentDeserializer()).create();
		for (JsonElement thing : commentsJson) {
			JsonObject auxThing = thing.getAsJsonObject();
			if (auxThing.get("kind").equals(Things.COMMENT.getValue())) { //If is a comment
				Comment comment = gson.fromJson(auxThing.get("data"), Comment.class);
				
			}
		}
		return commentsThing;
	}
	
	
}
