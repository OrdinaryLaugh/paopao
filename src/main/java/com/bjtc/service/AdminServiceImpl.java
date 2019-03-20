package com.bjtc.service;

import com.bjtc.mapper.AdminMapper;
import com.bjtc.pojo.Admin;
import com.bjtc.util.CheckInputUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
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
    public boolean deleteAdmin(Admin admin) {
        if(admin!=null&&!StringUtils.isEmpty(admin.getAdminPassword())&&!StringUtils.isEmpty(admin.getAdminPhone())){
            boolean result = adminMapper.deleteAdmin(admin);
            return result;
        }
        return false;
    }

    @Override
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
    public boolean updateAdmin(Admin admin) {
        if(admin!=null&&!StringUtils.isEmpty(admin.getAdminPassword())&&!StringUtils.isEmpty(admin.getAdminPhone())){
            boolean result = adminMapper.updateAdmin(admin);
            return result;
        }
        return false;
    }
}
