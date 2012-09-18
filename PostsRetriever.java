package Reddit;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PostsRetriever {
	/**
	 * Retrieves posts of a SubReddit. For new posts use the other getPosts method.
	 * @param subReddit The Subreddit whose posts you want to retrieve.
	 * @param amount How much posts you want.
	 * @param kindOfList hot/controversial/top
	 * @param postsTime all time/this month/this week/today/this hour 
	 * @return A list of posts.
	 */
	public List<Post> getPosts(SubReddit subReddit, int amount,
			PostsList kindOfList, PostsTime postsTime) {
		String jsonResponse = new PetitionMaker().getPosts(subReddit, kindOfList, postsTime, null);
		List<Post> posts = processJson(jsonResponse);
		while (posts.size() < amount) {
			String lastID = posts.get(posts.size()-1).getName();
			jsonResponse = new PetitionMaker().getPosts(subReddit, kindOfList, postsTime, lastID);
			posts.addAll(processJson(jsonResponse));
		}
		return posts.subList(0, amount);
	}

	/**
	 * Retrieves the new posts of a SubReddit
	 * @param subReddit	The Subreddit whose posts you want to retrieve.
	 * @param amount How much posts you want.
	 * @param newPostsTime new/rising
	 * @return A list of posts
	 */
	public List<Post> getPosts(SubReddit subReddit, int amount,
			NewPostsTime newPostsTime) {
		List<Post> posts;
		String jsonResponse = new PetitionMaker().getNewPosts(subReddit, newPostsTime, null);
		posts = processJson(jsonResponse);
		while (posts.size() < amount) {
			String lastID = posts.get(posts.size()-1).getName();
			jsonResponse = new PetitionMaker().getNewPosts(subReddit, newPostsTime, lastID);
			posts.addAll(processJson(jsonResponse));
		}
		return posts.subList(0, amount);
	}
	
	private List<Post> processJson(String json) {
		json = json.replaceAll("\"replies\":\"\"", "\"replies\":null")
				.replaceAll("\"edited\":false", "\"edited\":null");
		List<Post> posts = new LinkedList<>();
		JsonParser parser = new JsonParser();
		try {
			JsonObject parent = parser.parse(json).getAsJsonObject();
			JsonArray jsonPosts = parent.get("children").getAsJsonArray();
			Gson gson = new Gson();
			for (JsonElement jsonPost : jsonPosts) {
				posts.add(gson.fromJson(jsonPost, Post.class));
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return posts;
	}
}
