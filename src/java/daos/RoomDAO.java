/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.RoomDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NT
 */
public class RoomDAO {

    private Connection conn = null;
    private PreparedStatement preStm = null;
    private ResultSet rs = null;

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

    public List<RoomDTO> searchRoom(String numberRoom) throws Exception {
        List<RoomDTO> dtos = null;
        try {
            String sql = "Select NumberRoom, NameRoom From Rooms where NumberRoom like ? and IsDelete = 0";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, "%" + numberRoom + "%");
                rs = preStm.executeQuery();
                while (rs.next()) {
                    if (dtos == null) {
                        dtos = new ArrayList<>();
                    }
                    String number = rs.getString("NumberRoom");
                    String name = rs.getString("NameRoom");
                    dtos.add(new RoomDTO(number, name));
                }
            }
        } finally {
            closeConn();
        }
        return dtos;
    }

    public boolean deleteRoom(String numberRoom) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Rooms set IsDelete = 1 Where NumberRoom = ?";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, numberRoom);
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }

    public RoomDTO getRoomByNumber(String number) throws Exception {
        RoomDTO dto = null;
        try {
            String sql = "SELECT NameRoom FROM Rooms Where NumberRoom = ?";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, number);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("NameRoom");
                    dto = new RoomDTO(number, name);
                }
            }
        } finally {
            closeConn();
        }
        return dto;
    }

    public boolean updateRoom(RoomDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Rooms SET NameRoom = ? WHERE NumberRoom = ?";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, dto.getRoomName());
                preStm.setString(2, dto.getRoomNumber());
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }
    public boolean insertRoom(RoomDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "Insert Into Rooms(NumberRoom,NameRoom,IsDelete) values(?,?,0)";
            conn = utils.DB.getConnection();
            if(conn!=null){
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, dto.getRoomNumber());
                preStm.setString(2, dto.getRoomName());
                check  = preStm.executeUpdate() > 0;
            }
        } finally{
            closeConn();
        }
        return check;
    }
}
