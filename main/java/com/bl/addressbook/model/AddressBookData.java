package com.bl.addressbook.model;

import com.bl.addressbook.DTO.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="AddressBook")
@Data
public class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public AddressBookData( AddressBookDTO addressBookDTO){
        this.name = addressBookDTO.getName();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zip = addressBookDTO.getZip();
        this.phone = addressBookDTO.getPhone();
        this.email = addressBookDTO.getEmail();
    }

}
