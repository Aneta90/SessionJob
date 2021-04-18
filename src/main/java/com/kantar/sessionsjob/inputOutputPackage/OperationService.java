package com.kantar.sessionsjob.inputOutputPackage;

import com.kantar.sessionsjob.recordModel.Record;
import com.kantar.sessionsjob.recordService.ModifyRecord;
import com.kantar.sessionsjob.recordService.SortRecord;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.List;

public class OperationService {

    private static final Logger LOGGER = Logger.getLogger(OperationService.class.getName());

    private ReadFile readFile = new ReadFile();
    private WriteFile writeFile = new WriteFile();
    private SortRecord sortRecord = new SortRecord();
    private ModifyRecord modifyRecord = new ModifyRecord();

    public void operationOnFile(String pathToInputFile, String pathToOutputFIle) throws IOException {
        List<Record> listOfRecords = getRecordFromFile(pathToInputFile);
        List<Record> finalListOfRecord = modifyRecord.addEndTimeAndDuration(listOfRecords);
        LOGGER.info("Finish update records.");
        writeFile.writeDataToFile(finalListOfRecord, pathToOutputFIle);
    }

    private List<Record> getRecordFromFile(String pathToFile) throws IOException {
        List<Record> listOfRecords = null;
        if (pathToFile != null) {
            try {
                listOfRecords = readFile.readDataFromFileAsRecord(pathToFile);
            } catch (IOException e) {
                LOGGER.error("Problem with path/input file." + e.getCause());
            }
            LOGGER.info("Finish collecting data from file");
            return sortRecords(listOfRecords);
        }
        throw new IOException("Empty path to input file");
    }

    private List<Record> sortRecords(List<Record> listOfRecords) {
        List<Record> sortedRecords = sortRecord.sortListByHomeNoAndDateTime(listOfRecords);
        LOGGER.info("Finish sorted records.");
        return sortedRecords;
    }
}