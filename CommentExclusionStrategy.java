package Reddit;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class CommentExclusionStrategy implements ExclusionStrategy {

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(Exclude.class) != null;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return clazz.getAnnotation(Exclude.class) != null;
	}

}
