package com.lcy.order.controller;


import com.lcy.order.pojo.Logistics;
import com.lcy.order.pojo.Order;
import com.lcy.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService; //注入orderService对象

    /***
     * 创建订单
     * @param order
     * @return
     */
    @PostMapping("add")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) //跨域
    public String addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return "订单创建成功！";
    }

    /***
     * 更新订单信息
     * 追加物流信息
     * @param logistics
     * @return
     */
    @PostMapping("update")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) //跨域
    public String updateOrder(@RequestBody Logistics logistics) {
        System.out.println(logistics);
        if(logistics.getOrderId()!= null &&  logistics.getOrderId()!= "" ) {
            orderService.updateOrderAndLogistics(logistics);
            System.out.println(logistics.getOrderId());
            return "物流信息追加成功！";
        }else{
            System.out.println(logistics);
            return "订单编号不能为空！";
        }
    }
    /***
     *根据订单编号来查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) //跨域
    public Order selectOrder(@PathVariable String id) {
        if(id!=null && id!="") {
            return orderService.selectOrderById(id);
        }else{
            return null;
        }
    }
    /**
     * 查询所有订单
     * @return
     */
    @GetMapping("list")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) //跨域
    public Map<String, Object> selectOrderList(){
        return orderService.selectOrderList();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) //跨域
    public String deleteOrderById(@PathVariable String id) {
       boolean rst= orderService.deleteOrderById(id);
       if (rst) {
           System.out.println(id);
           return "订单删除成功！";
       }else{
           System.out.println(id);
            return "订单删除失败！";
           }
    }
}