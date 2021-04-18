package com.kantar.sessionsjob.recordModel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Record {

    private Long homeNo;
    private String channel;
    private String startTime;
    private String activity;
    private String endTime;
    private Long duration;

    @Override
    public String toString() {
        return homeNo + "|" + channel + "|" + startTime + '|' + activity + '|' + endTime + '|' + duration;
    }
}