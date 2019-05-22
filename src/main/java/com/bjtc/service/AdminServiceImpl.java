package com.bjtc.service;

import com.bjtc.mapper.AdminMapper;
import com.bjtc.mapper.OrderMapper;
import com.bjtc.mapper.SellerMapper;
import com.bjtc.pojo.Address;
import com.bjtc.pojo.Admin;
import com.bjtc.pojo.Seller;
import com.bjtc.util.CheckInputUtils;
import com.bjtc.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private SellerMapper sellerMapper;

    @Override
    @Transactional
    public boolean addAdmin(Admin admin) {
        if(admin!=null&&!StringUtils.isEmpty(admin.getAdminPassword())&&!StringUtils.isEmpty(admin.getAdminPhone())){
            Admin adminExist = adminMapper.selectAdmin(admin);
            if(adminExist!=null){
                return false;
            }
            boolean result = adminMapper.addAdmin(admin);
            return result;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteAdmin(Admin admin) {
        if(admin!=null&&!StringUtils.isEmpty(admin.getAdminPassword())&&!StringUtils.isEmpty(admin.getAdminPhone())){
            boolean result = adminMapper.deleteAdmin(admin);
            return result;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteAdminByPhone(String phone) {
        boolean result = CheckInputUtils.checkPhone(phone);
        if(!result){
            return false;
        }
        result = adminMapper.deleteAdminByPhone(phone);
        return result;
    }

    @Override
    public Admin selectAdmin(Admin admin) {
        if(admin!=null&&!StringUtils.isEmpty(admin.getAdminPassword())&&!StringUtils.isEmpty(admin.getAdminPhone())){
            Admin result = adminMapper.selectAdmin(admin);
            return result;
        }
        return null;
    }

    @Override
    public Admin selectAdminByPhone(String phone) {
        boolean result = CheckInputUtils.checkPhone(phone);
        if(!result){
            return null;
        }
        Admin admin = adminMapper.selectAdminByPhone(phone);
        return admin;
    }

    @Override
    public List<Admin> selectAllAdmin() {
        return adminMapper.selectAllAdmin();
    }

    @Override
    @Transactional
    public boolean updateAdmin(Admin admin) {
        if(admin!=null&&!StringUtils.isEmpty(admin.getAdminPassword())&&!StringUtils.isEmpty(admin.getAdminPhone())){
            boolean result = adminMapper.updateAdmin(admin);
            return result;
        }
        return false;
    }

    /**
     * 根据时间来模糊查询管理员之间的销量百分比
     * @param time
     * @return
     */
    @Override
    public List<Map<String,String>> getAdminsPercentByTime(String time){
        List<Admin> admins = adminMapper.selectAllAdmin();
        List<Map<String,String>> percentList = new ArrayList<>();
        for(Admin admin:admins) {
            Map<String,String> percentMap = new HashMap<>();
            Double count = orderMapper.selectAmountByAddressLikeTime(admin.getAdminAddress()+"%", time);
            percentMap.put("name",admin.getAdminName());
            percentMap.put("value",count+"");
            percentList.add(percentMap);
        }
        return percentList;
    }

    /**
     * 根据开始时间和结束时间来查询管理员之间的销量百分比
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<Map<String,String>> getAdminsPercentByStartTimeAndEndTime(String startTime,String endTime){
        Double allCount = selectAllAmountByTime(startTime, endTime);
        List<Admin> admins = adminMapper.selectAllAdmin();
        List<Map<String,String>> percentList = new ArrayList<>();
        for(Admin admin:admins){
            Map<String,String> percentMap = new HashMap<>();
            Double count = orderMapper.selectAmountByAddressAndTime(admin.getAdminAddress() + "%", startTime, endTime);
            percentMap.put("name",admin.getAdminName());
            percentMap.put("value",count.toString());
            percentList.add(percentMap);
        }
        return percentList;
    }
    @Override
    public List<Map<String, String>> getSellersPercent() {
        //所有商家
        List<Seller> sellers = sellerMapper.getAllSellers();
        //所有商家的总销售额
        Double totalSales = orderMapper.getTotalSales();
        List<Map<String,String>> percentList = new ArrayList<>();

        for(Seller seller:sellers){
            Map<String,String> percentMap = new HashMap<>();
            Double totalSalesByPhone = orderMapper.getTotalSalesByPhone(seller.getSellerPhone());
            //key是商家名称，value是商家销售额与总销售额之比
            percentMap.put("name",seller.getSellerName());
            percentMap.put("value",totalSalesByPhone+"");
        }
        return percentList;
    }

    @Override
    public Double selectAmountByPhoneAndTime(String startTime, String endTime, String phone) {
        Double count = orderMapper.selectAmountByPhoneAndTime(startTime, endTime, phone);
        return count;
    }

    @Override
    public Double selectAllAmountByPhoneLikeTime(String phone, String time) {
        Double count = orderMapper.selectAllAmountByPhoneLikeTime(phone, time);
        return count;
    }

    @Override
    public Double selectAllAmountByTime(String startTime, String endTime) {
        Double count = orderMapper.selectAllAmountByTime(startTime,endTime);
        return count;
    }
    @Override
    public Double selectAllAmountLikeTime(String time){
        Double count = orderMapper.selectAllAmountLikeTime(time);
        return count;
    }

    @Override
    public Double selectCountByAddressLikeTime(String address, String time) {
        Double count = orderMapper.selectAmountByAddressLikeTime(address, time);
        return count;
    }

    @Override
    public Double selectCountByAddressAndTime(String address, String startTime,String endTime) {
        Double count = orderMapper.selectAmountByAddressAndTime(address, startTime, endTime);
        return count;
    }

    /**
     * 根据地区和时间模糊查询该地区所有商家的销量百分比
     * @param address
     * @param time
     * @return
     */
    @Override
    public List<Map<String, String>> getSellersPercentByAddressAndTime(String address, String time) {
        List<Seller> sellers = sellerMapper.selectSellersLikeAddress(address);
        Double allCount = orderMapper.selectAmountByAddressLikeTime(address,time);
        List<Map<String, String>> percentList = new ArrayList<>();
        for(Seller seller:sellers){
            Map<String,String> percentMap = new HashMap<>();
            Double count = orderMapper.selectAllAmountByPhoneLikeTime(seller.getSellerPhone(), time);
            percentMap.put("name",seller.getSellerName());
            percentMap.put("value",count+"");
            percentList.add(percentMap);
        }
        return percentList;
    }

    /**
     * 根据地区和时间查询该地区该时间所有商家销量百分比
     * @param address
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<Map<String, String>> getSellersPercentByStartTimeAndEndTime(String address, String startTime, String endTime) {
        List<Seller> sellers = sellerMapper.selectSellersLikeAddress(address);
        Double allCount = orderMapper.selectAmountByAddressAndTime(address, startTime, endTime);
        List<Map<String,String>> percentList = new ArrayList<>();
        for(Seller seller:sellers){
            Map<String,String> percentMap = new HashMap<>();
            Double count = orderMapper.selectAmountByPhoneAndTime(startTime,endTime,seller.getSellerPhone());
            percentMap.put("name",seller.getSellerName());
            percentMap.put("value",count+"");
            percentList.add(percentMap);
        }
        return percentList;
    }

    @Override
    public List<Admin> getApprovingAdmins() {
        List<Admin> admins = adminMapper.selectAllAdmin();
        return admins;
    }

    @Override
    public List<Double> getSellersCountByAddressAndTime(String address, List<String> listDays) {
        List<Double> countList=new ArrayList<>();
        //用来模糊查找
        address += "%";
        for(String day:listDays){
            String startTime=day+" 00:00:00";
            String endTime=day+" 23:59:59";
            countList.add(selectCountByAddressAndTime(address,startTime,endTime));
        }
        return countList;
    }


}
