package com.kantar.sessionsjob.inputOutputPackage;

import com.kantar.sessionsjob.recordModel.Record;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class WriteFile {

    private static final Logger LOGGER = LogManager.getLogger(WriteFile.class);
    private static final String HEADERS = "HomeNo|Channel|StartTime|Activity|EndTime|Duration";

    void writeDataToFile(final List<Record> listOfData, final String outputFileName) {
        final List<String> listWithHeaders = new ArrayList<>();
        listWithHeaders.add(HEADERS);
        listWithHeaders.addAll(convertListToStrings(listOfData));
        try {
            Files.write(Paths.get(outputFileName), listWithHeaders);   
        } catch (IOException e){
            LOGGER.error("Problem with outputFile",e.getCause());
        }
    }

    private List<String> convertListToStrings(final List<Record> records) {
        return records.stream().map(Object::toString).collect(Collectors.toList());
    }
}