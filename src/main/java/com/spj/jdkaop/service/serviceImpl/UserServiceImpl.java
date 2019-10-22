package com.spj.jdkaop.service.serviceImpl;

import com.spj.jdkaop.service.UserService;
import org.springframework.web.servlet.ModelAndView;

public class UserServiceImpl implements UserService {

    @Override
    public String addUser() {
        System.out.println("user add......");
        return null;
    }

    @Override
    public ModelAndView deleteUser() {
        System.out.println("delete User ....");
        return null;
    }
}
