package com.example.service;


import com.example.pojo.Logistics;
import com.example.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.Map;

@FeignClient(name = "server-hystrix")
@Component
public interface HystrixService {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    String info();

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(Order order);

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(Logistics logistics);

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    @ResponseBody
    public String select(@PathVariable String id);

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public String selectList();

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable String id);


}
