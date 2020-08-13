/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.DeviceDAO;
import daos.NotiDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class ConfrimRepairAction {

    private String userID, myID, deviceID;
    private static final String SUCCESS = "success";

    public ConfrimRepairAction() {
    }

    public String execute() throws Exception {
        String url = SUCCESS;
        try {
            userID = userID.trim();
            deviceID = deviceID.trim();
            HttpServletRequest request = ServletActionContext.getRequest();
            NotiDAO notiDao = new NotiDAO();
            DeviceDAO deviceDao = new DeviceDAO();
            //chuyen request thanh processing
            if (notiDao.processingRequest(myID, "Request", deviceID)) {
                //thay doi status cua device
//                deviceDao.setStatus(deviceID, "03");
                
                String msg = "Repaer " + myID + " have confirmed your request ( repair  Device :" + deviceID + " )";
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
                Date date = calendar.getTime();
                String time = formatter.format(date);
                //thong bao da xac nhan request cua sender
                notiDao.wirteMailConfirm(myID, userID, msg, time,"Confirm");
                
                request.setAttribute("ERROR", "Success");
            }else{
                request.setAttribute("ERROR", "SomeThing Went Wrong");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMyID() {
        return myID;
    }

    public void setMyID(String myID) {
        this.myID = myID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

}
