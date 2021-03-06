package com.zking.controller;

import com.zking.model.SsmUser;
import com.zking.service.ISsmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController   {
    @Autowired
    private ISsmUserService ssmUserService;

    //登录方法
    @RequestMapping("login")
    @ResponseBody
    public String findUser(SsmUser ssmUser , Model model){
        SsmUser user = ssmUserService.findUser(ssmUser);
        System.out.println(user);
        if(null!=user){
            model.addAttribute("user",user);
            System.out.println("登录成功");
            return  "1";
        }
        return  "-1";
       /* System.out.println("登陸----------------------------------↓");
        System.out.println("賬號:"+ssmUser.toString());
        System.out.println("登陸----------------------------------↑");*/
        //return  "888888888888888";
    }

    @ModelAttribute
    public void frist(Model model,SsmUser ssmUser){

        model.addAttribute("ssmUser",ssmUser);
    }


    /*222222*/
    //注册方法
    @RequestMapping("register")
        public String AddUser(Model model,SsmUser ssmUser){
        int insert = ssmUserService.insert(ssmUser);
        if(insert>0){
            System.out.println("注册成功");
            return "redirect:1";
        }
        return "-1";
    }


    /*zjq  2020-8-08   0.00提交 ↓*/

    /**
     * 根据id查询单个对象·接口
     * @param ssmUser
     * @param model
     * @return
     */
    @RequestMapping("/selectUserByID")
    @ResponseBody
    public String selectUserByID(SsmUser ssmUser,Model model){

        System.out.println("Controller：SsmUser-- selectUserByID类   :调用");
        SsmUser ssmUser2 = ssmUserService.selectByPrimaryKey(ssmUser.getUserId());

        return ssmUser2.toString();
    };

    /**
     * 查询所有
     * @param model
     * @return
     */
    @RequestMapping("/selectUserAll")
    @ResponseBody
    public String selectUserAll(Model model){

        System.out.println("Controller：SsmUser-- selectUserAll类   :调用");
        List<SsmUser> ssmUserList = ssmUserService.selectSsmUserAll();


        return ssmUserList.toString();
    };


    /*zjq  2020-8-08   0.00提交 ↑*/

}
