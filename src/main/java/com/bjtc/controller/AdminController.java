package com.bjtc.controller;

import com.bjtc.mapper.SellerMapper;
import com.bjtc.pojo.*;
import com.bjtc.service.AdminService;
import com.bjtc.service.OrderService;
import com.bjtc.service.UserService;
import com.bjtc.util.CheckInputUtils;
import com.bjtc.util.DateUtils;
import com.bjtc.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private AdminService adminService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    /**
     * 普通管理员注册
     * @param phoneNumber
     * @param password
     * @return

    @RequestMapping(value="/adminRegistry")
    public Map<String,Object> adminRegistry (String phoneNumber,String password){
        Admin admin=new Admin();
        admin.setAdminPhone(phoneNumber);
        admin.setAdminCreateDate(new Date());
        admin.setAdminPassword(password);
        //待审批管理员
        admin.setAdminRole(0);
        Admin adminExist = adminService.selectAdminByPhone(phoneNumber);
        Map<String,Object> map = new HashMap<>();
        if(adminExist!=null){
            map.put("result","failed");
            return map;
        }
        //若注册成功,result=true
        boolean result = adminService.addAdmin(admin);
        if(result){
            map.put("admin",admin);
        }
        return map;
    } */

    /**
     * 商家注册，此时商家状态为待审批：0
     * @param seller
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value="/sellerRegistry")
    public Map<String,String> sellerRegistry (@RequestBody  Seller seller){
        seller.setSellerCreateDate(new Date());
        //待审批商家
        seller.setSellerStatus(0);
        Seller sellerExist = sellerMapper.selectSellerByPhone(seller.getSellerPhone());
        Map<String,String> map = new HashMap<>();
        if(sellerExist!=null){
            map.put("result","failed");
            return map;
        }
        //若注册成功,返回seller
        //先对密码使用MD5加密再插入信息
        String sellerPassword = seller.getSellerPassword();
        sellerPassword = MD5Utils.string2MD5(sellerPassword);
        seller.setSellerPassword(sellerPassword);
        boolean result = sellerMapper.insertSeller(seller);
        if(result){
            map.put("result","true");
        }
        return map;
    }

    /**
     * 获取待审批管理员
     * @return

    @ResponseBody
    @RequestMapping(value = "/getApprovingAdmins")
    public Map<String,List<Admin>> getApprovingAdmins(){
        List<Admin> approvingAdmins = adminService.getApprovingAdmins();
        Map<String,List<Admin>> map = new HashMap<>();
        map.put("approvingAdmins",approvingAdmins);
        return map;
    }*/

    /**
     * 获取待审批商家
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/getApprovingSellers")
    public Map<String,List<Seller>> getApprovingSellers() {
        List<Seller> approvingSellers = sellerMapper.selectSellersByStatus(0);
        Map<String, List<Seller>> map = new HashMap<>();
        map.put("approvingSellers", approvingSellers);
        return map;
    }
    /**
     * 审批商家，Seller只有电话号则表示拒绝,否则表示通过
     * @param
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/admin/approveSeller")
    public Map<String,String> approveSeller(@RequestBody Map<String,String> request){
        Map<String,String> map = new HashMap<>();
        String way = request.get("way");
        String phoneNumber = request.get("phoneNumber");

        //way==refuse 则表示拒绝
        if(way.equals("refuse")){
            sellerMapper.deleteSellerByPhone(phoneNumber);
        }else {
            Seller seller = sellerMapper.selectSellerByPhone(phoneNumber);
            seller.setSellerStatus(1);
            sellerMapper.updateSeller(seller);
        }
        map.put("result","success");
        return map;
    }

    /**
     * 管理员（或商家）登录
     * @return
     */
    @RequestMapping(value="/adminLogin")
    @ResponseBody
    public  Map<String,String> userLogin (HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String,String> data){
        Map<String,String> responseMap = new HashMap<>();
        String phoneNumber = null;
        String password = null;
        if(data!=null) {
            phoneNumber = data.get("phoneNumber");
            password = data.get("password");
        }else {
            phoneNumber = request.getParameter("phoneNumber");
            password = request.getParameter("password");
        }
        Admin admin = adminService.selectAdminByPhone(phoneNumber);
        Seller seller = sellerMapper.selectSellerByPhone(phoneNumber);
        if(admin==null&&seller==null) {
            responseMap.put("message","No this admin");
            return responseMap;
        }
        //将密码使用MD5加密
        password = MD5Utils.string2MD5(password);
        //匹配管理员密码
        if(admin!=null&&admin.getAdminPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("adminPhone",admin.getAdminPhone());
            session.setAttribute("adminPassword",admin.getAdminPassword());
            //设置session过期时间：7天
            session.setMaxInactiveInterval(7*60*60*24*1000);
            //设置自动登录，时长为7天
            Cookie cookieUserPhone=new Cookie("adminPhone",admin.getAdminPhone());
            cookieUserPhone.setMaxAge(7*60*60*24);
            cookieUserPhone.setPath("/");
            Cookie cookie=new Cookie("JSESSIONID",session.getId());
            cookie.setPath("/");
            cookie.setMaxAge(7*60*60*24);
            response.addCookie(cookie);
            response.addCookie(cookieUserPhone);
            //返回管理员权限
            switch (admin.getAdminRole()){
                case 1:responseMap.put("role","SuperAdmin");break;
                case 0:responseMap.put("role","CommonAdmin");break;
            }
            responseMap.put("adminId",admin.getAdminId().toString());
        }
        //如果管理员密码不匹配则尝试匹配商家
        else if(seller!=null&&seller.getSellerPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("sellerPhone",seller.getSellerPhone());
            session.setAttribute("sellerPassword",seller.getSellerPassword());
            //设置session过期时间：7天
            session.setMaxInactiveInterval(7*60*60*24*1000);
            //设置自动登录，时长为7天
            Cookie cookieUserPhone=new Cookie("sellerPhone",seller.getSellerPhone());
            cookieUserPhone.setMaxAge(7*60*60*24);
            cookieUserPhone.setPath("/");
            Cookie cookie=new Cookie("JSESSIONID",session.getId());
            cookie.setPath("/");
            cookie.setMaxAge(7*60*60*24);
            response.addCookie(cookie);
            response.addCookie(cookieUserPhone);
            //返回商家权限
            responseMap.put("role","Seller");
            responseMap.put("sellerId",seller.getSellerId().toString());
        }
        return responseMap;
    }

    /**
     * 返回所有商家
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/getAllSellers")
    public Map<String,List<Seller>> getAllSellers(){
        List<Seller> allSellers = sellerMapper.getAllSellers();
        Map<String,List<Seller>> map = new HashMap<>();
        map.put("sellers",allSellers);
        return map;
    }
    /**
     * 获取所有的用户（对象）信息
     * 应该先判断是否登录
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/admin/getAllUsers")
    public  Map<String,List<User>> getAllUsers (){
        Map<String,List<User>> map = new HashMap<>();
        List<User> users = userService.selectAllUser();
        map.put("users",users);
        return map;
    }
    /**
     * 更新商家信息
     * @param seller
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/updateSeller")
    public Map<String,String> updateSeller(@RequestBody Seller seller){
        Map<String,String> map = new HashMap<>();
        if(seller!=null) {
            Seller oldSeller = sellerMapper.selectSellerByPhone(seller.getSellerPhone());
            //更新商家其他信息
            //将密码先使用MD5加密再更新
            String sellerPassword = seller.getSellerPassword();
            sellerPassword = MD5Utils.string2MD5(sellerPassword);
            oldSeller.setSellerPassword(sellerPassword);
            oldSeller.setSellerShopName(seller.getSellerShopName());
            oldSeller.setSellerName(seller.getSellerName());
            oldSeller.setSellerPhone(seller.getSellerPhone());
            oldSeller.setSellerAddress(seller.getSellerAddress());
            //真正更新商家信息
            sellerMapper.updateSeller(oldSeller);
            map.put("result","success");
            return map;
        }
        map.put("result","false");
        return map;
    }
    /**
     * 更新管理员信息
     * @param admin
     */
    @Transactional
    @RequestMapping(value = "/admin/updateAdmin")
    public void updateAdmin(@RequestBody  Admin admin){
        adminService.updateAdmin(admin);
    }

    /**
     * 获取所有管理员
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/superAdmin/getAllAdmins")
    public Map<String,List<Admin>> getAllAdmins(){
        List<Admin> admins = adminService.selectAllAdmin();
        Map<String,List<Admin>> map = new HashMap<>();
        map.put("admins",admins);
        return map;
    }
    /**
     * 根据管理员手机号删除管理员
     * @param data
     * @param response
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/superAdmin/deleteAdminByPhone")
    public Map<String,String> deleteAdminByPhone(@RequestBody Map<String,String> data,HttpServletResponse response){
        String adminPhone = data.get("adminPhone");
        Map<String,String> map = new HashMap<>();
        if(!checkAdminPhone(adminPhone)){
            map.put("result","false");
            return map;
        }
        Admin admin = adminService.selectAdminByPhone(adminPhone);
        boolean deleteAdmin = adminService.deleteAdmin(admin);
        if(!deleteAdmin){
            map.put("result","false");
            return map;
        }
        map.put("result","success");
        return map;
    }

    /**
     * 根据商家手机号删除商家
     * @param sellerPhone
     * @param response
     * @return
     */
    @Transactional
    @RequestMapping(value = "/admin/deleteSellerByPhone")
    public void deleteSellerByPhone(@RequestBody String sellerPhone,HttpServletResponse response){
        if(!checkSellerPhone(sellerPhone)){
            return ;
        }
        Seller seller = sellerMapper.selectSellerByPhone(sellerPhone);
        if(seller==null){
            return ;
        }
        boolean deleteSellerByPhone = sellerMapper.deleteSellerByPhone(sellerPhone);
        if(!deleteSellerByPhone){
            return ;
        }
    }

    /**
     * 该地区所有商家本月每天销量
     * @param response
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/admin/incomeByMonth")
    @ResponseBody
    public List<Double> incomeAddressByMonth(HttpServletRequest request,HttpServletResponse response) throws ParseException {
        HttpSession session = request.getSession();
        Object adminPhone = session.getAttribute("adminPhone");
        if(adminPhone==null){
            return null;
        }
        Admin admin = adminService.selectAdminByPhone(adminPhone.toString());
        List<String> monthDaysString = DateUtils.getMonthDays(new Date());
        List<Double> countList=adminService.getSellersCountByAddressAndTime(admin.getAdminAddress()+"%",monthDaysString);
        return countList;
    }
    /**
     * 该地区所有商家本周每天的销量
     * @param response
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/admin/incomeByWeek")
    @ResponseBody
    public List<Double> incomeAddressByWeek(HttpServletRequest request,HttpServletResponse response) throws ParseException {
        HttpSession session = request.getSession();
        Object adminPhone = session.getAttribute("adminPhone");
        if(adminPhone==null){
            return null;
        }
        Admin admin = adminService.selectAdminByPhone(adminPhone.toString());
        List<String> weekDays = DateUtils.getWeekDays(new Date());
        List<Double> countList=adminService.getSellersCountByAddressAndTime(admin.getAdminAddress()+"%",weekDays);
        return countList;
    }
    /**
     * 查询该地区所有商家本年每月的销量
     * @param response
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/admin/incomeByYear")
    @ResponseBody
    public List<Double> incomeAddressByYear(HttpServletRequest request,HttpServletResponse response) throws ParseException {
        HttpSession session = request.getSession();
        Object adminPhone = session.getAttribute("adminPhone");
        if(adminPhone==null){
            return null;
        }
        Admin admin = adminService.selectAdminByPhone(adminPhone.toString());
        String year = DateUtils.getYearFirstDay(new Date());
        List<Double> countList = new ArrayList<>();
        String address = admin.getAdminAddress();
        address += "%";
        for(int i=1;i<=9;i++){
            String time = year+"-0"+i+"%";
            countList.add(adminService.selectCountByAddressLikeTime(address,time));
        }
        for(int i=10;i<=12;i++){
            String time = year+"-"+i+"%";
            countList.add(adminService.selectCountByAddressLikeTime(address,time));
        }
        return countList;
    }

    /**
     * 查询该商家本月每天的销量
     * @param response
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/incomeByMonth")
    @ResponseBody
    public List<Double> incomeByMonth(HttpServletRequest request,HttpServletResponse response) throws ParseException {
        HttpSession session = request.getSession();
        Object sellerPhone = session.getAttribute("sellerPhone");
        if(sellerPhone==null){
            return null;
        }
        List<String> monthDaysString = DateUtils.getMonthDays(new Date());
        List<Double> countList=new ArrayList<>();
        for(String day:monthDaysString){
            String startTime=day+" 00:00:00";
            String endTime=day+" 23:59:59";
            countList.add(adminService.selectAmountByPhoneAndTime(startTime,endTime,sellerPhone.toString()));
        }
        return countList;
    }
    /**
     * 查询该商家本周每天的销量
     * @param response
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/incomeByWeek")
    @ResponseBody
    public List<Double> incomeByWeek(HttpServletRequest request,HttpServletResponse response) throws ParseException {
        HttpSession session = request.getSession();
        Object sellerPhone = session.getAttribute("sellerPhone");
        if(sellerPhone==null){
            return null;
        }
        List<String> weekDaysString = DateUtils.getWeekDays(new Date());
        List<Double> countList=new ArrayList<>();
        for(String day:weekDaysString){
            String startTime=day+" 00:00:00";
            String endTime=day+" 23:59:59";
            countList.add(adminService.selectAmountByPhoneAndTime(startTime,endTime,sellerPhone.toString()));
        }
        return countList;
    }
    /**
     * 查询该商家本年每月的销量
     * @param response
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/incomeByYear")
    @ResponseBody
    public List<Double> incomeByYear(HttpServletRequest request,HttpServletResponse response) throws ParseException {
        HttpSession session = request.getSession();
        Object sellerPhone = session.getAttribute("sellerPhone");
        if(sellerPhone==null){
            return null;
        }
        String year = DateUtils.getCurrentYear();
        List<Double> countList = new ArrayList<>();
        for(int i=1;i<=9;i++){
            String time = year+"-0"+i+"%";
            countList.add(adminService.selectAllAmountByPhoneLikeTime(sellerPhone.toString(),time));
        }
        for(int i=10;i<=12;i++){
            String time = year+"-"+i+"%";
            countList.add(adminService.selectAllAmountByPhoneLikeTime(sellerPhone.toString(),time));
        }
        return countList;
    }

    /**
     * 查询本月每天所有商家的总销量
     * @param response
     * @return
     */
    @RequestMapping(value = "/superAdmin/incomeAllByMonth")
    @ResponseBody
    public List<Double> incomeAllByMonth(HttpServletResponse response){
        List<String> monthDaysString = DateUtils.getMonthDays(new Date());
        List<Double> countList = new ArrayList<>();
        for(String day:monthDaysString){
            String startTime=day+" 00:00:00";
            String endTime=day+" 23:59:59";
            countList.add(adminService.selectAllAmountByTime(startTime,endTime));
        }
        return countList;
    }
    /**
     * 查询本周每天所有商家的总销量
     * @param response
     * @return
     */
    @RequestMapping(value = "/superAdmin/incomeAllByWeek")
    @ResponseBody
    public List<Double> incomeAllByWeek(HttpServletResponse response){
        List<String> weekDaysString = DateUtils.getWeekDays(new Date());
        List<Double> countList = new ArrayList<>();
        for(String day:weekDaysString){
            String startTime=day+" 00:00:00";
            String endTime=day+" 23:59:59";
            countList.add(adminService.selectAllAmountByTime(startTime,endTime));
        }
        return countList;
    }
    /**
     * 查询本年每月所有商家的总销量
     * @param response
     * @return
     */
    @RequestMapping(value = "/superAdmin/incomeAllByYear")
    @ResponseBody
    public List<Double> incomeAllByYear(HttpServletResponse response){
        String year = DateUtils.getCurrentYear();
        List<Double> countList = new ArrayList<>();
        for(int i=1;i<=9;i++){
            String time = year+"-0"+i+"%";
            countList.add(adminService.selectAllAmountLikeTime(time));
        }
        for(int i=10;i<=12;i++){
            String time = year+"-"+i+"%";
            countList.add(adminService.selectAllAmountLikeTime(time));
        }
        return countList;
    }
    /**
     * 查询所有管理员今年销量比
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/superAdmin/getAdminsPercentByYear")
    public List<Map<String,String >> selectYearPercentByAddmins(){
        String currentYear = DateUtils.getCurrentYear();
        //加个 % 来进行模糊查询
        currentYear+="%";
        List<Map<String, String>> adminsPercentByTime = adminService.getAdminsPercentByTime(currentYear);
        return  adminsPercentByTime;
    }
    /**
     * 查询所有管理员本月销量比
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/superAdmin/getAdminsPercentByMonth")
    public List<Map<String,String>> selectMonthPercentByAddmins(){
        String currentMonth = DateUtils.getCurrentMonth();
        //加个 % 来进行模糊查询
        currentMonth+="%";
        List<Map<String, String>> adminsPercentByTime = adminService.getAdminsPercentByTime(currentMonth);
        return adminsPercentByTime;
    }

    /**
     * 查询所有管理员本周销量比
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/superAdmin/getAdminsPercentByWeek")
    public List<Map<String,String>> selectWeekPercentByAdmins(){
        Date date = new Date();
        String weekFirstDay = DateUtils.getWeekFirstDay(date);
        String weekLastDay = DateUtils.getWeekLastDay(date);
        List<Map<String, String>> adminsPercentByStartTimeAndEndTime = adminService.getAdminsPercentByStartTimeAndEndTime(weekFirstDay, weekLastDay);
        return adminsPercentByStartTimeAndEndTime;
    }

    /**
     * 查询该地区所有商家本年销量百分比
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/getSellersPercentByYear")
    public List<Map<String,String>> getYearPercentBySellers(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object adminPhone = session.getAttribute("adminPhone");
        if(adminPhone==null){
            return null;
        }
        Admin admin = adminService.selectAdminByPhone(adminPhone.toString());
        String currentYear = DateUtils.getCurrentYear();
        List<Map<String, String>> sellersPercentByAddressAndTime = adminService.getSellersPercentByAddressAndTime(admin.getAdminAddress() + "%", currentYear + "%");
        return sellersPercentByAddressAndTime;
    }
    /**
     * 查询该地区所有商家本月销量百分比
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/getSellersPercentByMonth")
    public List<Map<String,String>> getMonthPercentBySellers(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object adminPhone = session.getAttribute("adminPhone");
        if(adminPhone==null){
            return null;
        }
        Admin admin = adminService.selectAdminByPhone(adminPhone.toString());
        String currentMonth = DateUtils.getCurrentMonth();
        List<Map<String, String>> sellersPercentByAddressAndTime = adminService.getSellersPercentByAddressAndTime(admin.getAdminAddress() + "%", currentMonth + "%");
        return sellersPercentByAddressAndTime;
    }

    /**
     * 查询该地区所有商家本周销量百分比
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/getSellersPercentByWeek")
    public List<Map<String, String>> getWeekPercentBySellers(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object adminPhone = session.getAttribute("adminPhone");
        if(adminPhone==null){
            return null;
        }
        Admin admin = adminService.selectAdminByPhone(adminPhone.toString());
        Date date = new Date();
        String weekFirstDay = DateUtils.getWeekFirstDay(date);
        String weekLastDay = DateUtils.getWeekLastDay(date);
        List<Map<String,String>> sellersPercentByStartTimeAndEndTime = adminService.getSellersPercentByStartTimeAndEndTime(admin.getAdminAddress() + "%", weekFirstDay, weekLastDay);
        return sellersPercentByStartTimeAndEndTime;
    }
    /**
     * 获取所有商家总销售额百分比，key：商家名称，value：该商家销售额占总销售额百分比
     * @return
     */
    @RequestMapping(value = "/admin/getSellersPercent")
    @ResponseBody
    public List<Map<String,String>> getSellersPercent(){
        return adminService.getSellersPercent();
    }
    /**
     * 检查传入的管理员手机号是否正确
     * @param adminPhone
     * @return
     */
    @RequestMapping(value = "/checkAdminPhone")
    public boolean checkAdminPhone(String adminPhone){
        boolean checkPhone = CheckInputUtils.checkPhone(adminPhone);
        if(!checkPhone)
        {
            return false;
        }
        Admin admin = adminService.selectAdminByPhone(adminPhone);
        if(admin==null){
            return false;
        }
        return true;
    }

    /**
     * 检查传入的商家手机号是否正确
     * @param sellerPhone
     * @return
     */
    @RequestMapping(value = "/checkSellerPhone")
    public boolean checkSellerPhone(String sellerPhone){
        boolean checkPhone = CheckInputUtils.checkPhone(sellerPhone);
        if(!checkPhone)
        {
            return false;
        }
        Seller seller = sellerMapper.selectSellerByPhone(sellerPhone);
        if(seller==null){
            return false;
        }
        return true;
    }
    /**
     * 获取被投诉的订单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/getComplainOrders")
    public Map<String,List<Order>> getComplainOrders(@RequestBody Map<String,String> data){
        Object startPage = data.get("startPage");
        if(startPage==null){
            return null;
        }
        List<Order> complainOrders = orderService.getComplainOrdersByPage(Integer.valueOf(startPage.toString()));
        Map<String,List<Order>> map = new HashMap<>();
        map.put("orders",complainOrders);
        return map;
    }

    /**
     * 获取本周商家的菜品销量百分比
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getShopPercentByWeek")
    public List<Map<String,String>> getShopPercentByWeek(){
        List<Map<String, String>> percentList = new ArrayList<>();
        Map<String,String>  map = new HashMap<>();
        map.put("name","熏肉大饼");
        map.put("value",300+"");
        percentList.add(map);
        map = new HashMap<>();
        map.put("name","重庆鸡公煲");
        map.put("value",357+"");
        percentList.add(map);
        map = new HashMap<>();
        map.put("name","山西凉醋");
        map.put("value",187+"");
        percentList.add(map);
        return percentList;
    }
    /**
     * 获取本月商家的菜品销量百分比
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getShopPercentByMonth")
    public List<Map<String,String>> getShopPercentByMonth(){
        List<Map<String, String>> percentList = new ArrayList<>();
        Map<String,String>  map = new HashMap<>();
        map.put("name","熏肉大饼");
        map.put("value",1500+"");
        percentList.add(map);
        map = new HashMap<>();
        map.put("name","重庆鸡公煲");
        map.put("value",780+"");
        percentList.add(map);
        map = new HashMap<>();
        map.put("name","山西凉醋");
        map.put("value",1399+"");
        percentList.add(map);
        return percentList;
    }
    /**
     * 获取本年商家的菜品销量百分比
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getShopPercentByYear")
    public List<Map<String,String>> getShopPercentByYear(){
        List<Map<String, String>> percentList = new ArrayList<>();
        Map<String,String>  map = new HashMap<>();
        map.put("name","熏肉大饼");
        map.put("value",5012.0+"");
        percentList.add(map);
        map = new HashMap<>();
        map.put("name","重庆鸡公煲");
        map.put("value",4031.0+"");
        percentList.add(map);
        map = new HashMap<>();
        map.put("name","山西凉醋");
        map.put("value",11399.0+"");
        percentList.add(map);
        return percentList;
    }
}
