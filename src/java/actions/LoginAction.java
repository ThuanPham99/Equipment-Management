/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import daos.UserDAO;
import dtos.UserDTO;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class LoginAction {

    private String userID;
    private String password;
    private static final String ERROR = "error";
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String REPAIRER = "repairer";

    public LoginAction() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() throws Exception {
        String url = ERROR;
        try {
            UserDAO dao = new UserDAO();
            UserDTO dto = dao.checkLogin(userID, password);
            if (dto != null) {
                Map session = ActionContext.getContext().getSession();
                session.put("User", dto);
                if (dto.getRole().equals("admin")) {
                    url = ADMIN;
                } else if (dto.getRole().equals("repairer")) {
                    url = REPAIRER;
                } else if (dto.getRole().equals("user")) {
                    url = USER;
                }
            }else{
                    HttpServletRequest request = ServletActionContext.getRequest();
                    request.setAttribute("ERROR", "Your pass is wrong");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

}
