package com.bl.addressbook.controller;

import com.bl.addressbook.DTO.AddressBookDTO;
import com.bl.addressbook.DTO.ResponseDTO;
import com.bl.addressbook.model.AddressBookData;
import com.bl.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping("")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList=addressBookService.getContactDetails();
//        AddressBookData addressBookData = new AddressBookData(1, new AddressBookDTO("viresh", "parel", "mumbai",
//                "maharashtra", 400012, 1234567, "abc@abc.com"));
        ResponseDTO responseDTO = new ResponseDTO("get data successfully", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContact(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.createContactData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("created successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable("id") int id) {
        AddressBookData addressBookData = addressBookService.getContactDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("get data by id successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@RequestBody AddressBookDTO addressBookDTO,
                                                     @PathVariable("id") int id) {
        AddressBookData addressBookData = addressBookService.updateContactData(id,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("updated successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("id") int id){
        addressBookService.deleteContactData(id);
        ResponseDTO responseDTO = new ResponseDTO("deleted successfully id ", id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
