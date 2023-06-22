package com.example.service;

import com.example.hystrix.MyHystrix;
import com.example.pojo.Logistics;
import com.example.pojo.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(
        name = "order-client",
        url = "http://localhost:8080/order",
        fallback = MyHystrix.class
)
public interface UserFeignClient {
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(Order order);

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(Logistics logistics);

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    @ResponseBody
    public Order select(@PathVariable String id);

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
//    @HystrixCommand(
//            fallbackMethod = "MyHystrix",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//            }
//    )
    public Map<String, Object> selectList();

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable String id);



}