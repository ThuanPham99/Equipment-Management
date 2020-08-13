/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author NT
 */
public class RHistoryDTO implements Serializable{
    private String deviceID, timeRequest, description, sender, repairer, timeDone;
    private boolean result;

    public RHistoryDTO() {
    }

    public RHistoryDTO(String deviceID, String timeRequest, String description, String sender, String repairer, String timeDone, boolean result) {
        this.deviceID = deviceID;
        this.timeRequest = timeRequest;
        this.description = description;
        this.sender = sender;
        this.repairer = repairer;
        this.timeDone = timeDone;
        this.result = result;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(String timeRequest) {
        this.timeRequest = timeRequest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRepairer() {
        return repairer;
    }

    public void setRepairer(String repairer) {
        this.repairer = repairer;
    }

    public String getTimeDone() {
        return timeDone;
    }

    public void setTimeDone(String timeDone) {
        this.timeDone = timeDone;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
    
}
