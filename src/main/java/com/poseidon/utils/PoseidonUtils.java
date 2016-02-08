package com.poseidon.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poseidon.exception.DateSqlParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            LOGGER.error("Falha na conversão da data.", e);
            throw new DateSqlParseException(e);
        }

        return sql;
    }

    public static String convertDateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String stringFormatted = simpleDateFormat.format(date);

        return stringFormatted;
    }

    public static java.sql.Date convertToDate(Date toDate) {
        java.sql.Date sql = null;
        sql = new java.sql.Date(toDate.getTime());

        return sql;
    }

    public static java.sql.Time convertToTime(Date toDate) {
        java.sql.Time sql = null;
        sql = new java.sql.Time(toDate.getTime());

        return sql;
    }

    public static String convertStringtoJSON(Object input) {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result = mapper.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            LOGGER.info("Falha na conversão", e);
        }
        return result;
    }

	public static String CADASTRO_SUCCESS = "Cadastro efetuado com sucesso.";

	public static String CADASTRO_ERROR = "Erro ao efetuar o cadastro.";
}
