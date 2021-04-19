package com.kantar.sessionsjob.recordService;

import com.kantar.sessionsjob.recordModel.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModifyRecordTest {

    private ModifyRecord modifyRecord;

    private Record currentRecordUpdated;
    private Record currentRecord2Updated;
    private Record currentRecord3Updated;
    private List<Record> inputRecordsList = new ArrayList<>();

    @BeforeEach
    void init() {
        modifyRecord = new ModifyRecord();
        Record currentRecord = Record.builder().homeNo(1L).channel("1").startTime("20200110080000").activity("PlayBacks").endTime(null).duration(null).build();
        Record currentRecord2 = Record.builder().homeNo(1L).channel("2").startTime("20200110090000").activity("Live").endTime(null).duration(null).build();
        Record currentRecord3 = Record.builder().homeNo(2L).channel("3").startTime("20200101210000").activity("Live").endTime(null).duration(null).build();
        inputRecordsList.add(currentRecord);
        inputRecordsList.add(currentRecord2);
        inputRecordsList.add(currentRecord3);

        currentRecordUpdated = Record.builder().homeNo(1L).channel("1").startTime("20200110080000").activity("PlayBacks").endTime("20200110085959").duration(3600L).build();
        currentRecord2Updated = Record.builder().homeNo(1L).channel("2").startTime("20200110090000").activity("Live").endTime("20200110235959").duration(54000L).build();
        currentRecord3Updated = Record.builder().homeNo(2L).channel("3").startTime("20200101210000").activity("Live").endTime("20200101235959").duration(10800L).build();
    }

    @Test
    void modifyRecordsForSampleListOfRecords() {
        assertEquals(modifyRecord.addEndTimeAndDuration(inputRecordsList).get(0).toString(), currentRecordUpdated.toString());
        assertEquals(modifyRecord.addEndTimeAndDuration(inputRecordsList).get(1).toString(), currentRecord2Updated.toString());
        assertEquals(modifyRecord.addEndTimeAndDuration(inputRecordsList).get(2).toString(), currentRecord3Updated.toString());
    }
}