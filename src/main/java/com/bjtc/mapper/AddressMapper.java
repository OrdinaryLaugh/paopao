package com.bjtc.mapper;

import com.bjtc.pojo.Address;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface AddressMapper {

    Address selectByPrimaryKey(Integer addressId);

    int deleteByAddressId(Integer addressId);

    int insert(Address record);

    int updateByPrimaryKey(Address record);
}