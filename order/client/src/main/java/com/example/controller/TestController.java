package com.example.controller;

import com.example.pojo.Logistics;
import com.example.pojo.Order;
import com.example.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class TestController {
 
    @Resource
    private UserFeignClient userFeignClient;
 
    @PostMapping("/add")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) //跨域
    public String add(Order order){
        return userFeignClient.add(order);
    }

    @PostMapping("/update")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) //跨域
    public String update(Logistics logistics){
        System.out.println(logistics+"client");
        return userFeignClient.update(logistics);
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) //跨域
    public Order select(@PathVariable String id){
        return userFeignClient.select(id);
    }

    @GetMapping("/list")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) //跨域
    public Map<String,Object> selectList(){
        return userFeignClient.selectList();
    }

    @GetMapping("delete/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) //跨域
    public String delete(@PathVariable String id){
        System.out.println(id);
        return userFeignClient.delete(id);
    }




}