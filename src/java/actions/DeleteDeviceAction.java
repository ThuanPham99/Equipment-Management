/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.DeviceDAO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class DeleteDeviceAction {

    private String ID;
    private String searchDevice;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    public DeleteDeviceAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        try {
            DeviceDAO dao = new DeviceDAO();
            if (dao.deleteDevice(ID.trim())) {
                url = SUCCESS;
            }else{
                HttpServletRequest request = ServletActionContext.getRequest();
                request.setAttribute("ERROR", "Can't Delete" + ID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSearchDevice() {
        return searchDevice;
    }

    public void setSearchDevice(String searchDevice) {
        this.searchDevice = searchDevice;
    }

}
