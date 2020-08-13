/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class CompleteRepairAction {
    private String sender,timeRequest,typeNoti,receiver,deviceID;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    public CompleteRepairAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        if(typeNoti.equals("Processing")){
            url = SUCCESS;
        }else{
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Only Processing can enter");
        }
        return url;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(String timeRequest) {
        this.timeRequest = timeRequest;
    }

    public String getTypeNoti() {
        return typeNoti;
    }

    public void setTypeNoti(String typeNoti) {
        this.typeNoti = typeNoti;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }
    
}
