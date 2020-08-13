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
public class LoadMyRepairAction {
    private String myID;
    private List<NotiDTO> listWork;
    private static final String SUCCESS = "success";
    public LoadMyRepairAction() {
    }
    
    public String execute() throws Exception {
        String url = SUCCESS;
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            NotiDAO dao = new NotiDAO();
            listWork = dao.getListNotiRepaier(myID);
            if(listWork==null){
                request.setAttribute("ERROR", "You dont have mail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public List<NotiDTO> getListWork() {
        return listWork;
    }

    public void setListWork(List<NotiDTO> listWork) {
        this.listWork = listWork;
    }



    public String getMyID() {
        return myID;
    }

    public void setMyID(String myID) {
        this.myID = myID;
    }
    
}
