/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.DeviceDAO;
import daos.RoomDAO;
import daos.UserDAO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class DeleteRoomAction {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private String roomNumber;
    private String searchRoom;

    public DeleteRoomAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;

        try {
            boolean check = true;
            HttpServletRequest request = ServletActionContext.getRequest();
            UserDAO userDao = new UserDAO();
            DeviceDAO deviceDao = new DeviceDAO();
            int roomDevice = deviceDao.checkRoom(roomNumber.trim());
            int roomUser = userDao.checkRoom(roomNumber.trim());
            if (roomUser > 0) {
                check = false;

            }
            if (roomDevice > 0) {
                check = false;
            }
            if (check) {
                RoomDAO dao = new RoomDAO();
                if(dao.deleteRoom(roomNumber.trim())){
                    url = SUCCESS;
                }else{
                    request.setAttribute("ERROR","Can't delete this room");
                }
                
            } else {      
                request.setAttribute("ERROR", "Cant Delete " + roomNumber + " Because Room have " + roomUser + " Users and " + roomDevice + " Devices");
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

    public String getSearchRoom() {
        return searchRoom;
    }

    public void setSearchRoom(String searchRoom) {
        this.searchRoom = searchRoom;
    }

}
