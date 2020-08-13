/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.LocationDAO;
import dtos.LocationDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class ViewLocationHistoryAction {

    private String deviceID, role;
    private List<LocationDTO> listLocation;
    private static final String SUCCESS = "success";

    public ViewLocationHistoryAction() {
    }

    public String execute() throws Exception {
        String url = SUCCESS;
        try {
            LocationDAO dao = new LocationDAO();
            deviceID = deviceID.trim();
            listLocation = dao.getListByDeviceID(deviceID);
            if(listLocation == null){
                HttpServletRequest reuqest = ServletActionContext.getRequest();
                reuqest.setAttribute("ERROR", "Not Found !!!");
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<LocationDTO> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<LocationDTO> listLocation) {
        this.listLocation = listLocation;
    }
    
}
