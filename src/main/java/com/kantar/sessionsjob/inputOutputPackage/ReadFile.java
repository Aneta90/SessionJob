package com.kantar.sessionsjob.inputOutputPackage;

import com.kantar.sessionsjob.recordModel.Record;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ReadFile {

    List<Record> readDataFromFileAsRecord(String inputFileName) throws IOException {
        CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
        CSVReader reader = new CSVReaderBuilder(new FileReader(inputFileName)).withCSVParser(csvParser).withSkipLines(1).build();

        List<Record> homeRecords = new ArrayList<>();
        String[] record;

        //try - catch - Exception -
        while ((record = reader.readNext()) != null) {
            Record homeRecord = Record.builder().homeNo(Long.valueOf(record[0])).channel(record[1]).startTime(record[2]).activity(record[3]).build();
           /* homeRecord.setHomeNo(Long.valueOf(record[0]));
            homeRecord.setChannel(record[1]);
            homeRecord.setStartTime(record[2]);
            homeRecord.setActivity(record[3]);*/
            homeRecords.add(homeRecord);
        }
        reader.close();
        return homeRecords;
    }
}