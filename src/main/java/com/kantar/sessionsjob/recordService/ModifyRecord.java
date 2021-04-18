package com.kantar.sessionsjob.inputOutputPackage;

import com.kantar.sessionsjob.analyzerPackage.DurationAnalyzer;
import com.kantar.sessionsjob.analyzerPackage.EndTimeAnalyzer;
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

/*

    private DurationAnalyzer durationAnalyzer;
    private EndTimeAnalyzer endTimeAnalyzer;

    public ModifyRecord(DurationAnalyzer durationAnalyzer, EndTimeAnalyzer endTimeAnalyzer) {
        this.durationAnalyzer = durationAnalyzer;
        this.endTimeAnalyzer = endTimeAnalyzer;
    }

    public List<Record> addEndTimeAndDuration(List<Record> inputDataList) {
        List<Record> updatedList = new ArrayList<>();
        for(int i=0;i<inputDataList.size()-1;i++){ //przypadek brzegowy
            Record record = inputDataList.get(i);
            record = endTimeAnalyzer.calculateEndTimePerOneRecord(record, inputDataList.get(i+1));
            record = durationAnalyzer.calculateDurationPerOneRecord(record);
            updatedList.add(record);
        }
        return updatedList;
      /*  return inputDataList.stream()
                .map(a -> a.toString().concat("|").concat(endTime).concat("|").concat(String.valueOf(duration)))
                .collect(Collectors.toList());*/
