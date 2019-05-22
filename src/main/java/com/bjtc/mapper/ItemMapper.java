package com.bjtc.mapper;

import com.bjtc.pojo.Item;

public interface ItemMapper {

    int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    Item selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKey(Item record);
}