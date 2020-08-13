/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.DeviceDAO;
import daos.NotiDAO;
import daos.RHistoryDAO;
import dtos.RHistoryDTO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class RecordRepairAction {
    private String deviceID, timeRequest, description, sender, repairer,result;
    private static final String SUCCESS = "success";
    
    public RecordRepairAction() {
    }
    
    public String execute() throws Exception {
        String url = SUCCESS;
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
            Date date = calendar.getTime();
            String timeDone = formatter.format(date);
            
            sender = sender.trim();
            repairer = repairer.trim();
            HttpServletRequest request = ServletActionContext.getRequest();
            RHistoryDAO repairHistoryDao = new RHistoryDAO();
            boolean checkResult = false;
            if(result.equals("true")){
                checkResult = true;
            }
            RHistoryDTO dto = new RHistoryDTO(deviceID, timeRequest, description, sender, repairer, timeDone, checkResult);
            
            if(repairHistoryDao.insertRepairHistory(dto)){
                //tang so lan sua chua len 1
                DeviceDAO deviceDao = new DeviceDAO();
                deviceDao.increaseNumberRepairByKey(deviceID);
                //change status cua thiet bi vs gui thu xac nhan
                
                NotiDAO notiDao = new NotiDAO();
                String msg = "";
                if(checkResult){
                    msg = "Device " + deviceID + " successful repair";
                    deviceDao.setStatus(deviceID, "01");
                    notiDao.wirteMailConfirm(repairer, sender, msg, timeDone, "Confirm");
                }else{
                    msg = "Device " + deviceID + " repair failed";
                    deviceDao.setStatus(deviceID, "02");
                    notiDao.wirteMailConfirm(repairer, sender, msg, timeDone, "Confirm");
                    
                }
                // change type cua Noti
                
                notiDao.setTypeByPrimaryKey(sender, timeRequest, "Finish");
                
                request.setAttribute("ERROR", "SUCCESS");
                
            }else{
                request.setAttribute("ERROR", "Not SUCCESS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    
}
