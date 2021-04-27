package com.bl.addressbook.model;

import com.bl.addressbook.DTO.AddressBookDTO;

public class AddressBookData {
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private long zip;
    private long phone;
    private String email;

    public AddressBookData(){}

    public AddressBookData(int id, AddressBookDTO addressBookDTO){
        this.id = id;
        this.name = addressBookDTO.getName();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zip = addressBookDTO.getZip();
        this.phone = addressBookDTO.getPhone();
        this.email = addressBookDTO.getEmail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
