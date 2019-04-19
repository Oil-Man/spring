package com.oilman.springboot2.controller;

import com.oilman.springboot2.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：控制器类
 * Created by wangcw on 2019/4/19.
 */
@Controller
public class PersonController {
    @RequestMapping("/toindex")
    public String index(Model model){
        Person single = new Person("aa", 11);
        Person p1 = new Person("bb", 22);
        Person p2 = new Person("cc", 33);
        Person p3 = new Person("dd", 44);
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        model.addAttribute("single", single);
        model.addAttribute("persons", persons);
        return "index";
    }
}
