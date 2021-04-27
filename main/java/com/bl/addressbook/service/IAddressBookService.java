package com.bl.addressbook.service;

import com.bl.addressbook.DTO.AddressBookDTO;
import com.bl.addressbook.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAddressBookService {
    List<AddressBookData> getContactDetails();

    AddressBookData getContactDataById(int empId);

    AddressBookData createContactData(AddressBookDTO addressBookDTO);

    AddressBookData updateContactData(int empId, AddressBookDTO addressBookDTO);

    void deleteContactData(int empId);
}
