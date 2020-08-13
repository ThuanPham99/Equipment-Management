/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.NotiDAO;
import daos.UserDAO;
import dtos.UserDTO;
import dtos.UserErrorDTO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class UpdateUserAction {

    private String userID, userName, room, role, image, adminChange;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String INVALID = "invalid";
    private UserErrorDTO userErrorOBj;
    private UserDTO dto;
    public UpdateUserAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        try {
            UserDAO dao = new UserDAO();
            NotiDAO notiDao = new NotiDAO();
            if (dao.updateUser(userID, userName, room, role, image)) {
                url = SUCCESS;
                // thong bao den user
                String msg = "Admin " + adminChange + " changed your information ";
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
                Date date = calendar.getTime();
                String time = formatter.format(date);
                notiDao.wirteMailConfirm(adminChange, userID, msg, time,"Confirm");
            }
        } catch (Exception e) {
            
            userErrorOBj = new UserErrorDTO();
            dto = new UserDTO(userID, userName, role, room, image);
            if (e.getMessage().contains("FK_Users_Room")) {
                userErrorOBj.setRoom("Room dont exist");
            }
            if(e.getMessage().contains("FK_Users_Role")){
                userErrorOBj.setRole("Pls input one in(admin,user,repairer)");
            }
            url = INVALID;
        }
        return url;
    }

    public String getAdminChange() {
        return adminChange;
    }

    public void setAdminChange(String adminChange) {
        this.adminChange = adminChange;
    }

    public UserDTO getDto() {
        return dto;
    }

    public void setDto(UserDTO dto) {
        this.dto = dto;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserErrorDTO getUserErrorOBj() {
        return userErrorOBj;
    }

    public void setUserErrorOBj(UserErrorDTO userErrorOBj) {
        this.userErrorOBj = userErrorOBj;
    }

}
