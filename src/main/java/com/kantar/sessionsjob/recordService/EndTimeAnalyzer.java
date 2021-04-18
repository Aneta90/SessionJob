package com.kantar.sessionsjob.analyzerPackage;

import com.kantar.sessionsjob.converter.Converter;
import com.kantar.sessionsjob.recordModel.Record;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class EndTimeAnalyzer {

    public Record calculateEndTimePerOneRecord(Record currentRecord, Record nextRecord) {
        if (nextRecord == null) {
            currentRecord.setEndTime(setEndOfDayByDefault(currentRecord));
            return currentRecord;
        }
        if (currentRecord.getHomeNo().equals(nextRecord.getHomeNo())) {
            currentRecord.setEndTime(setEndOfDayIfMoreThanOneRecordPerHomeNo(nextRecord));
            return currentRecord;
        }
        currentRecord.setEndTime(setEndOfDayByDefault(currentRecord));
        return currentRecord;
    }

    private String setEndOfDayByDefault(Record record){
        LocalDateTime localDateTime = Converter.convertStringToLocalDateTime(record.getStartTime());
        return Converter.convertLocalDateTimeToString(localDateTime.toLocalDate().atTime(LocalTime.MIDNIGHT.minusSeconds(1)));
    }

    private String setEndOfDayIfMoreThanOneRecordPerHomeNo(Record record){
        LocalDateTime localDateTime = Converter.convertStringToLocalDateTime(record.getStartTime());
        return Converter.convertLocalDateTimeToString(localDateTime.minusSeconds(1));
    }
}