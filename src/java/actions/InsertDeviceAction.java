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
public class InsertDeviceAction {

    private String ID, name, description, type, room, image, dateOfBuy, guaranteePeriod;
    private int numberOfRepairs;
    private String status;
    private String userID;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String INVALID = "invalid";

    public InsertDeviceAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        LocationDAO locationDao = new LocationDAO();
        try {
            DeviceDAO dao = new DeviceDAO();
            DeviceDTO dto = new DeviceDTO(ID, name, description, type, room, image, dateOfBuy, guaranteePeriod, numberOfRepairs, status);
            if (dao.insertDevice(dto)) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = calendar.getTime();
                String time = formatter.format(date);
                LocationDTO locationDto = new LocationDTO(ID.trim(), room, time, userID.trim(), "buy a new device");
                locationDao.insertNewLocation(locationDto);
                url = SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
            HttpServletRequest request = ServletActionContext.getRequest();
            if (e.getMessage().contains("FK_Devices_Room")) {
                request.setAttribute("ERROR2", "Room dont exsited");
                url = INVALID;
            }
            if (e.getMessage().contains("duplicate")) {
                request.setAttribute("ERROR1", "ID was exsited(Uuplicate)");
                url = INVALID;
            }
        }
        return url;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
