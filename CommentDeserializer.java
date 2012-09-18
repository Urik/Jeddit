package Reddit;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class CommentDeserializer implements JsonDeserializer<Comment> {

	@Override
	public Comment deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		Comment comment = null;
		Gson gson = new GsonBuilder().setExclusionStrategies(new CommentExclusionStrategy()).create();
		JsonObject auxThing = json.getAsJsonObject();
		if (auxThing.get("kind").getAsString().equals(Things.COMMENT.getValue())) { //If is a comment
			JsonObject commentJson = auxThing.get("data").getAsJsonObject();
			comment = gson.fromJson(commentJson, Comment.class);
			if (commentJson.get("replies").isJsonObject()){
				JsonArray commentsJson = commentJson.get("replies").getAsJsonObject().get("data").getAsJsonObject().get("children").getAsJsonArray();
				List<Comment> replies = new ArrayList<>();
				Gson recursiveGson = new GsonBuilder().registerTypeAdapter(Comment.class, new CommentDeserializer()).setExclusionStrategies(new CommentExclusionStrategy()).create();
				for (JsonElement element : commentsJson) {
					Comment reply = recursiveGson.fromJson(element, Comment.class);
					if (reply != null) {
						replies.add(reply);
					}
				}
				comment.setReplies(replies);
			}
		}
		return comment;
	}

}
