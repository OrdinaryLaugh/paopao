package com.bjtc.test;

import com.bjtc.mapper.AddressMapper;
import com.bjtc.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Test {
    @Autowired
    private AddressMapper addressMapper;
    public void selectSimplemailByReceiveUserId(String receiveUserId) {
        AddressExample example = new AddressExample();
        AddressExample.Criteria criteria = example.createCriteria();
        List<Address> addresses = addressMapper.selectByExample(example);
        System.out.println(addresses);

    }
}
