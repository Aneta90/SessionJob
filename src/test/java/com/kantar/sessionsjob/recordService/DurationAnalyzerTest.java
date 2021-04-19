package com.kantar.sessionsjob.recordService;

import com.kantar.sessionsjob.recordModel.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DurationAnalyzerTest {

    private DurationAnalyzer durationAnalyzer;
    private Record currentRecord;
    private Record currentRecord2;
    private Record currentRecord3;

    @BeforeEach
    void init() {
        durationAnalyzer = new DurationAnalyzer();
        currentRecord = Record.builder().homeNo(900L).channel("621").startTime("20200102060000").activity("PlayBacks").endTime("20200102075959").duration(null).build();
        currentRecord2 = Record.builder().homeNo(777L).channel("602").startTime("20200101070000").activity("Live").endTime("20200101175959").duration(null).build();
        currentRecord3 = Record.builder().homeNo(900L).channel("623").startTime("20200101210000").activity("Live").endTime("20200101235959").duration(null).build();
    }

    @Test
    void calculateDurationForSampleRecords(){
        Record currentRecordWithDuration = durationAnalyzer.calculateDurationPerOneRecord(currentRecord);
        Record currentRecordWithDuration2 = durationAnalyzer.calculateDurationPerOneRecord(currentRecord2);
        Record currentRecordWithDuration3 = durationAnalyzer.calculateDurationPerOneRecord(currentRecord3);
        assertEquals(7200,currentRecordWithDuration.getDuration());
        assertEquals(39600,currentRecordWithDuration2.getDuration());
        assertEquals(10800,currentRecordWithDuration3.getDuration());
    }
}