/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import daos.RHistoryDAO;
import dtos.RHistoryDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NT
 */
public class RHistoryAction {
    private String ID,role;
    private static final String SUCCESS = "success";
    private List<RHistoryDTO> dtos;
    public RHistoryAction() {
    }
    
    public String execute() throws Exception {
        String url = SUCCESS;
        try {
            RHistoryDAO dao = new RHistoryDAO();
            dtos = dao.loadRHistory(ID);

            if(dtos==null){
                HttpServletRequest request = ServletActionContext.getRequest();
                request.setAttribute("NOTF", "Device has no repair history");
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

    public List<RHistoryDTO> getDtos() {
        return dtos;
    }

    public void setDtos(List<RHistoryDTO> dtos) {
        this.dtos = dtos;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
}
