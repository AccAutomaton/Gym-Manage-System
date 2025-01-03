package com.acautomaton.gym.controller;

import com.acautomaton.gym.dao.AdminUserDao;
import com.acautomaton.gym.entity.Adminuser;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/")
public class AdminuserConntroller {
    private final AdminUserDao adminuserDao;

    @Autowired
    public AdminuserConntroller(AdminUserDao adminuserDao) {
        this.adminuserDao = adminuserDao;
    }

    @RequestMapping("/")
    public String beforeLogin(){
        return "login";
    }

    @RequestMapping("/dl/yz")
    public String login(String username, String password,HttpSession httpSession,Model model){


        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken userToken=new UsernamePasswordToken(username,DigestUtils.md5Hex(password));
        try{
            subject.login(userToken);
            Adminuser a= adminuserDao.findByAdminNameAndAdminPassword(username,DigestUtils.md5Hex(password));
            httpSession.setAttribute("user",a);
            return "WEB-INF/jsp/index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名或密码错误,请重新输入");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @RequestMapping("/updPassword")
    public String updPassword(){
        return "WEB-INF/jsp/updPassword";
    }

    @RequestMapping("/upd/updPassword")
    public String updPasswordConfirm(String oldPassword,String newPassword,String newPasswordAgain,HttpSession httpSession,Model model){
        Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@!.%*#?&])[A-Za-z\\d$@!.%*#?&]{8,}$");
        Matcher m = p.matcher(newPassword);
        if(!m.matches()){
            model.addAttribute("msg","新密码最少为8位并为字母+数字+特殊字符");
            return "WEB-INF/jsp/updPassword";
        }
        if(!newPassword.equals(newPasswordAgain)){
            model.addAttribute("msg","两次输入新密码不一致,请重新输入");
            return "WEB-INF/jsp/updPassword";
        }
        Adminuser adminuser=(Adminuser) httpSession.getAttribute("user");
        if(null != adminuser){
            if(!adminuser.getAdminPassword().equals(DigestUtils.md5Hex(oldPassword))){
                model.addAttribute("msg","原密码不正确,请重新输入");
                return "WEB-INF/jsp/updPassword";
            }
            adminuserDao.updPassword(adminuser.getAdminId(), DigestUtils.md5Hex(newPassword));
        }
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
       return "redirect:/login.jsp";
    }
}
