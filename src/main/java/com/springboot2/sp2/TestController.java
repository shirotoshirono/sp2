package com.springboot2.sp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    private UserRepository userRepository;
    @Autowired
    public TestController(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String userLogin(Model model,User user){
        List<User> userList=userRepository.findByPasswordAndUsername(user.getPassword(),user.getUsername());
        if(userList!=null){
            model.addAttribute("usermessage",userList);
            return "main";
        }
        return "userpage";
    }
    @RequestMapping(path = "/Register",method = RequestMethod.POST)
    public String userRegister(User user){
        List<User> userList=userRepository.findByUsername(user.getUsername());
        if(user.getPassword().isEmpty()||user.getUsername().isEmpty()||userList!=null){
            System.out.println("error");
        }else{
            userRepository.save(user);
            return "redirect:/test/login";
        }
            return "userpage1";
    }


}
