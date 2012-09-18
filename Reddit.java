package Reddit;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Reddit {

	public List<SubReddit> getDefaultSubReddits() {
		String json = new PetitionMaker().getDefaultReddits();
		List<SubReddit> subReddits = new LinkedList<SubReddit>();
		JsonParser parser = new JsonParser();
		JsonObject parent = parser.parse(json).getAsJsonObject();
		JsonArray jsonSubReddits = parent.get("data").getAsJsonObject()
				.get("children").getAsJsonArray();
		for (JsonElement element : jsonSubReddits) {
			JsonObject jsonSubReddit = element.getAsJsonObject().get("data")
					.getAsJsonObject();
			Gson gson = new Gson();
			SubReddit subReddit = gson.fromJson(jsonSubReddit, SubReddit.class);
			subReddits.add(subReddit);
		}
		return subReddits;
	}

}
