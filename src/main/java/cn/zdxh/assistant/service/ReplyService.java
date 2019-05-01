package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.Reply;
import cn.zdxh.assistant.pojo.CommentCustomer;

public interface ReplyService {
    //新增回复
    public void insertReply(Reply reply);
    //删除自己的回复
    public void deleteReply(Integer rid);
    //增加评论的赞数
    public void updateReplyLaud(Integer id);

}
