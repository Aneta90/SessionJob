package com.kantar.sessionsjob.analyzerPackage;

import com.kantar.sessionsjob.inputOutputPackage.Record;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Pattern;

public class DurationAnalyzer {

    public Record analyze(Record currentRecord) {
            LocalDateTime startDateTime = currentRecord.getStartTime();
            LocalDateTime endDateTime = currentRecord.getEndTime();
            currentRecord.setDuration(calculateDuration(startDateTime, endDateTime));
            return currentRecord;
    }

    /**
     * calculating time between startTime and endTime
     *
     * @param startTime time when user starts watching
     * @param endTime
     * @return number of seconds
     */
    private Long calculateDuration(LocalDateTime startTime, LocalDateTime endTime) {
        return ChronoUnit.SECONDS.between(startTime, endTime) + 1L;
    }
}