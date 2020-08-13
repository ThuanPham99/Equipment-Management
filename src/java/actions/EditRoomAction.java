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
public class EditRoomAction {
    private String roomNumber;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private RoomDTO dto;
    public EditRoomAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        try {
            RoomDAO dao = new RoomDAO();
            dto = dao.getRoomByNumber(roomNumber);
            if(dto != null){
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

    public RoomDTO getDto() {
        return dto;
    }

    public void setDto(RoomDTO dto) {
        this.dto = dto;
    }
    
}
