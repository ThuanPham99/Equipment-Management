/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.UserDAO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class DeleteUserAction {

    private String idUser;
    private String searchUser;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    public DeleteUserAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;

        try {
            UserDAO dao = new UserDAO();
            HttpServletRequest request = ServletActionContext.getRequest();
            if (dao.deleteUserByID(idUser.trim())) {
                url = SUCCESS;
//            request.setAttribute("userId",searchUser);
            } else {
                request.setAttribute("ERROR", "Cant Delete " + idUser);
            }
        } catch (Exception e) {
            e.printStackTrace();           
        }
        return url;
    }

    public String getSearchUser() {
        return searchUser;
    }

    public void setSearchUser(String searchUser) {
        this.searchUser = searchUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

}
