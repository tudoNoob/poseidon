package com.poseidon.utils;

import java.text.*;
import java.util.Date;

import org.slf4j.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poseidon.exception.DateSqlParseException;
import java.util.logging.Level;

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
        String parsed = format.format(date);

        return parsed;
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
            LOGGER.info("Nâoc osneguiu executar o pare de objeto para json como strnig.", e);
        }
        return result;
    }

    public static String CADASTRO_SUCCESS = "Cadastro efetuado com sucesso.";

    public static String CADASTRO_ERROR = "Erro ao efetuar o cadastro.";
}
