package com.diplomna2m.serialize.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.diplomna2m.serialize.Seriaizer;

@Component(value = "xmlserializer")
public class XMLSerializer implements Seriaizer {

	@Override
	public <T> void serialize(T t, String filename) {
		File file = new File(filename);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// log here
				throw new SerializationEsception("Unable create path to file : " + filename, e);
				//e.printStackTrace();
			}
		}
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			try (OutputStream os = new FileOutputStream(filename); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));) {
				marshaller.marshal(t,bw);
			}
		} catch (JAXBException e) {
			// log here
			throw new SerializationEsception("Unable create JAXBContext for this class : " + t, e);
			// e.printStackTrace();
		} catch (IOException e) {
			// log here
			throw new SerializationEsception("Can not acess file : " + filename, e);
		}


	}

	@Override
	public <T> T deserialize(Class<T> t, String filename) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(t);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			try (InputStream is = t.getResourceAsStream(filename); BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
				@SuppressWarnings("unchecked")
				T result = (T) unmarshaller.unmarshal(br);
				return result;
			}
		} catch (JAXBException e) {
			// log here
			throw new SerializationEsception("Unable create JAXBContext for this class : " + t, e);
			// e.printStackTrace();
		} catch (IOException e) {
			// log here
			throw new SerializationEsception("Can not acess file : " + filename, e);
		}

	}

}
