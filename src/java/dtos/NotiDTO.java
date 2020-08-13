/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author NT
 */
public class NotiDTO {
    private String sender,time,deviceID,receiver,type,mailContext;

    public NotiDTO() {
    }

    public NotiDTO(String sender, String time, String mailContext) {
        this.sender = sender;
        this.time = time;
        this.mailContext = mailContext;
    }

    public NotiDTO(String time, String deviceID) {
        this.time = time;
        this.deviceID = deviceID;
    }

    public NotiDTO(String sender, String time, String deviceID,String type) {
        this.sender = sender;
        this.time = time;
        this.deviceID = deviceID;
        this.type = type;
    }

    public NotiDTO(String sender, String time, String deviceID, String type, String mailContext) {
        this.sender = sender;
        this.time = time;
        this.deviceID = deviceID;
        this.type = type;
        this.mailContext = mailContext;
    }


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMailContext() {
        return mailContext;
    }

    public void setMailContext(String mailContext) {
        this.mailContext = mailContext;
    }




}
