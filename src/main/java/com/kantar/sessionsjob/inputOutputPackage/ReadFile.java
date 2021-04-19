package com.kantar.sessionsjob.inputOutputPackage;

import com.kantar.sessionsjob.recordModel.Record;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ReadFile {

    private static final Logger LOGGER = LogManager.getLogger(ReadFile.class);

    List<Record> readDataFromFileAsRecord(final String inputFileName) {
        List<Record> homeRecords = new ArrayList<>();
        CSVReader reader;
        String[] record;

        try {
            CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
            reader = new CSVReaderBuilder(new FileReader(inputFileName)).withCSVParser(csvParser).withSkipLines(1).build();
            while ((record = reader.readNext()) != null) {
                Record homeRecord = Record.builder().homeNo(Long.valueOf(record[0])).channel(record[1]).startTime(record[2]).activity(record[3]).build();
                homeRecords.add(homeRecord);
            }
            reader.close();
        } catch (IOException e) {
            LOGGER.error("Problem with fie reading", e.getCause());
        }
        return homeRecords;
    }
}