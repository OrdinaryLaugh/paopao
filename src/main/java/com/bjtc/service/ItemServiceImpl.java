package com.bjtc.service;

import com.bjtc.pojo.Category;
import com.bjtc.pojo.Item;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Override
    public List<Item> selectAllItems() {
        return null;
    }

    @Override
    public List<Item> selectItemsByCategory(Object categoryid) {
        return null;
    }

    @Override
    public Item selectItemById(Object ItemId) {
        return null;
    }

    @Override
    public Category selectItemCategoryByItemId(Object ItemId) {
        return null;
    }

    @Override
    public Category selectItemCategoryByItem(Object Item) {
        return null;
    }

    @Override
    public String selectItemUserPhoneByItemId(Object ItemId) {
        return null;
    }

    @Override
    public String selectItemUserPhoneByItem(Object Item) {
        return null;
    }

    @Override
    public String selectItemsByItemUser(Integer ItemUserId) {
        return null;
    }

    @Override
    public List<Item> selectItemsByKey(String Key) {
        return null;
    }

    @Override
    public boolean addItem(Item item) {
        return false;
    }

    @Override
    public boolean addItemList(List<Item> items) {
        return false;
    }

    @Override
    public boolean updateItem(Item item) {
        return false;
    }

    @Override
    public boolean updateItems(List<Item> items) {
        return false;
    }

    @Override
    public boolean deleteItemByItemId(Integer itemId) {
        return false;
    }

    @Override
    public boolean deleteItemsByItemIds(List<Integer> Ids) {
        return false;
    }
}
