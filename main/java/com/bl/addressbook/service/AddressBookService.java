package com.bl.addressbook.service;

import com.bl.addressbook.DTO.AddressBookDTO;
import com.bl.addressbook.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    @Override
    public List<AddressBookData> getContactDetails() {
        List<AddressBookData> addressBookData = new ArrayList<>();
        addressBookData.add(new AddressBookData(1, new AddressBookDTO("viresh", "parel", "mumbai",
                "maharashtra", 400012, 1234567, "abc@abc.com")));
        return addressBookData;
    }

    @Override
    public AddressBookData getContactDataById(int empId) {
    AddressBookData addressBookData = new AddressBookData(1, new AddressBookDTO("viresh", "parel", "mumbai",
            "maharashtra", 400012, 1234567, "abc@abc.com"));
        return addressBookData;
    }

    @Override
    public AddressBookData createContactData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(1,addressBookDTO);
        return addressBookData;
    }

    @Override
    public AddressBookData updateContactData(int empId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(empId,addressBookDTO);
        return addressBookData;
    }

    @Override
    public void deleteContactData(int empId) {

    }
}
