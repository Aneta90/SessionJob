package com.kantar.sessionsjob.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Converter {

    public static LocalDateTime convertStringToLocalDateTime(String string){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return LocalDateTime.parse(string, formatter);
    }

    public static String convertLocalDateTimeToString(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return localDateTime.format(formatter);
    }
}