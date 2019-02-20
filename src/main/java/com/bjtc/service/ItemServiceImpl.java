package com.bjtc.service;

import com.bjtc.mapper.CategoryMapper;
import com.bjtc.mapper.ItemMapper;
import com.bjtc.pojo.Category;
import com.bjtc.pojo.Item;
import com.bjtc.pojo.ItemExample;
import com.sun.deploy.panel.ITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Item> selectAllItems() {
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemIdIsNotNull();
        return itemMapper.selectByExample(itemExample);
    }

    @Override
    public List<Item> selectItemsByCategory(Object categoryid) {
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        if(categoryid instanceof Integer){
            criteria.andItemCategoryIdEqualTo((int)categoryid);
            return itemMapper.selectByExample(itemExample);
        }else{
            System.out.println("不合法的类型-----------------");
            return null;
        }
    }

    @Override
    public Item selectItemById(Object itemId) {
        if(itemId instanceof Integer){
            return itemMapper.selectByPrimaryKey((int)itemId);
        }else{
            System.out.println("不合法的类型-----------------");
            return null;
        }
    }

    @Override
    public Category selectItemCategoryByItemId(Object ItemId) {
        if(ItemId instanceof Integer){
            Item item = itemMapper.selectByPrimaryKey((int)ItemId);
            return categoryMapper.selectByPrimaryKey(item.getItemCategoryId());
        }else{
            System.out.println("不合法的类型-----------------");
            return null;
        }
    }

    @Override
    public Category selectItemCategoryByItem(Object item) {
        if(item instanceof Item){
            return categoryMapper.selectByPrimaryKey(((Item)item).getItemCategoryId());
        }else{
            System.out.println("不合法的类型-----------------");
            return null;
        }
    }

    @Override
    public String selectItemUserPhoneByItemId(Object itemId) {
        if(itemId instanceof Integer){
            Item item = itemMapper.selectByPrimaryKey((int)itemId);
            return item.getItemUserPhone();
        }else{
            System.out.println("不合法的类型-----------------");
            return null;
        }
    }

    @Override
    public String selectItemUserPhoneByItem(Object item) {
        if(item instanceof Item){
            return ((Item) item).getItemUserPhone();
        }else{
            System.out.println("不合法的类型-----------------");
            return null;
        }
    }

    @Override
    public List<Item> selectItemsByItemUserId(Integer itemUserId) {
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemUserIdEqualTo(itemUserId);
        return itemMapper.selectByExample(itemExample);
    }

    @Override
    public List<Item> selectItemsByKey(String key) {
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemNameLike(key);
        return itemMapper.selectByExample(itemExample);
    }

    @Override
    public boolean addItem(Item item) {
        try {
            itemMapper.insert(item);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean addItemList(List<Item> items) {
        try {
            for (Item item : items) {
                this.addItem(item);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateItem(Item item) {
        try {
            itemMapper.updateByPrimaryKey(item);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateItems(List<Item> items) {
        try {
            for (Item item : items) {
                this.updateItem(item);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteItemByItemId(Integer itemId) {
        try {
            itemMapper.deleteByPrimaryKey(itemId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteItemsByItemIds(List<Integer> ids) {
        try {
            for (Integer id : ids) {
                this.deleteItemByItemId(id);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
