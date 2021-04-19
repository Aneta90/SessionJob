package com.kantar.sessionsjob.inputOutputPackage;

import com.kantar.sessionsjob.recordModel.Record;
import com.kantar.sessionsjob.recordService.ModifyRecord;
import com.kantar.sessionsjob.recordService.SortRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class OperationService {

    private static final Logger LOGGER = LogManager.getLogger(OperationService.class);

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

    private List<Record> getRecordFromFile(final String pathToFile) {
        return Optional.ofNullable(pathToFile)
                .map(path -> convert(pathToFile))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(this::sortRecords)
                .orElse(null);
    }

    private Optional<List<Record>> convert(final String pathToFile) {
            return Optional.of(readFile.readDataFromFileAsRecord(pathToFile));
    }

    private List<Record> sortRecords(final List<Record> listOfRecords) {
        return sortRecord.sortListByHomeNoAndDateTime(listOfRecords);
    }
}