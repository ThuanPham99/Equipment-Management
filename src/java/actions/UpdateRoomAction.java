/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.RoomDAO;
import dtos.RoomDTO;

/**
 *
 * @author NT
 */
public class UpdateRoomAction {

    private String roomNumber, roomName;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    public UpdateRoomAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;

        try {
            RoomDAO dao = new RoomDAO();
            RoomDTO dto = new RoomDTO(roomNumber, roomName);
            if (dao.updateRoom(dto)) {
                url = SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
