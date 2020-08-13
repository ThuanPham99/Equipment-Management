/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.DeviceDAO;
import daos.NotiDAO;
import dtos.NotiDTO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class RequestRepairAction {

    private String sender, deviceID, status;
    private static final String SUCCESS = "success";

    public RequestRepairAction() {
    }

    public String execute() throws Exception {
        String url = SUCCESS;
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            status = status.trim();
            if (!status.trim().equals("03")) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
                Date date = calendar.getTime();
                String time = formatter.format(date);
                NotiDAO notiDao = new NotiDAO();
                DeviceDAO deviceDAO = new DeviceDAO();
                deviceID = deviceID.trim();
                NotiDTO dto = new NotiDTO(sender.trim(), time, deviceID, "Request");
                if(notiDao.insertRequest(dto)){
                    if(deviceDAO.setStatus(deviceID,"03")){
                        request.setAttribute("ERROR", "SUCCESS");
                    }
                }else{
                    request.setAttribute("ERROR", "Some Thing went Wrong, Try Again");
                }
                
                
            } else {
                request.setAttribute("ERROR", deviceID + " is being repaired");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

}
