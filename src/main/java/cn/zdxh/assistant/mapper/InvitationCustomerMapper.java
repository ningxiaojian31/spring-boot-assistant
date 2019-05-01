package cn.zdxh.assistant.mapper;

import cn.zdxh.assistant.pojo.CommentCustomer;
import cn.zdxh.assistant.pojo.InvitationCustomer;

import java.util.List;

public interface InvitationCustomerMapper {
    //public InvitationCustomer findInvitationDetailById(Integer id);//已经过时
    //根据帖子id查询所有评论以及每一条评论的用户
    public List<CommentCustomer> findInvDetailById(Integer id);
}
