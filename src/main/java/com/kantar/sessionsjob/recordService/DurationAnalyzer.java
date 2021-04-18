package com.kantar.sessionsjob.recordService;

import com.kantar.sessionsjob.converter.Converter;
import com.kantar.sessionsjob.recordModel.Record;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class DurationAnalyzer {

    Record calculateDurationPerOneRecord(Record currentRecord) {
        LocalDateTime startDateTime = Converter.convertStringToLocalDateTime(currentRecord.getStartTime());
        LocalDateTime endDateTime = Converter.convertStringToLocalDateTime(currentRecord.getEndTime());
        currentRecord.setDuration(calculateDuration(startDateTime, endDateTime));
        return currentRecord;
    }

    /**
     * calculating time between startTime and endTime
     *
     * @param startTime time when user starts watching
     * @param endTime time when user stops watching
     * @return number of seconds
     */
    private Long calculateDuration(LocalDateTime startTime, LocalDateTime endTime) {
        return ChronoUnit.SECONDS.between(startTime, endTime) + 1L;
    }
}