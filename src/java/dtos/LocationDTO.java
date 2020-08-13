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
public class LocationDTO implements Serializable{
    private String devicesID, room, time, userIDChange, reason;

    public LocationDTO() {
    }

    public LocationDTO(String devicesID, String room, String time, String userIDChange, String reason) {
        this.devicesID = devicesID;
        this.room = room;
        this.time = time;
        this.userIDChange = userIDChange;
        this.reason = reason;
    }
    
    public String getDevicesID() {
        return devicesID;
    }

    public void setDevicesID(String devicesID) {
        this.devicesID = devicesID;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserIDChange() {
        return userIDChange;
    }

    public void setUserIDChange(String userIDChange) {
        this.userIDChange = userIDChange;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
}
