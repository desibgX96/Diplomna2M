package com.diplomna2m.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.springframework.stereotype.Component;

import com.diplomna2m.filerw.FileIO;

@Component
public class FileIOImpl implements FileIO {

	//@Override
	public void write(String content, String filename) throws IOException {
		File file = new File(filename);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile(); // throws exeption
		}
		OutputStream out = new FileOutputStream(file);
		try (BufferedWriter write = new BufferedWriter(new OutputStreamWriter(out))) {
			write.write(content);
		}
	}

	//@Override
	public String read(String filename) throws IOException {
		StringBuilder build = new StringBuilder();
		InputStream in = getClass().getResourceAsStream(filename);
		try (BufferedReader read = new BufferedReader(new InputStreamReader(in))) {
			String line;
			while((line = read.readLine()) != null) {
			build.append(line);
			}
		}
		return build.toString();
	}

}
