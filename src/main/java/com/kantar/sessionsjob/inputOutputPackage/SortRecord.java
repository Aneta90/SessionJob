package com.kantar.sessionsjob.inputOutputPackage;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortRecord {

    /*private ReadFile readFile;

    public SortRecord(ReadFile readFile) {
           this.readFile = readFile;
    }
    */

    public List<Record> sortListByHomeNoAndDateTime(List<Record> inputList) {
        return inputList.stream()
                .sorted(Comparator.comparing(Record::getHomeNo)
                        .thenComparing(Record::getStartTime))
                .collect(Collectors.toList());
    }
}