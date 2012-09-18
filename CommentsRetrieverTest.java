package Reddit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class CommentsRetrieverTest {

	@Test
	public void test() {
		Post mock = mock(Post.class);
		when(mock.getUrl()).thenReturn("/r/blog/comments/g5i83/so_long_and_thanks_for_all_the_postcards");
		CommentsRetriever lala = new CommentsRetriever();
		List<Comment> comments = lala.retrieveComments(mock, 0, CommentsOrder.BEST);
	}

}
