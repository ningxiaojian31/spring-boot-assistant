package cn.zdxh.assistant.mapper;

import cn.zdxh.assistant.pojo.CommentCustomer;

public interface CommentCustomerMapper {
    //根据评论id查询所有评论回复以及每一条回复和被回复用户
    public CommentCustomer findCommentDetailById(Integer id);
}
