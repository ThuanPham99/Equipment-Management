/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.DeviceDAO;
import daos.LocationDAO;
import dtos.DeviceDTO;
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
public class UpdateDeviceAction {

    private String userID, reason, checkRoom;
    private String ID, name, description, type, room, image, dateOfBuy, guaranteePeriod;
    private int numberOfRepairs;
    private String status;
    private DeviceDTO dto;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String INVALID = "invalid";

    public UpdateDeviceAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        try {
            DeviceDAO deviceDao = new DeviceDAO();
            LocationDAO locationDao = new LocationDAO();

            dto = new DeviceDTO(ID, name, description, type, room, image, dateOfBuy, guaranteePeriod, numberOfRepairs, status);
            if (deviceDao.updateDevice(dto)) {
                if (!room.trim().equals(checkRoom.trim())) {
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                    Date date = calendar.getTime();
                    String time = formatter.format(date);
                    LocationDTO locationDto = new LocationDTO(ID.trim(), room, time, userID.trim(), reason.trim());
                    locationDao.insertNewLocation(locationDto);
                }
                url = SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().contains("FK_Devices_Room")) {
                HttpServletRequest request = ServletActionContext.getRequest();
                request.setAttribute("ERROR", "Room dont exsited");
                request.setAttribute("dto", dto);
                url = INVALID;
            }
            if (e.getMessage().contains("duplicate")) {
                url = INVALID;
                HttpServletRequest request = ServletActionContext.getRequest();
                request.setAttribute("ERROR2", "you Can't change room 2 times in one day");
            }

        }
        return url;
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

    public DeviceDTO getDto() {
        return dto;
    }

    public void setDto(DeviceDTO dto) {
        this.dto = dto;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateOfBuy() {
        return dateOfBuy;
    }

    public void setDateOfBuy(String dateOfBuy) {
        this.dateOfBuy = dateOfBuy;
    }

    public String getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(String guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    public int getNumberOfRepairs() {
        return numberOfRepairs;
    }

    public void setNumberOfRepairs(int numberOfRepairs) {
        this.numberOfRepairs = numberOfRepairs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
