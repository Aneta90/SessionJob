package com.kantar.sessionsjob.analyzerPackage;

import com.kantar.sessionsjob.inputOutputPackage.Record;

import java.time.LocalDateTime;

public class EndTimeAnalyzer {

    private final static LocalDateTime DEFAULT_END_TIME = LocalDateTime.parse("20200101235959");

    public Record calculateEndTimePerOneRecord(Record currentRecord, Record nextRecord) {
        if (currentRecord.getHomeNo().equals(nextRecord.getHomeNo())) {
            currentRecord.setEndTime(nextRecord.getStartTime().minusSeconds(1));
            return currentRecord;
        }
        currentRecord.setEndTime(DEFAULT_END_TIME);
        return currentRecord;
    }
}