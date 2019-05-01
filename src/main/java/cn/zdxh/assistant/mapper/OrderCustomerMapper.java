package cn.zdxh.assistant.mapper;

import cn.zdxh.assistant.entity.Order;
import cn.zdxh.assistant.pojo.OrderCustomer;

import java.util.List;

public interface OrderCustomerMapper {
    //根据发布人查询订单的详细信息
    public List<OrderCustomer> findOrderByPublisher(Integer id);
    //根据预约人查询订单的详细信息
    public List<OrderCustomer> findOrderByAppointment(Integer id);
    //添加预约
    public void insertOrder(OrderCustomer orderCustomer);
}
