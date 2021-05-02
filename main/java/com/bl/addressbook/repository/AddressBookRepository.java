package com.bl.addressbook.repository;

import com.bl.addressbook.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {
}
