 package com.diplomna2m.serialize.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.diplomna2m.filerw.FileIO;
import com.diplomna2m.serialize.Seriaizer;

@Component(value = "jsonserializer")
public class JsonSerializer implements Seriaizer {

	private Gson gson;

	@Autowired
	private FileIO rwfile;

	public JsonSerializer() {
		gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
	}

	/* (non-Javadoc)
	 * @see app.serialize.api.Seriaizer#serialize(java.lang.Object, java.lang.String)
	 */
	@Override
	public <T> void serialize(T t, String filename) {
		String json = gson.toJson(t);
		try {
			rwfile.write(json, filename);
		} catch (FileNotFoundException fnfe) {
			// log here
			throw new SerializationEsception("Unable create file : " + filename, fnfe);
		} catch (SecurityException se) {
			//TODO log here
			throw new SerializationEsception("Do not have privelages to access file : " + filename, se);
		} catch (IOException e) {
			//TODO log here
			throw new SerializationEsception("Unable to write to file : " + filename, e);
		}
	}

	@Override
	public <T> T deserialize(Class<T> clazz, String filename) {
		String json;
		try {
			json = rwfile.read(filename);
		} catch (IOException e) {
			//TODO log here
			throw new SerializationEsception("Unable to read from file : " + filename, e);
		}// read from file
		return gson.fromJson(json, clazz);
	}

}
