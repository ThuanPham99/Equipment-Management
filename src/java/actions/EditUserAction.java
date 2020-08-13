/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.UserDAO;
import dtos.UserDTO;

/**
 *
 * @author NT
 */
public class EditUserAction {
    private String userId;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private UserDTO dto;
    public EditUserAction() {
    }
    
    public String execute() throws Exception {
       String url = SUCCESS;
        try {
            UserDAO dao = new UserDAO();
            dto = dao.loadUserById(userId);
            if(dto == null){
                url = ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return url;
    }

    public UserDTO getDto() {
        return dto;
    }

    public void setDto(UserDTO dto) {
        this.dto = dto;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}
