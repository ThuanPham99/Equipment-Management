/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.NotiDTO;
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
public class NotiDAO {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;
    private DateFormat df = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");

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

    public boolean insertRequest(NotiDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Notification(Sender,NotiTime,DeviceID,Type) values(?,?,?,?)";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, dto.getSender());
                preStm.setString(2, dto.getTime());
                preStm.setString(3, dto.getDeviceID());
                preStm.setString(4, dto.getType());
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }

    public List<NotiDTO> getListSendUser(String sender) throws Exception {
        List<NotiDTO> dtos = null;
        try {
            String sql = "SELECT DeviceID, NotiTime, Type FROM Notification WHERE Sender = ? ORDER BY NotiTime DESC";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, sender);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    if (dtos == null) {
                        dtos = new ArrayList<>();
                    }
                    String deciveID = rs.getString("DeviceID");
                    String Type = rs.getString("Type");
                    String Time = df.format(rs.getTimestamp("NotiTime"));
                    NotiDTO dto = new NotiDTO(Time, deciveID);
                    dto.setType(Type);
                    dtos.add(dto);
                }
            }
        } finally {
            closeConn();
        }
        return dtos;
    }

    public List<NotiDTO> getListInboxUser(String receiverID, String type) throws Exception {
        List<NotiDTO> dtos = null;
        try {
            String sql = "SELECT Sender, MailContext, NotiTime FROM Notification WHERE Receiver = ? and Type = ? ORDER BY NotiTime DESC";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, receiverID);
                preStm.setString(2, type);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    if (dtos == null) {
                        dtos = new ArrayList<>();
                    }
                    String sender = rs.getString("Sender");
                    String context = rs.getString("MailContext");
                    String Time = df.format(rs.getTimestamp("NotiTime"));
                    dtos.add(new NotiDTO(sender, Time, context));
                }
            }
        } finally {
            closeConn();
        }
        return dtos;
    }

    public List<NotiDTO> getListRequest(String type) throws Exception {
        List<NotiDTO> dtos = null;
        try {
            String sql = "SELECT Sender, DeviceID, NotiTime FROM Notification WHERE Type = ? ORDER BY NotiTime DESC";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, type);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    if (dtos == null) {
                        dtos = new ArrayList<>();
                    }
                    String sender = rs.getString("Sender");
                    String deviceID = rs.getString("DeviceID");
                    String time = df.format(rs.getTimestamp("NotiTime"));
                    dtos.add(new NotiDTO(sender, time, deviceID, type));
                }
            }
        } finally {
            closeConn();
        }
        return dtos;
    }

    public boolean processingRequest(String receiver, String confirmType, String deviceID) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Notification Set Receiver = ?, Type = ? Where DeviceID = ? and Type = ?";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, receiver);
                preStm.setString(2, "Processing");
                preStm.setString(3, deviceID);
                preStm.setString(4, confirmType);
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }
    public boolean setTypeByPrimaryKey(String sender, String notiTime, String type) throws Exception{
        boolean check = false;
        try {
            String sql = "Update Notification Set Type = ? Where Sender = ? and NotiTime = ?";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, type);
                preStm.setString(2, sender);
                preStm.setString(3, notiTime);
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }

    public boolean wirteMailConfirm(String sender, String receiver, String mailContext, String time, String type) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Notification(Sender,NotiTime,Receiver,Type,MailContext) values(?,?,?,?,?)";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, sender);
                preStm.setString(2, time);
                preStm.setString(3, receiver);
                preStm.setString(4, type);
                preStm.setString(5, mailContext);
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }

    public List<NotiDTO> getListNotiRepaier(String id) throws Exception {
        List<NotiDTO> dtos = null;
        try {
            String sql = "Select Sender,NotiTime, Type, DeviceID,MailContext From Notification Where Receiver = ? ORDER BY NotiTime DESC";
            conn = utils.DB.getConnection();
            if(conn!=null){
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, id);
                rs = preStm.executeQuery();
                while(rs.next()){
                    if(dtos == null){
                        dtos = new ArrayList<>();
                    }
                    String sender = rs.getString("Sender");
                    String time = df.format(rs.getTimestamp("NotiTime"));
                    String type = rs.getString("Type");
                    String deviceID = rs.getString("DeviceID");
                    String context = rs.getString("MailContext");
                    dtos.add(new NotiDTO(sender, time, deviceID, type, context));
                }
            }
            
        } finally {
            closeConn();
        }
        return dtos;
    }
}
