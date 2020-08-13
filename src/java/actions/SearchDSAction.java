/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import daos.DeviceDAO;
import dtos.DeviceDTO;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author NT
 */
public class SearchDSAction extends ActionSupport{
    private String toDate,fromDate,numberOfC,listStatus;
    private static final String SUCCESS ="success";
    private  List<DeviceDTO> listDS;
    public SearchDSAction() {
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getNumberOfC() {
        return numberOfC;
    }

    public void setNumberOfC(String numberOfC) {
        this.numberOfC = numberOfC;
    }

    public String getListStatus() {
        return listStatus;
    }

    public void setListStatus(String listStatus) {
        this.listStatus = listStatus;
    }

    public List<DeviceDTO> getListDS() {
        return listDS;
    }

    public void setListDS(List<DeviceDTO> listDS) {
        this.listDS = listDS;
    }
    
    public String execute() throws Exception {
        String url = SUCCESS;    
        DeviceDAO dao = new DeviceDAO();
        if(numberOfC.isEmpty()){
            listDS = dao.getListDSWithoutNumber(toDate, fromDate, listStatus);
        }else{
            int number = Integer.parseInt(numberOfC);
            listDS = dao.getListDS(toDate, fromDate, number, listStatus);
        }       
        if(listDS==null){
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", "Not Found !!! ");
        }
        return url;
    }
    
}
