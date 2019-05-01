package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.Order;
import cn.zdxh.assistant.pojo.OrderCustomer;

import java.util.List;

public interface OrderService {
    //预约发布信息
    public void insertOrder(OrderCustomer orderCustomer);
    //根据发布人查询订单的详细信息
    public List<OrderCustomer> findOrderByPublisher(Integer id);
    //根据预约人查询订单的详细信息
    public List<OrderCustomer> findOrderByAppointment(Integer id);
}
