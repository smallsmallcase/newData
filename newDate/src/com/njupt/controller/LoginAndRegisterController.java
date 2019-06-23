package com.njupt.controller;

import com.njupt.po.User;
import com.njupt.service.BasicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by huhui on 2017/12/6.
 */
@Controller
public class LoginAndRegisterController {

    @Resource(name = "UserService")
    private BasicService userService;

    @Value("${adminName}")
    private String adminName;
    @Value("${adminPassword}")
    private String adminPassword;

    @RequestMapping("/register")
    public void register(User user,PrintWriter outer) {
        User userTmp = new User();
        userTmp.setUser_name(user.getUser_name());
        List<User> query = userService.query(userTmp);
        if (query == null || query.size() == 0){
            user = (User) userService.insert(user);
            outer.write("success");
        }else{
            outer.write("failed");
        }
    }

    @RequestMapping("/login")
    public void login(User user, HttpServletRequest request, HttpServletResponse response, PrintWriter outer) throws IOException, ServletException {
        if (adminName!=null&&
                adminPassword!=null&&
                adminName.equals(user.getUser_name())&&
                adminPassword.equals(user.getPassword())){
            outer.write("admin");
            request.getSession().setAttribute("user_information", user);
            return;
        }/*666666666*/
        if(user.getUser_name() == null||user.getPassword() == null){
            outer.write("failed") ;
            return;
        }
        List<User> result = (List<User>) userService.query(user);
        if (result == null||result.size() == 0){
            outer.write("failed") ;
            return;
        }
        user = result.get(0);
        request.getSession().setAttribute("user_information", user);
        outer.write("success");
    }

    @RequestMapping("/logout")
    public ModelAndView logout(User user, HttpServletRequest request) {
        request.getSession().removeAttribute("user_information");
        request.getSession().removeAttribute("task_id");
        request.getSession().removeAttribute("basic_id");
        return new ModelAndView("redirect:checkTask.form");
    }

    @RequestMapping("/loginForAdmin")
    public String loginForAdmin(){
        return "adminMain";
    }

}
