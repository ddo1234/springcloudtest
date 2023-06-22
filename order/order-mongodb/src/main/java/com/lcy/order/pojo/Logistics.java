package com.lcy.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 物流
 */
public class Logistics implements Serializable {
    private String orderId; //订单编号
    private String operation;   //操作名称
    private String operator;    //操作员
    private String phone;   //操作员电话
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operationTime; //操作时间
    private String address; //操作地址
    private String details; //详细信息
}

