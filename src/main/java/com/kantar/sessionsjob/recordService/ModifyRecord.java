package com.kantar.sessionsjob.recordService;

import com.kantar.sessionsjob.recordModel.Record;

import java.util.ArrayList;
import java.util.List;

public class ModifyRecord {

    private DurationAnalyzer durationAnalyzer = new DurationAnalyzer();
    private EndTimeAnalyzer endTimeAnalyzer = new EndTimeAnalyzer();

    public List<Record> addEndTimeAndDuration(List<Record> inputDataList) {
        List<Record> updatedList = new ArrayList<>();
        for (int i = 0; i < inputDataList.size(); i++) {
            Record record = inputDataList.get(i);
            if (inputDataList.size() != i + 1) {
                record = endTimeAnalyzer.calculateEndTimePerOneRecord(record, inputDataList.get(i + 1));
            } else {
                record = endTimeAnalyzer.calculateEndTimePerOneRecord(record, null);
            }
            record = durationAnalyzer.calculateDurationPerOneRecord(record);

            updatedList.add(record);
        }
        return updatedList;
    }
}