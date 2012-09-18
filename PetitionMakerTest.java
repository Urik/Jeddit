package Reddit;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import static org.mockito.Mockito.*;
public class PetitionMakerTest {

	@Test
	public void testLogIn() {
		PetitionMaker maker = new PetitionMaker();
		maker.logIn("urik88", "#mamapapa88".toCharArray());
		try {
			SubReddit subReddit = mock(SubReddit.class);
			when(subReddit.getUrl()).thenReturn("/r/argentina");
			List<String> lista = new LinkedList<>();
			lista.add("c635id1");
			lista.add("c635ir0");
			lista.add("c635izp");
			maker.getMoreComments("t3_zavzt", "askreddit", lista);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
