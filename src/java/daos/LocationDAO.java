/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.LocationDTO;
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
public class LocationDAO implements  Serializable{

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

    public boolean insertNewLocation(LocationDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO LocationHistory(DevicesID,Room,Time,UserIDChange,Reason) values(?,?,?,?,?)";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, dto.getDevicesID());
                preStm.setString(2, dto.getRoom());
                preStm.setString(3, dto.getTime());
                preStm.setString(4, dto.getUserIDChange());
                preStm.setString(5, dto.getReason());
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }
    public List<LocationDTO> getListByDeviceID(String deviceID)throws Exception{
        List<LocationDTO> dtos = null;
        try {
            String sql = "Select  Room, Time, UserIDChange, Reason From LocationHistory Where DevicesID = ?";
            conn = utils.DB.getConnection();
            if(conn!=null){
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, deviceID);
                rs = preStm.executeQuery();
                while(rs.next()){
                    if(dtos==null){
                        dtos = new ArrayList<>();
                    }
                    String room = rs.getString("Room");
                    String time = df.format(rs.getDate("Time"));
                    String userID = rs.getString("UserIDChange");
                    String reason = rs.getString("Reason");
                    dtos.add(new LocationDTO(deviceID, room, time, userID, reason));
                }
            }
        } catch (Exception e) {
        }
        return dtos;
    }
}
