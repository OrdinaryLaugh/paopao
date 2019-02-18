package com.bjtc.service;

import com.bjtc.pojo.Address;
import com.bjtc.pojo.User;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Override
    public List<Address> selectAddressesByUser(User user) {
        return null;
    }

    @Override
    public List<Address> selectAddressesByUserId(Integer userId) {
        return null;
    }

    @Override
    public Address selectAddressByAddressId(Integer AddressId) {
        return null;
    }

    @Override
    public boolean addAddress(Address address) {
        return false;
    }

    @Override
    public boolean deleteAddressByAddressId(Integer addressId) {
        return false;
    }

    @Override
    public boolean updateAddresss(Address address) {
        return false;
    }
}
