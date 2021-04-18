package com.kantar.sessionsjob.inputOutputPackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {

    public void writeDataToFile(List<String> listOfData, String outputFileName) throws IOException {
        String headers = addHeaders();
        List<String> listWithHeaders = new ArrayList<>();
        listWithHeaders.add(headers);
        listWithHeaders.addAll(listOfData);
        Files.write(Paths.get(outputFileName), listWithHeaders);
    }

    private String addHeaders() {
        return "HomeNo|Channel|StartTime|Activity|EndTime|Duration";
    }
}