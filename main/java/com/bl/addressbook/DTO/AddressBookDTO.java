package com.bl.addressbook.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {
    @NotBlank(message = "employee name can't be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z]{2,}$",message = "minimum 3 char and first capital char is required")
    private String name;
    @Pattern(regexp = "^[A-Za-z ]{4,}$",message = "minimum 3 char and first capital char is required")
    private String address;
    @Pattern(regexp = "^[A-Za-z ]{2,}$",message = "minimum 3 char and first capital char is required")
    private String city;
    @Pattern(regexp = "^[A-Za-z ]{2,}$",message = "minimum 3 char and first capital char is required")
    private String state;
    private long zip;
    private long phone;
    @Email
    private String email;

    public AddressBookDTO(String name, String address, String city, String state, long zip, long phone, String email) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }
}
