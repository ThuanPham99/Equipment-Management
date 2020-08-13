/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.DeviceDAO;
import dtos.DeviceDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class UserSearchDeviceAction {

    private String searchDevice, room;
    private List<DeviceDTO> listDevice;
    private static final String SUCCESS = "success";

    public UserSearchDeviceAction() {
    }

    public String execute() throws Exception {
        String url = SUCCESS;
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            DeviceDAO dao = new DeviceDAO();
            listDevice = dao.getListDeviceByUser(searchDevice, room.trim());
            if (listDevice == null) {
                request.setAttribute("ERROR", "Not Found !!!");
            } else {
                request.setAttribute("SearchDevice", searchDevice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSearchDevice() {
        return searchDevice;
    }

    public void setSearchDevice(String searchDevice) {
        this.searchDevice = searchDevice;
    }

    public List<DeviceDTO> getListDevice() {
        return listDevice;
    }

    public void setListDevice(List<DeviceDTO> listDevice) {
        this.listDevice = listDevice;
    }

}
