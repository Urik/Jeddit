package Reddit;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class PostDeserializer implements JsonDeserializer<Post> {

	@Override
	public Post deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		Post post = null;
		Gson gson = new GsonBuilder().addDeserializationExclusionStrategy(new CommentExclusionStrategy()).registerTypeAdapter(Post.class, this).registerTypeAdapter(Comment.class, new CommentDeserializer()).create();
		JsonObject postThing = json.getAsJsonArray().get(0).getAsJsonObject().get("children").getAsJsonArray().get(0).getAsJsonObject();
		if (postThing.get("kind").equals(Things.LINK.getValue())) {
			post = gson.fromJson(postThing.get("data"), Post.class);
		}
		return post;
	}

}
