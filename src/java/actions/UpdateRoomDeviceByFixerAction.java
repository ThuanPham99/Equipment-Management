/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.DeviceDAO;
import daos.LocationDAO;
import dtos.LocationDTO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class UpdateRoomDeviceByFixerAction {

    private String deviceID, room, checkRoom, userID, reason;
    private static final String SUCCESS = "success";

    public UpdateRoomDeviceByFixerAction() {
    }

    public String execute() throws Exception {
        String url = SUCCESS;
        try {
            LocationDAO locationDao = new LocationDAO();
            DeviceDAO dao = new DeviceDAO();
            HttpServletRequest request = ServletActionContext.getRequest();
            if (!checkRoom.trim().equals(room.trim())) {
                if (dao.updateRoomDevice(deviceID, room)) {
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                    Date date = calendar.getTime();
                    String time = formatter.format(date);
                    LocationDTO locationDto = new LocationDTO(deviceID, room, time, userID.trim(), reason.trim());
                    
                    if(locationDao.insertNewLocation(locationDto)){
                        request.setAttribute("ERROR", "SUCCESS");
                    }
                }else{
                    request.setAttribute("ERROR", "False");
                }
            }else{
                
                request.setAttribute("ERROR", "Same room, so not change");
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCheckRoom() {
        return checkRoom;
    }

    public void setCheckRoom(String checkRoom) {
        this.checkRoom = checkRoom;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
