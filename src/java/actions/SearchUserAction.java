/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.UserDAO;
import dtos.UserDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class SearchUserAction {

    private String searchUser;
    private List<UserDTO> listUser;
    private static final String SUCCESS = "success";
//    private UserDTO dto;
    public SearchUserAction() {
    }

    public String getSearchUser() {
        return searchUser;
    }

    public void setSearchUser(String searchUser) {
        this.searchUser = searchUser;
    }



    public List<UserDTO> getListUser() {
        return listUser;
    }

    public void setListUser(List<UserDTO> listUser) {
        this.listUser = listUser;
    }

//    public UserDTO getDto() {
//        return dto;
//    }
//
//    public void setDto(UserDTO dto) {
//        this.dto = dto;
//    }


    public String execute() throws Exception {
        String url = SUCCESS;
        try {
            UserDAO dao = new UserDAO();
             listUser =dao.searchById(searchUser);
             HttpServletRequest request = ServletActionContext.getRequest();
            if (listUser == null) {           
                request.setAttribute("ERROR", "Not Found !!! ");
            }else{
                request.setAttribute("SearchUser", searchUser);
            }
        } catch (Exception e) {
        }
        return url;
    }

}
