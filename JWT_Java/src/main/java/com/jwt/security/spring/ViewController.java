package com.jwt.security.spring;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/")
    public String index() {
        return "index";}

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RolesAllowed("Role.ROLE_USER")
    @RequestMapping("/userpage")
    public String user(){
        return "userpage";
    }


    @RequestMapping("/adminpage")
    public String admin(){
        return "adminpage";
    }

    @RequestMapping("/homepage")
    public String home(){
        return "homepage";
    }

    @RequestMapping("/accessDenied")
    public String denied(){
        return "accessDenied";
    }



}