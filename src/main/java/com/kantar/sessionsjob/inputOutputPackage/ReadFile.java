package com.kantar.sessionsjob.inputOutputPackage;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {

    public List<String> readDataFromFile(String inputFileName) {

        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(inputFileName)).skip(1)) {
            list = stream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Record> readDataFromFileAsRecord(String inputFileName) throws IOException {
        CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
        CSVReader reader = new CSVReaderBuilder(new FileReader(inputFileName)).withCSVParser(csvParser).withSkipLines(1).build();

        List<Record> homeRecords = new ArrayList<>();
        String[] record;

        //try - catch - Exception -
        while ((record = reader.readNext()) != null) {
            Record homeRecord = new Record();
            homeRecord.setHomeNo(Long.valueOf(record[0]));
            homeRecord.setChannel(record[1]);
            homeRecord.setStartTime(LocalDateTime.parse(record[2]));
            homeRecord.setActivity(record[3]);
            homeRecords.add(homeRecord);
        }
        reader.close();
        return homeRecords;
    }
}