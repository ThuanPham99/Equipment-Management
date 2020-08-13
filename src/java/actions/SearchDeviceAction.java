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
public class SearchDeviceAction {

    private String searchDevice, role;
    private List<DeviceDTO> listDevice;
    private static final String ADMIN = "admin";
    private static final String REPAIRER = "repairer";

    public SearchDeviceAction() {
    }

    public String execute() throws Exception {
        String url = ADMIN;
        if (role != null) {
            if (role.trim().equals("repairer")) {
                url = REPAIRER;
            }
        }

        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            DeviceDAO dao = new DeviceDAO();
            listDevice = dao.getListDevice(searchDevice);
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
