package com.szxj.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author suzhouxj
 */
@Controller
public class MainController {

   @RequestMapping("/")
    public  String root(){

       return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index (){

        return "index.html";
    }

    @RequestMapping("/{name}")
    public String t1( @PathVariable("name") String name) {
        return name;
    }

}
