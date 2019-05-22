package com.bjtc.service;

import com.bjtc.pojo.Admin;
import com.bjtc.util.DateUtils;

import java.util.List;
import java.util.Map;

public interface AdminService {
    public boolean addAdmin(Admin admin);

    public boolean deleteAdmin(Admin admin);

    public boolean deleteAdminByPhone(String phone);

    public Admin selectAdmin(Admin admin);

    public Admin selectAdminByPhone(String phone);

    public List<Admin> selectAllAdmin();

    public boolean updateAdmin(Admin admin);

    //查询所有商家销售情况，以百分比形式返回
    public List<Map<String,String>> getSellersPercent();
    //根据商家手机号和查询日期查询销量
    public Double selectAmountByPhoneAndTime(String startTime,String endTime,String phone);
    //根据商家手机号和查询日期模糊查询
    public Double selectAllAmountByPhoneLikeTime(String phone ,String time);
    //根据时间查询所有商家总销量
    public Double selectAllAmountByTime(String startTime,String endTime);
    //根据时间模糊查找所有商家总销量
    public Double selectAllAmountLikeTime(String time);
    //根据日期和地区模糊查找销量
    public Double selectCountByAddressLikeTime(String address,String time);
    //根据日期和地区精确查询销量
    public Double selectCountByAddressAndTime(String address,String startTime,String endTime);
    //根据地区和时间模糊查询该地区商家销量百分比
    public List<Map<String,String>> getSellersPercentByAddressAndTime(String address,String time);
    //根据地区、开始时间和结束时间来获取该地区商家之间销量百分比
    public List<Map<String,String>> getSellersPercentByStartTimeAndEndTime(String address,String startTime,String endTime);
    //根据时间获取本年管理员之间销量百分比
    public List<Map<String,String>> getAdminsPercentByTime(String time);
    //根据开始时间和结束时间来获取管理员之间销量百分比
    public List<Map<String,String>> getAdminsPercentByStartTimeAndEndTime(String startTime,String endTime);
    //获取待审批管理员
    public List<Admin> getApprovingAdmins();

    //根据时间和地区精确查询该地区每天所有商家销量
    public List<Double> getSellersCountByAddressAndTime(String address,List<String> listDays);
}
