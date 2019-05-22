package com.bjtc.mapper;

import com.bjtc.pojo.Seller;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商家Mapper
 */
@Repository
public interface SellerMapper {

    boolean insertSeller(Seller seller);

    boolean updateSeller(Seller seller);

    boolean deleteSeller(Seller seller);

    boolean deleteSellerByPhone(String phone);

    Seller selectSeller(Seller seller);

    Seller selectSellerByPhone(String phone);

    List<Seller> selectSellersByStatus(Integer status);

    //根据地区模糊查询商家
    List<Seller> selectSellersLikeAddress(String address);

    List<Seller> getAllSellers();
}
