package Reddit;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LogInSession {
	private String modhash;
	private String cookie;
	
	public boolean connect() {
		PetitionMaker mailGuy = new PetitionMaker();
		String result = mailGuy.logIn("hunter2", "*****".toCharArray());
		JsonParser parser = new JsonParser();
		JsonObject parent = parser.parse(result).getAsJsonObject();
		//Si hubo un error
		if(parent.get("errors").getAsJsonArray().size() > 0) {
			return false;
		} else {
			JsonObject data = parent.get("data").getAsJsonObject();
			modhash = data.get("modhash").getAsString();
			cookie = data.get("cookie").getAsString();
		}
		return true;
	}
}
