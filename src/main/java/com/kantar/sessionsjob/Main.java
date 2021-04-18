package com.kantar.sessionsjob;

import com.kantar.sessionsjob.analyzerPackage.DurationAnalyzer;
import com.kantar.sessionsjob.analyzerPackage.EndTimeAnalyzer;
import com.kantar.sessionsjob.inputOutputPackage.*;

import java.io.IOException;
import java.util.List;

public class Main {
    // See README.txt for usage example

    public static void main(String[] args) throws IOException {
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();
        EndTimeAnalyzer endTimeAnalyzer = new EndTimeAnalyzer();
        DurationAnalyzer durationAnalyzer = new DurationAnalyzer();
        ModifyRecord modifyRecord = new ModifyRecord();
        SortRecord sortRecord = new SortRecord();

        List<Record> listOfRecords = readFile.readDataFromFileAsRecord("C:\\Users\\aw22\\Downloads\\Audience Exercise - Java\\kantar_audience_exercise_java\\src\\test\\resources\\input-statements.psv");

            List<Record> sortedRecords = sortRecord.sortListByHomeNoAndDateTime(listOfRecords);
            System.out.println(sortedRecords.toString());
            String endTime = endTimeAnalyzer.calculateEndTimePerOneRecord(sortedRecords);
            System.out.println(endTime);
            Long duration = durationAnalyzer.analyze(sortedRecords, endTime);

            List<String> finalList = modifyRecord.addEndTimeAndDuration(sortedRecords, endTime, duration);
            writeFile.writeDataToFile(finalList, "C:\\Users\\aw22\\Downloads\\Audience Exercise - Java\\kantar_audience_exercise_java\\src\\test\\resources\\expected-sessions.psv");

        }

      /*  if (args.length < 2) {
            System.err.println("Missing arguments: <input-statements-file> <output-sessions-file>");
            System.exit(1);
        }*/

        // TODO: write application ...

    }