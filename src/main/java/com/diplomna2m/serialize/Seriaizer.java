package com.diplomna2m.serialize;

public interface Seriaizer {

	<T> void serialize (T t, String filename);
	
	<T> T deserialize (Class<T> t, String filename);
}
