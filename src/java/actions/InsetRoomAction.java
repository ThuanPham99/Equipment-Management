/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.RoomDAO;
import dtos.RoomDTO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class InsetRoomAction {

    private String roomNumber, roomName;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String INVALID = "invalid";

    public InsetRoomAction() {
    }

    public String execute() throws Exception {
        String url = INVALID;
        try {
            RoomDAO dao = new RoomDAO();
            RoomDTO dto = new RoomDTO(roomNumber, roomName);
            if (dao.insertRoom(dto)) {
                url = SUCCESS;
            }
        } catch (Exception e) {
            if (e.getMessage().contains("duplicate")) {
                HttpServletRequest request = ServletActionContext.getRequest();
                request.setAttribute("ERROR", "Room number is existed");
            }
        }
        return url;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}
