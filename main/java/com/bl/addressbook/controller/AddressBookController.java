package com.bl.addressbook.controller;

import com.bl.addressbook.DTO.AddressBookDTO;
import com.bl.addressbook.DTO.ResponseDTO;
import com.bl.addressbook.model.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("addressbook")
public class AddressBookController {

    @GetMapping("")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        AddressBookData addressBookData = new AddressBookData(1, new AddressBookDTO("viresh", "parel", "mumbai",
                "maharashtra", 400012, 1234567, "abc@abc.com"));
        ResponseDTO responseDTO = new ResponseDTO("get data successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContact(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(1, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("created successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable("id") int id) {
        AddressBookData addressBookData = new AddressBookData(id, new AddressBookDTO("viresh", "parel", "mumbai",
                "maharashtra", 400012, 1234567, "abc@abc.com"));
        ResponseDTO responseDTO = new ResponseDTO("get data by id successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@RequestBody AddressBookDTO addressBookDTO,
                                                     @PathVariable("id") int id) {
        AddressBookData addressBookData = new AddressBookData(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("updated successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("id") int id){
        ResponseDTO responseDTO = new ResponseDTO("deleted successfully id ", id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
