package com.diplomna2m.util;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;

public final class DTOConvertUtil {

	private DTOConvertUtil() {
	}

	public static <S, D> D convert(S source, Class<D> destinationClass) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(source, destinationClass);
	}

	public static <S, D> Set<D> convertToSet(Iterable<S> sources, Class<D> destinationClass) {
		Set<D> dSet = new HashSet<D>();
		for (S s : sources) {
			dSet.add(convert(s, destinationClass));
		}
		return dSet;
	}

}
