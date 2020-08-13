/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;

/**
 *
 * @author NT
 */
public class LogoutAction {
    private static final String SUCCESS = "success";
    public LogoutAction() {
    }
    
    public String execute() throws Exception {
        String url = SUCCESS;
         try {
            Map session = ActionContext.getContext().getSession();
            SessionMap sessionMap = (SessionMap)session;
            if (sessionMap != null)
                sessionMap.invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
    
}
