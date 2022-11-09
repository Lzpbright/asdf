package com.test.login.controller;

import com.test.login.config.PwdConfig;
import com.test.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private PwdConfig pwdConfig;

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(){
        return "/html/view";
    }

    @RequestMapping(value = "/loginPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginConfig(HttpServletRequest request){
        String account = request.getParameter("account");
        String password = pwdConfig.encode(request.getParameter("password"));
        String username = userService.login(account, password);
        if (username == null){
             return "redirect:/";
        }else{
            return "redirect:index";
        }
    }
    @RequestMapping(value = "/registerPage", method = {RequestMethod.GET, RequestMethod.POST})
    public  String registerConfig(HttpServletRequest request){
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String password = pwdConfig.encode(request.getParameter("password"));
        long x = userService.register(account, name, password);
        if (x == 0){
            return "redirect:/";
        }else{
            return "redirect:index1";
        }
    }
    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginIndex(){
        return "/html/loginSuccess";
    }

    @RequestMapping(value = "/index1", method = {RequestMethod.POST, RequestMethod.GET})
    public String registerIndex(){
        return "/html/registerSuccess";
    }
}