package br.com.clinica.util;

import java.util.UUID;

import br.com.clinica.exception.IllegalArgumentException;

public class Utils {

	public static void assertArgumentNotEmpty(String field, String errMessage) {
		if (field == null || field.isEmpty())
			throw new IllegalArgumentException(errMessage);
	}

	public static void assertArgumentNotNull(Object obj, String errMessage) {
		if (obj == null)
			throw new IllegalArgumentException(errMessage);
	}

	public static String gerarUUID() {
		return UUID.randomUUID().toString();
	}

}
