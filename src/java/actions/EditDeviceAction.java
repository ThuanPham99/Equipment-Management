/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.DeviceDAO;
import dtos.DeviceDTO;

/**
 *
 * @author NT
 */
public class EditDeviceAction {
    
    private String ID;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private DeviceDTO dto;

    public EditDeviceAction() {
    }

    public String execute() throws Exception {
        String url = SUCCESS;
        DeviceDAO dao = new DeviceDAO();
        try {
            dto = dao.getDeviceByID(ID);
        } catch (Exception e) {
            url = ERROR;
        }
        
        return url;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public DeviceDTO getDto() {
        return dto;
    }

    public void setDto(DeviceDTO dto) {
        this.dto = dto;
    }

}
