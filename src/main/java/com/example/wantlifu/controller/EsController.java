package com.example.wantlifu.controller;

import com.example.wantlifu.es.dao.UsersRepository;
import com.example.wantlifu.mbg.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王志坚
 * @createTime 2019.12.10.11:52
 */
@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    private UsersRepository usersRepository;

    //增加
    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id")Integer id){

       Users u = new Users();
       u.setUserid(id);
       u.setUsername("hello");
       u.setEmail("asiufgjkugass");
       u.setIsDelete(1);
       u.setUserpwd("asgfjasd");

       usersRepository.save(u);
//       System.err.println("add a obj");

        return "success";
    }

    //删除
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        Users u = new Users();
        u.setUserid(id);
        usersRepository.delete(u);

        return "success";
    }

    //局部更新
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id")Integer id){

        Users u = new Users();
        u.setUserid(id);
        u.setUsername("change");
        usersRepository.save(u);

        System.err.println("update a obj");

        return "success";
    }

    //查询
    @RequestMapping("/query/{id}")
    public Users query(@PathVariable("id")Integer id){

        Users users = usersRepository.queryUsersByUserid(id);

        System.err.println(users);

        return users;
    }

}
