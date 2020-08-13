/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author NT
 */
public class UserDTO implements Serializable {

    private String userID, userName, password, role, room, image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    private boolean isWork;

    public UserDTO(String userID, String userName, String password, String role, String room, String image) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.room = room;
        this.image = image;
    }


    public UserDTO(String userID, String userName, String role, String room) {
        this.userID = userID;
        this.userName = userName;
        this.role = role;
        this.room = room;
    }

    public UserDTO(String userID, String userName, String role) {
        this.userID = userID;
        this.userName = userName;
        this.role = role;
    }

    public UserDTO(String userID, String userName, String role, String room, String image) {
        this.userID = userID;
        this.userName = userName;
        this.role = role;
        this.room = room;
        this.image = image;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public UserDTO() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isIsWork() {
        return isWork;
    }

    public void setIsWork(boolean isWork) {
        this.isWork = isWork;
    }

}
