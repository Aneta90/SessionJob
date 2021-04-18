package com.kantar.sessionsjob.inputOutputPackage;

import com.kantar.sessionsjob.recordModel.Record;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ReadFile {

    private static final Logger LOGGER = Logger.getLogger(ReadFile.class.getName());

    List<Record> readDataFromFileAsRecord(String inputFileName) throws IOException {
        CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
        CSVReader reader = new CSVReaderBuilder(new FileReader(inputFileName)).withCSVParser(csvParser).withSkipLines(1).build();

        List<Record> homeRecords = new ArrayList<>();
        String[] record;
        try {
            while ((record = reader.readNext()) != null) {
                Record homeRecord = Record.builder().homeNo(Long.valueOf(record[0])).channel(record[1]).startTime(record[2]).activity(record[3]).build();
                homeRecords.add(homeRecord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
        return homeRecords;
    }
}