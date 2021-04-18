package com.kantar.sessionsjob;

import com.kantar.sessionsjob.inputOutputPackage.OperationService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Missing arguments: <input-statements-file> <expected-sessions-file>");
            System.exit(1);
        }

        OperationService operationService = new OperationService();
        operationService.operationOnFile(args[0], args[1]);

        /**
         * src\\test\\resources\\input-statements.psv
         * src\\test\\resources\\expected-sessions.psv
         * **/
    }
}