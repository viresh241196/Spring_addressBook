package com.bl.addressbook.service;

import com.bl.addressbook.DTO.AddressBookDTO;
import com.bl.addressbook.model.AddressBookData;

import java.util.List;


public interface IAddressBookService {
    List<AddressBookData> getContactDetails();

    AddressBookData getContactDataById(int empId);

    AddressBookData createContactData(AddressBookDTO addressBookDTO);

    AddressBookData updateContactData(int empId, AddressBookDTO addressBookDTO);

    Boolean deleteContactData(int empId);
}
