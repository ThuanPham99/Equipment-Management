/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.RHistoryDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NT
 */
public class RHistoryDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;
    private DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    
    public void closeConn() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    public List<RHistoryDTO> loadRHistory(String id) throws Exception{
        List<RHistoryDTO> dtos = null;
        try {
            String sql = "Select TimeRequest,Description,Sender,Repairer,TimeDone,Result From RDeviceHistory Where DeviceID = ?";
            conn = utils.DB.getConnection();
            if(conn!=null){
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, id);
                rs = preStm.executeQuery();
                while(rs.next()){
                    if(dtos == null){
                        dtos = new ArrayList<>();
                    }
                    String timeRequest = df.format(rs.getDate("TimeRequest"));
                    String description = rs.getString("Description");
                    String sender = rs.getString("Sender");
                    String repairer = rs.getString("Repairer");
                    String timeDone = rs.getString("TimeDone");
                    boolean result = rs.getBoolean("Result");
                    dtos.add(new RHistoryDTO(id, timeRequest, description, sender, repairer, timeDone, result));
                }
            }
        } finally{
            closeConn();
        }
        return dtos;
    }
    public boolean insertRepairHistory(RHistoryDTO dto) throws Exception{
        boolean check = true;
        try {
            String sql = "Insert Into RDeviceHistory(DeviceID,TimeRequest,Description,Sender,Repairer,TimeDone,Result) values(?,?,?,?,?,?,?)";
            conn = utils.DB.getConnection();
            if(conn!=null){
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, dto.getDeviceID());
                preStm.setString(2, dto.getTimeRequest());
                preStm.setString(3, dto.getDescription());
                preStm.setString(4, dto.getSender());
                preStm.setString(5, dto.getRepairer());
                preStm.setString(6, dto.getTimeDone());
                preStm.setBoolean(7, dto.isResult());
                check = preStm.executeUpdate() > 0;
            }
        } finally{
            closeConn();
        }
        return check;
    }
}
