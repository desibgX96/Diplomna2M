package com.diplomna2m.serialize.impl;

public class SerializationEsception extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SerializationEsception(String message) {
		super(message);
	}

	public SerializationEsception(String message, Throwable cause) {
		super(message, cause);
	}
}
