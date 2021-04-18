package com.kantar.sessionsjob.inputOutputPackage;

import com.kantar.sessionsjob.recordModel.Record;
import com.kantar.sessionsjob.recordService.ModifyRecord;
import com.kantar.sessionsjob.recordService.SortRecord;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class OperationService {

    private static final Logger LOGGER = Logger.getLogger(OperationService.class.getName());

    private final ReadFile readFile = new ReadFile();
    private final WriteFile writeFile = new WriteFile();
    private final SortRecord sortRecord = new SortRecord();
    private final ModifyRecord modifyRecord = new ModifyRecord();

    public void operationOnFile(final String pathToInputFile, final String pathToOutputFIle) {
            final List<Record> listOfRecords = getRecordFromFile(pathToInputFile);
            final List<Record> finalListOfRecord = modifyRecord.addEndTimeAndDuration(listOfRecords);
            LOGGER.info("Finish update records.");
            writeFile.writeDataToFile(finalListOfRecord, pathToOutputFIle);
    }

    private List<Record> getRecordFromFile(String pathToFile) {
        return Optional.ofNullable(pathToFile)
                .map(path -> convert(pathToFile))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(this::sortRecords)
                .orElse(null);
    }

    private Optional<List<Record>> convert(final String pathToFile) {
        try {
            return Optional.of(readFile.readDataFromFileAsRecord(pathToFile));
        } catch (IOException e) {
            LOGGER.error("Problem with path/input file." + e.getCause());
            return Optional.empty();
        }
    }

    private List<Record> sortRecords(List<Record> listOfRecords) {
        return sortRecord.sortListByHomeNoAndDateTime(listOfRecords);
    }
}