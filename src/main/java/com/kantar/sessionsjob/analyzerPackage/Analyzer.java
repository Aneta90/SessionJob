package com.kantar.sessionsjob.analyzerPackage;

public interface Analyzer<T> {
    T analyze(String inputRecord, String endTime);
}