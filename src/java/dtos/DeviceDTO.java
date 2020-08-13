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
public class DeviceDTO implements Serializable{
    private String ID, name, description, type, room, image, dateOfBuy, guaranteePeriod;
    private int numberOfRepairs;
    private String status;
    public DeviceDTO() {
    }

    public DeviceDTO(String ID, String name, String room, String dateOfBuy, int numberOfRepairs, String status) {
        this.ID = ID;
        this.name = name;
        this.room = room;
        this.dateOfBuy = dateOfBuy;
        this.numberOfRepairs = numberOfRepairs;
        this.status = status;
    }

    public DeviceDTO(String ID, String name, String description, String type, String room, String image, String dateOfBuy, String GuaranteePeriod, int numberOfRepairs, String status) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.type = type;
        this.room = room;
        this.image = image;
        this.dateOfBuy = dateOfBuy;
        this.guaranteePeriod = GuaranteePeriod;
        this.numberOfRepairs = numberOfRepairs;
        this.status = status;
    }

    public DeviceDTO(String ID, String name, String dateOfBuy, int numberOfRepairs, String status) {
        this.ID = ID;
        this.name = name;
        this.dateOfBuy = dateOfBuy;
        this.numberOfRepairs = numberOfRepairs;
        this.status = status;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateOfBuy() {
        return dateOfBuy;
    }

    public void setDateOfBuy(String dateOfBuy) {
        this.dateOfBuy = dateOfBuy;
    }

    public String getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(String GuaranteePeriod) {
        this.guaranteePeriod = GuaranteePeriod;
    }

    public int getNumberOfRepairs() {
        return numberOfRepairs;
    }

    public void setNumberOfRepairs(int numberOfRepairs) {
        this.numberOfRepairs = numberOfRepairs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    
}
