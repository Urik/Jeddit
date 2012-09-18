package Reddit;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PetitionMaker {
	public String logIn(String userName, char[] password) {
		StringBuffer responseString = new StringBuffer();
		URIBuilder uriBuilder = new URIBuilder();
		userName = "urik88";
		uriBuilder.setScheme("http").setHost("www.reddit.com")
				.setPath("/api/login/" + userName)
				.setParameter("user-agent", "uri")
				.setParameter("api_type", "json")
				.setParameter("user", userName)
				.setParameter("passwd", password.toString());
		try {
			responseString.append(new HttpPost(uriBuilder.build()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return responseString.toString();
	}

	public String getComments(Post post, CommentsOrder commentsOrder) {
		StringBuffer responseString = new StringBuffer();
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("http").setHost("www.reddit.com")
				.setPath(post.getUrl() + "/.json");
		uriBuilder.setParameter("user-agent", "Uri!").setParameter("api_type",
				"json").setParameter("sort", commentsOrder.getValue());
		try {
			responseString.append(makeRequest(new HttpGet(uriBuilder.build())));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return responseString.toString();
	}

	public String getMoreComments(String linkID, String subReddit, List<String> children) {
		StringBuffer responseString = new StringBuffer();
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("http").setHost("www.reddit.com")
				.setPath("/api/morechildren")
				.setParameter("user-agent", "uri!")
				.setParameter("api_type", "json")
				.setParameter("link_id", linkID).setParameter("r", subReddit);
		StringBuffer childrenCreator = new StringBuffer();
		for (String commentID : children) {
			childrenCreator.append(commentID).append(", ");
		}
		if (children.size() > 0) {
			childrenCreator.delete(childrenCreator.lastIndexOf(","), childrenCreator.length());
		}
		uriBuilder.addParameter("children", childrenCreator.toString());
		try {
			responseString
					.append(makeRequest(new HttpPost(uriBuilder.build())));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		System.out.println(responseString.toString());
		return responseString.toString();
	}

	public String getDefaultReddits() {
		StringBuffer response = new StringBuffer();
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("http").setHost("www.reddit.com")
				.setPath("/reddits.json");
		uriBuilder.setParameter("user-agent", "uri!").setParameter("api_type",
				"json");
		try {
			response.append(makeRequest(new HttpGet(uriBuilder.build())));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return response.toString();
	}

	public String getNewPosts(SubReddit subReddit, NewPostsTime kindOfPost,
			String afterID) {
		StringBuffer responseString = new StringBuffer();
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("http").setHost("www.reddit.com")
				.setPath(subReddit.getUrl() + "/new/.json");
		uriBuilder.setParameter("user-agent", "uri!")
				.setParameter("api_type", "json")
				.setParameter("sort", kindOfPost.getValue());
		if (afterID != null) {
			uriBuilder.setParameter("after", afterID);
		}
		try {
			responseString.append(makeRequest(new HttpGet(uriBuilder.build())));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return responseString.toString();
	}

	public String getPosts(SubReddit subReddit, PostsList kindOfList,
			PostsTime timeOfPost, String afterID) {
		StringBuffer responseString = new StringBuffer();
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("http");
		uriBuilder.setHost("www.reddit.com");
		uriBuilder.setPath(subReddit.getUrl() + "/" + kindOfList.getValue()
				+ "/.json");
		uriBuilder.setParameter("user-agent", "uri!");
		uriBuilder.setParameter("t", timeOfPost.getValue());
		if (afterID != null) {
			uriBuilder.setParameter("after", afterID);
		}
		URI uri;
		try {
			uri = uriBuilder.build();
			responseString.append(makeRequest(new HttpGet(uri)));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return responseString.toString();
	}

	private String makeRequest(HttpUriRequest request) {
		StringBuffer stringResponse = new StringBuffer();
		try {
			HttpResponse response = new DefaultHttpClient().execute(request);
			stringResponse.append(processResponse(response));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return stringResponse.toString();
	}

	public void addComment(String parentName, String body, String userHash)
			throws URISyntaxException {
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("http").setHost("www.reddit.com")
				.setPath("/api/comment");
		uriBuilder.setParameter("parent", parentName);
		uriBuilder.setParameter("text", body);
		uriBuilder.setParameter("uh", userHash);
		URI uri = uriBuilder.build();
		makeRequest(new HttpPost(uri));
	}

	private String processResponse(HttpResponse response) throws IOException,
			IllegalStateException {
		StringBuffer responseString = new StringBuffer();
		DataInputStream inputStream = new DataInputStream(response.getEntity()
				.getContent());
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));
		String auxResponse;
		while ((auxResponse = reader.readLine()) != null) {
			responseString.append(auxResponse);
		}
		reader.close();
		return responseString.toString();
	}
}
