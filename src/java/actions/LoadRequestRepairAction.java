/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.NotiDAO;
import dtos.NotiDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class LoadRequestRepairAction {
    private String role;
    private static final String ADMIN= "admin";
    private static final String REPAIRER= "repairer";
    private List<NotiDTO> listRequest;
    public LoadRequestRepairAction() {
    }
    
    public String execute() throws Exception {
        String url = REPAIRER;
        try {
            if(role.trim().equals("admin")){
                url = ADMIN;
            }
            NotiDAO dao = new NotiDAO();
            listRequest = dao.getListRequest("Request");
            if(listRequest==null){
                HttpServletRequest request = ServletActionContext.getRequest();
                request.setAttribute("ERROR", "Dont have any mail request in this time");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<NotiDTO> getListRequest() {
        return listRequest;
    }

    public void setListRequest(List<NotiDTO> listRequest) {
        this.listRequest = listRequest;
    }
    
}
