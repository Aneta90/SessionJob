package com.kantar.sessionsjob.inputOutputPackage;

import java.time.LocalDateTime;

public class Record {

    private Long homeNo;
    private String channel;
    private String startTime; //LocalDateTime do zastanowienia
    private String activity;
    private String endTime;
    private Long duration;

    public Long getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(Long homeNo) {
        this.homeNo = homeNo;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return homeNo + "|" + channel + "|" + startTime + '|' + activity + '|' + endTime + '|' + duration;
    }
}