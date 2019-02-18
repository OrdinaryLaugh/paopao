package com.bjtc.service;

import com.bjtc.pojo.Address;
import com.bjtc.pojo.User;

import java.util.List;

public interface AddressService {
    List<Address> selectAddressesByUser(User user);
    List<Address> selectAddressesByUserId(Integer userId);
    Address selectAddressByAddressId(Integer AddressId);
    boolean addAddress(Address address);
    boolean deleteAddressByAddressId(Integer addressId);
    boolean updateAddresss(Address address);
}
