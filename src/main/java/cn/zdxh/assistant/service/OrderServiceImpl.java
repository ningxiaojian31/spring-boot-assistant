package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.Order;
import cn.zdxh.assistant.mapper.OrderCustomerMapper;
import cn.zdxh.assistant.pojo.OrderCustomer;
import cn.zdxh.assistant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderCustomerMapper orderCustomerMapper;

    @Override
    public void insertOrder(OrderCustomer orderCustomer) {
        orderCustomerMapper.insertOrder(orderCustomer);
    }

    @Override
    public List<OrderCustomer> findOrderByPublisher(Integer id) {
        return orderCustomerMapper.findOrderByPublisher(id);
    }

    @Override
    public List<OrderCustomer> findOrderByAppointment(Integer id) {
        return orderCustomerMapper.findOrderByAppointment(id);
    }
}
