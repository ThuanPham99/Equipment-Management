/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.io.Serializable;

/**
 *
 * @author NT
 */
public class ChangeRoomByRepairerAction implements Serializable{
    private String deviceID,room;
    private static final String SUCCESS = "success";
    public ChangeRoomByRepairerAction() {
    }
    
    public String execute() throws Exception {
        String url = SUCCESS;
        return url;
    }

    public ChangeRoomByRepairerAction(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
}
