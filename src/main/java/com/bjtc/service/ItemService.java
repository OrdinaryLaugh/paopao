package com.bjtc.service;

import com.bjtc.pojo.Category;
import com.bjtc.pojo.Item;

import java.util.List;

public interface ItemService {
    /**
     * 获取所有的商品列表
     * @return
     */
    List<Item> selectAllItems();

    /**
     * 根据分类获取某一类的所有商品列表
     * @param categoryid
     * @return
     */
    List<Item> selectItemsByCategory(Object categoryid);

    /**
     * 根据商品的id获取对应的商品信息
     * @param ItemId
     * @return
     */
    Item selectItemById(Object ItemId);

    /**
     * 根据商品分类获取本商品的分类信息
     * @param ItemId
     * @return
     */
    Category selectItemCategoryByItemId(Object ItemId);

    /**
     *获取本商品分类信息
     * @param Item
     * @return
     */
    Category selectItemCategoryByItem(Object Item);

    /**
     * 根据物品id获取物品持有者的手机号（若没有则返回null）
     * @param ItemId
     * @return
     */
    String selectItemUserPhoneByItemId(Object ItemId);

    /**
     * 获取对应物品的持有者的手机号（若没有则返回null）
     * @param Item
     * @return
     */
    String selectItemUserPhoneByItem(Object Item);

    /**
     * 根据ItemUserId获取该人员管理的所有商品
     * @param ItemUserId
     * @return
     */
    String selectItemsByItemUser(Integer ItemUserId);

    /**
     * 根据关键字来搜索所有有关的物品列表
     * @param Key
     * @return
     */
    List<Item> selectItemsByKey(String Key);

    /**
     * 添加一个物品
     * @param item
     * @return
     */
    boolean addItem(Item item);

    /**
     * 添加一批物品
     * @param items
     * @return
     */
    boolean addItemList(List<Item> items);

    /**
     * 修改一个物品信息
     * @param item
     * @return
     */
    boolean updateItem(Item item);

    /**
     * 更改一批物品信息
     * @param items
     * @return
     */
    boolean updateItems(List<Item> items);

    /**
     * 根据id删除物品
     * @param itemId
     * @return
     */
    boolean deleteItemByItemId(Integer itemId);

    /**
     * 根据ids删除一批物品
     * @param Ids
     * @return
     */
    boolean deleteItemsByItemIds(List<Integer> Ids);
}
