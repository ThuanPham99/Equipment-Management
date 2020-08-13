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
public class LoadUserSendAction {
    private String sendID;
    private static final String SUCCESS = "success";
    private List<NotiDTO> listNoti;
    public LoadUserSendAction() {
    }
    
    public String execute() throws Exception {
        String url = SUCCESS;
        try {
            NotiDAO dao = new NotiDAO();
            listNoti = dao.getListSendUser(sendID);
            if(listNoti==null){
                HttpServletRequest request = ServletActionContext.getRequest();
                request.setAttribute("ERROR", "You dont have mail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String getSendID() {
        return sendID;
    }

    public void setSendID(String sendID) {
        this.sendID = sendID;
    }

    public List<NotiDTO> getListNoti() {
        return listNoti;
    }

    public void setListNoti(List<NotiDTO> listNoti) {
        this.listNoti = listNoti;
    }
    
}
