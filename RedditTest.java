package Reddit;

import java.util.List;

import org.junit.Test;

public class RedditTest {

	@Test
	public void testGetDefaultSubReddits() {
		Reddit reddit = new Reddit();
		List<SubReddit> subReddits = reddit.getDefaultSubReddits();
		int a = 3;
	}

}
