/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.DeviceDTO;
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
public class DeviceDAO implements Serializable {

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

    public List<DeviceDTO> getListDS(String toDate, String fromDate, int numberOfC, String listStatus) throws Exception {
        List<DeviceDTO> dtos = null;
        String sql = "Select ID, Name,NumberRepairs, DateOfBuy, Status, Guarantee FROM Devices Where NumberRepairs = ? and IsDelete = ? and Status like ? and Guarantee BETWEEN ? and ? ";;
        try {
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setInt(1, numberOfC);
                preStm.setString(2, "False");
                preStm.setString(3, "%" + listStatus + "%");
                preStm.setString(4, toDate);
                preStm.setString(5, fromDate);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    if (dtos == null) {
                        dtos = new ArrayList<>();
                    }
                    String ID = rs.getString("ID");
                    String name = rs.getString("Name");
                    int numberRepairs = rs.getInt("NumberRepairs");
                    String dateOfBuy = df.format(rs.getDate("DateOfBuy"));
                    String status = rs.getString("Status");
                    String guarantee = df.format(rs.getDate("Guarantee"));
                    DeviceDTO dto = new DeviceDTO(ID, name, dateOfBuy, numberRepairs, status);
                    dto.setGuaranteePeriod(guarantee);
                    dtos.add(dto);
                }
            }

        } finally {
            closeConn();
        }
        return dtos;
    }

    public List<DeviceDTO> getListDSWithoutNumber(String toDate, String fromDate, String listStatus) throws Exception {
        List<DeviceDTO> dtos = null;
        String sql = "Select ID, Name,NumberRepairs, DateOfBuy, Status, Guarantee FROM Devices Where IsDelete = ? and Status like ? and Guarantee BETWEEN ? and ? ";;
        try {
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, "False");
                preStm.setString(2, "%" + listStatus + "%");
                preStm.setString(3, toDate);
                preStm.setString(4, fromDate);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    if (dtos == null) {
                        dtos = new ArrayList<>();
                    }
                    String ID = rs.getString("ID");
                    String name = rs.getString("Name");
                    int numberRepairs = rs.getInt("NumberRepairs");
                    String dateOfBuy = df.format(rs.getDate("DateOfBuy"));
                    String status = rs.getString("Status");
                    String guarantee = df.format(rs.getDate("Guarantee"));
                    DeviceDTO dto = new DeviceDTO(ID, name, dateOfBuy, numberRepairs, status);
                    dto.setGuaranteePeriod(guarantee);
                    dtos.add(dto);
                }
            }

        } finally {
            closeConn();
        }
        return dtos;
    }

    public int checkRoom(String roomNumber) throws Exception {
        int number = 0;
        try {
            String sql = "SELECT COUNT(ID) as 'Number' FROM Devices WHERE Room =? and IsDelete = 0";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, roomNumber);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    number = rs.getInt("Number");
                }
            }
        } finally {
            closeConn();
        }
        return number;
    }
    public List<DeviceDTO> getListDeviceByUser(String id,String room) throws Exception{
        List<DeviceDTO> dtos = null;
        String sql = "Select ID, Name, Description, Type, Image, DateOfBuy,  Guarantee, NumberRepairs, Status FROM Devices Where IsDelete = ? and ID like ? and Room = ?";
        try {
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, "False");
                preStm.setString(2, "%" + id + "%");
                preStm.setString(3, room);
                rs = preStm.executeQuery();
                while (rs.next()) {
                    if (dtos == null) {
                        dtos = new ArrayList<>();
                    }
                    String iD = rs.getString("ID");
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    String type = rs.getString("Type");
                    String image = rs.getString("Image");
                    String dateofBuy = df.format(rs.getDate("DateOfBuy"));
                    String guarantee = df.format(rs.getDate("Guarantee"));
                    int numberOfRepairs = rs.getInt("NumberRepairs");
                    String status = rs.getString("Status");
                    dtos.add(new DeviceDTO(iD, name, description, type, room, image, dateofBuy, guarantee, numberOfRepairs, status));
                }
            }
        } finally {
            closeConn();
        }
        return dtos;
    }

    public List<DeviceDTO> getListDevice(String id) throws Exception {
        List<DeviceDTO> dtos = null;
        String sql = "Select ID, Name, Description, Type, Room, Image, DateOfBuy,  Guarantee, NumberRepairs, Status FROM Devices Where IsDelete = ? and ID like ?";
        try {
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, "False");
                preStm.setString(2, "%" + id + "%");
                rs = preStm.executeQuery();
                while (rs.next()) {
                    if (dtos == null) {
                        dtos = new ArrayList<>();
                    }
                    String iD = rs.getString("ID");
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    String type = rs.getString("Type");
                    String room = rs.getString("Room");
                    String image = rs.getString("Image");
                    String dateofBuy = df.format(rs.getDate("DateOfBuy"));
                    String guarantee = df.format(rs.getDate("Guarantee"));
                    int numberOfRepairs = rs.getInt("NumberRepairs");
                    String status = rs.getString("Status");
                    dtos.add(new DeviceDTO(iD, name, description, type, room, image, dateofBuy, guarantee, numberOfRepairs, status));
                }
            }
        } finally {
            closeConn();
        }
        return dtos;
    }

    public DeviceDTO getDeviceByID(String id) throws Exception {
        DeviceDTO dto = null;
        String sql = "Select  Name, Description, Type, Room, Image, DateOfBuy,  Guarantee, NumberRepairs, Status FROM Devices Where  ID = ?";
        try {
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, id);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    String type = rs.getString("Type");
                    String room = rs.getString("Room");
                    String image = rs.getString("Image");
                    String dateofBuy = df.format(rs.getDate("DateOfBuy"));
                    String guarantee = df.format(rs.getDate("Guarantee"));
                    int numberOfRepairs = rs.getInt("NumberRepairs");
                    String status = rs.getString("Status");
                    dto = new DeviceDTO(id, name, description, type, room, image, dateofBuy, guarantee, numberOfRepairs, status);
                }
            }
        } finally {
            closeConn();
        }
        return dto;
    }

    public boolean deleteDevice(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Devices Set IsDelete = 1 Where ID = ?";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, id);
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }

    public boolean updateDevice(DeviceDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Devices Set Name = ?, Description = ?, Type = ?, Room = ?, Image = ?, DateOfBuy = ?, Guarantee = ?, NumberRepairs = ?, Status = ? Where ID = ?";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, dto.getName());
                preStm.setString(2, dto.getDescription());
                preStm.setString(3, dto.getType());
                preStm.setString(4, dto.getRoom());
                preStm.setString(5, dto.getImage());
                preStm.setString(6, dto.getDateOfBuy());
                preStm.setString(7, dto.getGuaranteePeriod());
                preStm.setInt(8, dto.getNumberOfRepairs());
                preStm.setString(9, dto.getStatus());
                preStm.setString(10, dto.getID());
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }
    public boolean updateRoomDevice(String id, String room) throws Exception{
        boolean check = false;
        try {
            String sql = "Update Devices Set  Room = ? Where ID = ?";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, room);
                preStm.setString(2, id);
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }
    public boolean insertDevice(DeviceDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "Insert INTO Devices(ID,Name,Description,Type,Room,Image,DateOfBuy,Guarantee,NumberRepairs,IsDelete,Status) values(?,?,?,?,?,?,?,?,?,0,?)";
            conn = utils.DB.getConnection();
            if(conn!=null){
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, dto.getID());
                preStm.setString(2, dto.getName());
                preStm.setString(3, dto.getDescription());
                preStm.setString(4, dto.getType());
                preStm.setString(5, dto.getRoom());
                preStm.setString(6, dto.getImage());
                preStm.setString(7, dto.getDateOfBuy());
                preStm.setString(8, dto.getGuaranteePeriod());
                preStm.setInt(9, dto.getNumberOfRepairs());
                preStm.setString(10, dto.getStatus());
                check = preStm.executeUpdate() > 0;
            }
        } finally{
            closeConn();
        }
        return check;
    }
    
    public boolean setStatus(String id, String status) throws Exception{
        boolean check = false;
        try {
            String sql = "Update Devices set Status = ? Where ID = ?";
            conn = utils.DB.getConnection();
            if(conn!=null){
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, status);
                preStm.setString(2, id);
                check = preStm.executeUpdate() > 0;
            }
        }finally{
            closeConn();
        }
        return check;
    }
    public boolean increaseNumberRepairByKey(String id) throws Exception{
        boolean check = false;
        try {
            String sql = "Update Devices set NumberRepairs = NumberRepairs + 1 where ID = ?";
             conn = utils.DB.getConnection();
            if(conn!=null){
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, id);
                check = preStm.executeUpdate() > 0;
            }
        }finally{
            closeConn();
        }
        return check;
    }
}
