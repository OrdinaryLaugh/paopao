package com.bjtc.service;

import com.bjtc.pojo.Admin;

import java.util.List;

public interface AdminService {
    public boolean addAdmin(Admin admin);

    public boolean deleteAdmin(Admin admin);

    public boolean deleteAdminByPhone(String phone);

    public Admin selectAdmin(Admin admin);

    public Admin selectAdminByPhone(String phone);

    public List<Admin> selectAllAdmin();

    public boolean updateAdmin(Admin admin);
}
