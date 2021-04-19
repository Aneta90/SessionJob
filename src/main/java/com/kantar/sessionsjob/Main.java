package com.kantar.sessionsjob;

import com.kantar.sessionsjob.inputOutputPackage.OperationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.debug("Log4j appender configuration is successful !!");
        if (args.length < 2) {
            LOGGER.error("Missing arguments: <input-statements-file> <expected-sessions-file>");
            System.exit(1);
        }
        OperationService operationService = new OperationService();
        operationService.operationOnFile(args[0],args[1]);
    }
}