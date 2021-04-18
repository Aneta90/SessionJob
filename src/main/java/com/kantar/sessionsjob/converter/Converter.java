package com.kantar.sessionsjob.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Converter {

    private Converter() {
    }

    private static final String FORMATTER = "yyyyMMddHHmmss";

    public static LocalDateTime convertStringToLocalDateTime(final String string) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATTER);
        return LocalDateTime.parse(string, formatter);
    }

    public static String convertLocalDateTimeToString(final LocalDateTime localDateTime) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATTER);
        return localDateTime.format(formatter);
    }
}