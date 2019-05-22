package com.bjtc.mapper;

import com.bjtc.pojo.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminMapper {
    public boolean addAdmin(Admin admin);

    public boolean deleteAdmin(Admin admin);

    public boolean deleteAdminByPhone(String phone);

    public Admin selectAdmin(Admin admin);

    public Admin selectAdminByPhone(String phone);

    List<Admin> getApprovingAdmins();

    public List<Admin> selectAllAdmin();

    public boolean updateAdmin(Admin admin);
}
