package cn.zdxh.assistant.mapper;

import cn.zdxh.assistant.entity.Comment;
import cn.zdxh.assistant.entity.User;
import cn.zdxh.assistant.pojo.CommentCustomer;
import cn.zdxh.assistant.pojo.InvitationCustomer;
import cn.zdxh.assistant.pojo.OrderCustomer;
import cn.zdxh.assistant.repository.CommentRepository;
import cn.zdxh.assistant.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
        @Autowired
        InvitationCustomerMapper invitationCustomerMapper;

        @Autowired
        CommentCustomerMapper commentCustomerMapper;

        @Autowired
        OrderCustomerMapper orderCustomerMapper;

        @Test
        public void testInvitationCustomerMapper() {
//            InvitationCustomer invitationCustomer = invitationCustomerMapper.findInvitationDetailById(1);
//            System.out.println(invitationCustomer);
        }

        @Test
        public void testCommentCustomerMapper() {
            CommentCustomer commentCustomer = commentCustomerMapper.findCommentDetailById(2);
            System.out.println(commentCustomer);
        }

        @Test
        public void testOrderCustomerMapper() {
            List<OrderCustomer> orderCustomer = orderCustomerMapper.findOrderByPublisher(1);
            System.out.println(orderCustomer);
            List<OrderCustomer> orderCustomer2 = orderCustomerMapper.findOrderByAppointment(2);
            System.out.println(orderCustomer2);
        }

        @Test
        public void testFindInvDetailById(){
            List<CommentCustomer> commentCustomers = invitationCustomerMapper.findInvDetailById(1);
           for (CommentCustomer commentCustomer:commentCustomers){
               System.out.println(commentCustomer);
           }
        }
}
