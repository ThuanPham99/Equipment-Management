/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.UserDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NT
 */
public class UserDAO implements Serializable {

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

    public UserDTO checkLogin(String userID, String password) throws Exception {
        UserDTO dto = null;
        try {
            conn = utils.DB.getConnection();
            if (conn != null) {
                String sql = "Select Role,UserName,Room From Users Where UserID = ? and Password = ? and isWork = 1";
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, userID);
                preStm.setString(2, password);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("Role");
                    String userName = rs.getString("UserName");
                    String room = rs.getString("Room");
                    dto = new UserDTO(userID, userName, role.trim());
                    dto.setRoom(room);
                }
            }

        } finally {
            closeConn();
        }
        return dto;
    }

    public List<UserDTO> searchById(String id) throws Exception {
        List<UserDTO> dtos = null;
        try {
            conn = utils.DB.getConnection();
            String sql = "Select UserID, UserName, Room, Role From Users Where UserID like ? and isWork = 1";
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, "%" + id + "%");
                rs = preStm.executeQuery();
                while (rs.next()) {
                    if (dtos == null) {
                        dtos = new ArrayList<>();
                    }
                    String iD = rs.getString("UserID");
                    String userName = rs.getString("UserName");
                    String room = rs.getString("Room");
                    String role = rs.getString("Role");
                    dtos.add(new UserDTO(iD, userName, role, room));

                }
            }

        } finally {
            closeConn();
        }
        return dtos;
    }

    public UserDTO loadUserById(String id) throws Exception {
        UserDTO dto = null;
        try {
            conn = utils.DB.getConnection();
            String sql = "Select UserName, Room, Role, Image From Users Where UserID = ? and isWork = 1";
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, id);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    String userName = rs.getString("UserName");
                    String room = rs.getString("Room");
                    String role = rs.getString("Role");
                    String image = rs.getString("Image");
                    dto = new UserDTO(id, userName, role, room.trim(), image);
                }
            }

        } finally {
            closeConn();
        }
        return dto;
    }

    public boolean deleteUserByID(String id) throws Exception {
        boolean check = false;
        try {
            conn = utils.DB.getConnection();
            String sql = "Update Users set IsWork = 0 Where UserID = ?";
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

    public boolean updateUser(String userID, String userName, String room, String role, String image) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Users set UserName = ?, Room = ?, Role = ?,Image = ? WHERE UserID = ?";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, userName);
                preStm.setString(2, room);
                preStm.setString(3, role);
                preStm.setString(4, image);
                preStm.setString(5, userID);
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }

    public boolean insertUser(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into Users(UserID,UserName,Password,Room,Role,Image,IsWork) values(?,?,?,?,?,?,1)";
            conn = utils.DB.getConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, dto.getUserID());
                preStm.setString(2, dto.getUserName());
                preStm.setString(3, dto.getPassword());
                preStm.setString(4, dto.getRoom());
                preStm.setString(5, dto.getRole());
                preStm.setString(6, dto.getImage());
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConn();
        }
        return check;
    }

    public int checkRoom(String roomNumber) throws Exception {
        int number = 0;
        try {
            String sql = "SELECT COUNT(*) as 'Number' FROM Users WHERE Room = ? and IsWork = 1";
            conn = utils.DB.getConnection();
            if(conn!=null){
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, roomNumber);
                rs = preStm.executeQuery();
                if(rs.next()){
                    number = rs.getInt("Number");
                }
            }
        } finally {
            closeConn();
        }
        return number;
    }
}
