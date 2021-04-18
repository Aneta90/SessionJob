package com.kantar.sessionsjob.recordService;

import com.kantar.sessionsjob.recordModel.Record;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortRecord {

    public List<Record> sortListByHomeNoAndDateTime(List<Record> inputList) {
        return inputList.stream()
                .sorted(Comparator.comparing(Record::getHomeNo)
                        .thenComparing(Record::getStartTime))
                .collect(Collectors.toList());
    }
}