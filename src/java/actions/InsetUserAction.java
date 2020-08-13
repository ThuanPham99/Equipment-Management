/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.UserDAO;
import dtos.UserDTO;
import dtos.UserErrorDTO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class InsetUserAction {

    private String userID, userName, role, room, password, confirm, image;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String INVALID = "invalid";
    private UserErrorDTO userErrorOBj;
    private UserDTO dto;

    public InsetUserAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        userErrorOBj = new UserErrorDTO();
        try {
            UserDAO dao = new UserDAO();
            UserDTO dto = new UserDTO(userID, userName, password, role, room, image);
            boolean invalid = true;
            if (!password.equals(confirm)) {
                url = INVALID;
                invalid = false;
                userErrorOBj.setPassword("Confirm is wrong");
            }
            if (invalid) {
                if (dao.insertUser(dto)) {
                    url = SUCCESS;
                } else {
                    HttpServletRequest request = ServletActionContext.getRequest();
                    request.setAttribute("ERROR", "Insert False");
                }
            }

        } catch (Exception e) {           
            dto = new UserDTO(userID, userName, role, room, image);
            if (e.getMessage().contains("duplicate")) {
                userErrorOBj.setUserID("UserID was exsited");
            }
            if (e.getMessage().contains("FK_Users_Room")) {
                userErrorOBj.setRoom("Room dont exist");
            }
            if (e.getMessage().contains("FK_Users_Role")) {
                userErrorOBj.setRole("Pls input one in(admin,user,repairer)");
            }
            url = INVALID;
        }
        return url;
    }

    public UserDTO getDto() {
        return dto;
    }

    public void setDto(UserDTO dto) {
        this.dto = dto;
    }

    public UserErrorDTO getUserErrorOBj() {
        return userErrorOBj;
    }

    public void setUserErrorOBj(UserErrorDTO userErrorOBj) {
        this.userErrorOBj = userErrorOBj;
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

    public String getRole() {
        return role;
    }

    public void setRole(String Role) {
        this.role = Role;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String Room) {
        this.room = Room;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
