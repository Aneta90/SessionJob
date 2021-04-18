package com.kantar.sessionsjob.recordService;

import com.kantar.sessionsjob.recordModel.Record;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EndTimeAnalyzerTest {

    private EndTimeAnalyzer endTimeAnalyzer;
    private Record currentRecord;
    private Record nextRecord;

    @BeforeEach
    void init() {
        endTimeAnalyzer = new EndTimeAnalyzer();
        currentRecord = Record.builder().homeNo(900L).channel("621").startTime("20200102060000").activity("PlayBacks").endTime(null).duration(null).build();
        nextRecord = Record.builder().homeNo(777L).channel("602").startTime("20200101200000").activity("Live").endTime(null).duration(null).build();
    }

    @Test
    void calculateEndTimeForCurrentRecordWhenNextHomeNoIsDifferent(){
        Record currentRecordWithEndTime = endTimeAnalyzer.calculateEndTimePerOneRecord(currentRecord,nextRecord);
        Assertions.assertEquals("20200102235959",currentRecordWithEndTime.getEndTime());
    }

    @Test
    void calculateEndTimeForCurrentRecordWhenNextHomeIsTheSame(){
        Record currentRecordWithEndTime = endTimeAnalyzer.calculateEndTimePerOneRecord(currentRecord,nextRecord);
        Assertions.assertEquals("20200102235959",currentRecordWithEndTime.getEndTime());
    }

    @Test
    void calculateEndTimeForLastRecord(){
        Record currentRecordWithEndTime = endTimeAnalyzer.calculateEndTimePerOneRecord(currentRecord,null);
        Assertions.assertEquals("20200102235959",currentRecordWithEndTime.getEndTime());
    }


    //TestWithException
}