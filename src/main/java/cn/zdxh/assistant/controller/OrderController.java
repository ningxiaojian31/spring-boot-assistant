package cn.zdxh.assistant.controller;

import cn.zdxh.assistant.entity.Order;
import cn.zdxh.assistant.pojo.OrderCustomer;
import cn.zdxh.assistant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    //根据发布人查询订单的详细信息
    @ResponseBody
    @RequestMapping(value = "/ord/pub/{id}",method = RequestMethod.GET)
    public List<OrderCustomer> findOrderByPublisher(@PathVariable("id") Integer id){
        return orderService.findOrderByPublisher(id);
    }

    //根据预约人查询订单的详细信息
    @ResponseBody
    @RequestMapping(value = "/ord/app/{id}",method = RequestMethod.GET)
    public List<OrderCustomer> findOrderByAppointment(@PathVariable("id") Integer id){
        return orderService.findOrderByAppointment(id);
    }

    //预约发布出来的信息
    @ResponseBody
    @RequestMapping(value = "/ord",method = RequestMethod.POST)
    public String insertOrder(@RequestBody OrderCustomer orderCustomer){
        orderService.insertOrder(orderCustomer);
        return "预约成功";
    }
}
