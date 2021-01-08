package com.diplomna2m.filerw;

import java.io.IOException;

public interface FileIO {

	void write(String content, String filename) throws IOException;

	String read(String filename) throws IOException;

}
