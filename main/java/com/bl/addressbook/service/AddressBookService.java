package com.bl.addressbook.service;

import com.bl.addressbook.DTO.AddressBookDTO;
import com.bl.addressbook.DTO.ResponseDTO;
import com.bl.addressbook.exception.AddressBookException;
import com.bl.addressbook.model.AddressBookData;
import com.bl.addressbook.repository.AddressBookRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class AddressBookService implements IAddressBookService {
    List<AddressBookData> addressBookDataList = new ArrayList<>();

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBookData> getContactDetails() {
        List<AddressBookData> addressBookData = addressBookRepository.findAll();
        return addressBookData;
    }

    @Override
    public ResponseDTO getContactDataById(int Id) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Optional<AddressBookData> bookData = addressBookRepository.findById(Id);
            if (bookData.isPresent()) {
                responseDTO.setData(bookData.get());
                responseDTO.setMessage("fetch successfully");
            } else {
                throw new AddressBookException("Contact not found");
            }
        } catch (Exception e) {
            throw new AddressBookException("Something went wrong");
        }
        return responseDTO;
    }

    @Override
    public AddressBookData createContactData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookRepository.save(new AddressBookData(addressBookDTO));
        return addressBookData;
    }

    @Override
    public AddressBookData updateContactData(int Id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookRepository.save(new AddressBookData(Id, addressBookDTO));
        return addressBookData;
    }

    @Override
    public Boolean deleteContactData(int Id) {
        try {
            Optional<AddressBookData> bookData = addressBookRepository.findById(Id);
            AddressBookData addressBookData = bookData.get();
            addressBookRepository.delete(addressBookData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
