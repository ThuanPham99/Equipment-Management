/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.RoomDAO;
import dtos.RoomDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class SearchRoomAction {
    private String searchRoom;
    private List<RoomDTO> listRoom;
    private static final String SUCCESS = "success";
    public SearchRoomAction() {
    }

    public String getSearchRoom() {
        return searchRoom;
    }

    public void setSearchRoom(String searchRoom) {
        this.searchRoom = searchRoom;
    }

    public List<RoomDTO> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<RoomDTO> listRoom) {
        this.listRoom = listRoom;
    }
    
    public String execute() throws Exception {
        String url = SUCCESS;
        try {
            RoomDAO dao = new RoomDAO();
            HttpServletRequest request = ServletActionContext.getRequest();
            listRoom = dao.searchRoom(searchRoom);
            if(listRoom==null){                
                request.setAttribute("ERROR", "NOT FOUND !!!");
            }else{
                request.setAttribute("SearchRoom", searchRoom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
    
}
