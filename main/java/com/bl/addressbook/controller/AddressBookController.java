package com.bl.addressbook.controller;

import com.bl.addressbook.DTO.AddressBookDTO;
import com.bl.addressbook.DTO.ResponseDTO;
import com.bl.addressbook.model.AddressBookData;
import com.bl.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping("")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookDataList = addressBookService.getContactDetails();
        ResponseDTO responseDTO = new ResponseDTO("get data successfully", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.createContactData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("created successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable("id") int id) {
        ResponseDTO addressBookData = addressBookService.getContactDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("get data by id successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@Valid @RequestBody AddressBookDTO addressBookDTO,
                                                     @PathVariable("id") int id) {
        AddressBookData addressBookData = addressBookService.updateContactData(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("updated successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("id") int id) {
        Boolean status =addressBookService.deleteContactData(id);
        ResponseDTO responseDTO = new ResponseDTO("deleted successfully id ", status);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
