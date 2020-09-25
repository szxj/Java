package com.szxj.so.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.szxj.so.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suzhouxj
 */
@RestController
public class TestSOController {


        @RequestMapping(value = "/user",method = RequestMethod.GET)
        /*
         * default value	默认
         * name				请求的名字
         * required			是否必须的，true
         * value
         */
        @JsonView(User.UserSimpleView.class)
        public List<User> query(@RequestParam(name = "username",required = false,defaultValue = "szxj") String name){
            System.out.println(name);
            List<User> list = new ArrayList<>();
            list.add(new User());
            list.add(new User());
            list.add(new User());
            return list;
        }


        @JsonView(User.UserDetailView.class)
        @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
        //@PathVariable 将URL路径中的片段映射到我们的java代码中（参数）
        public User getInfo(@PathVariable String id){

            User user = new User();
            user.setUsername("szxj");
            return user;
        }

    //添加
   // @RequestMapping(value="/user",method = RequestMethod.POST)
    //@RequestBody 运用Json格式传输
    @PostMapping("/user")
    public User addUser(@RequestBody User user)
    {
        //null
        //lain
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        user.setId("1");
        return user;
    }


    //修改
    //@RequestMapping(value="/user/{id}",method = RequestMethod.PUT)
    @PutMapping("user/{id}")
    public User updataUser(@RequestBody User user)
    {
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        return user;
    }


    //删除
    //@RequestMapping(value="/user/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("user/{id}")
    public User deleteUser(@PathVariable String id)
    {
        System.out.println(id);
        return null;
    }

}
