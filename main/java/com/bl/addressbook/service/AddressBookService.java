package com.bl.addressbook.service;

import com.bl.addressbook.DTO.AddressBookDTO;
import com.bl.addressbook.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{
    List<AddressBookData> addressBookDataList = new ArrayList<>();

    @Override
    public List<AddressBookData> getContactDetails() {
        return addressBookDataList;
    }

    @Override
    public AddressBookData getContactDataById(int empId) {
        return addressBookDataList.get(empId-1);
    }

    @Override
    public AddressBookData createContactData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDataList.size()+1,addressBookDTO);
        addressBookDataList.add(addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData updateContactData(int empId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getContactDataById(empId);
        addressBookData.setName(addressBookDTO.getName());
        addressBookData.setAddress(addressBookDTO.getAddress());
        addressBookData.setCity(addressBookDTO.getCity());
        addressBookData.setState(addressBookDTO.getState());
        addressBookData.setZip(addressBookDTO.getZip());
        addressBookData.setEmail(addressBookDTO.getEmail());
        return addressBookData;
    }

    @Override
    public void deleteContactData(int empId) {
        addressBookDataList.remove(empId-1);
    }
}
