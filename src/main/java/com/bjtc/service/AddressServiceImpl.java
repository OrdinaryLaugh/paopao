package com.bjtc.service;

import com.bjtc.mapper.AddressMapper;
import com.bjtc.pojo.Address;
import com.bjtc.pojo.AddressExample;
import com.bjtc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public List<Address> selectAddressesByUser(User user) {
        return this.selectAddressesByUserId(user.getUserId());
    }

    @Override
    public List<Address> selectAddressesByUserId(Integer userId) {
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return addressMapper.selectByExample(addressExample);
    }

    @Override
    public Address selectAddressByAddressId(Integer AddressId) {
        return addressMapper.selectByPrimaryKey(AddressId);
    }

    @Override
    public boolean addAddress(Address address) {
        try {
            addressMapper.insert(address);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteAddressByAddressId(Integer addressId) {
        try {
            addressMapper.deleteByPrimaryKey(addressId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateAddresss(Address address) {
        try {
            addressMapper.updateByPrimaryKey(address);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
