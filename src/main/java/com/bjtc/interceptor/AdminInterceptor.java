package com.bjtc.interceptor;

import com.bjtc.pojo.Admin;
import com.bjtc.pojo.Seller;
import com.bjtc.pojo.User;
import com.bjtc.service.AdminService;
import com.bjtc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {
    @Autowired
    private AdminService adminService;
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse response, Object object, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        if(request.getRequestURI().equals("/paopao/admin/adminLogin")){
            response.setHeader("message","success");
            return true;
        }
        boolean isExistAdmin=false;
        response.setHeader("message","false");
        HttpSession session = request.getSession(false);
        if(session==null){
            response.setHeader("message","NoSession");
            response.sendRedirect("index.jsp");
            return false;
        }
        Cookie[] cookies = request.getCookies();
        Object adminPhone = session.getAttribute("adminPhone");
        Object adminPassword = session.getAttribute("adminPassword");

        if(adminPhone==null||adminPassword==null){
           return false;
        }
        Admin admin = null;
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("adminPhone")){
                isExistAdmin=true;
                 admin = adminService.selectAdminByPhone(adminPhone.toString());
                if(!cookie.getValue().equals(adminPhone)||adminPassword.equals(admin.getAdminPassword())){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    return false;
                }
            }
        }
        if(!isExistAdmin||admin == null){
            response.sendRedirect("/paopao/admin/adminLogin");
            return false;
        }
        // 设置：Access-Control-Allow-Origin头，处理Session问题
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("P3P", "CP=CAO PSA OUR");
        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
            response.addHeader("Access-Control-Allow-Methods", "POST,GET,TRACE,OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type,Origin,Accept");
            response.addHeader("Access-Control-Max-Age", "120");
        }
        response.setHeader("message","success");
        return true;
    }
}
