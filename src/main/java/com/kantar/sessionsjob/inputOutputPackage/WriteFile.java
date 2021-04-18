package com.kantar.sessionsjob.inputOutputPackage;

import com.kantar.sessionsjob.recordModel.Record;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class WriteFile {

    void writeDataToFile(List<Record> listOfData, String outputFileName) throws IOException {
        String headers = addHeaders();
        List<String> listWithHeaders = new ArrayList<>();
        listWithHeaders.add(headers);
        listWithHeaders.addAll(convertListTOSrings(listOfData));
        Files.write(Paths.get(outputFileName), listWithHeaders);
    }

    private List<String> convertListTOSrings(List<Record> records){
        List<String> stringList = new ArrayList<>();
        for (Record record : records) {
            stringList.add(record.toString());
        }
        return stringList;
    }

    private String addHeaders() {
        return "HomeNo|Channel|StartTime|Activity|EndTime|Duration";
    }
}