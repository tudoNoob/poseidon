package com.poseidon.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.poseidon.exception.DateSqlParseException;

public class PoseidonUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(PoseidonUtils.class);

	public static java.sql.Date convertToDate(String toDate) {

		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		Date parsed;
		java.sql.Date sql = null;
		try {
			parsed = format.parse(toDate);
			sql = new java.sql.Date(parsed.getTime());
		} catch (ParseException e) {
			LOGGER.error("Error parsing the date.", e);
			throw new DateSqlParseException(e);
		}

		return sql;
	}
	public static String convertDateToString(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String 	parsed = format.format(date);

		return parsed;
	}

	public static java.sql.Date convertToDate(Date toDate) {

		java.sql.Date sql = null;
		sql = new java.sql.Date(toDate.getTime());

		return sql;
	}

	public static String CADASTRO_SUCCESS = "Cadastro efetuado com sucesso.";

	public static String CADASTRO_ERROR = "Erro ao efetuar o cadastro.";
}
