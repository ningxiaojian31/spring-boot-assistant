package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.Comment;
import cn.zdxh.assistant.pojo.CommentCustomer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentService {
    //发表评论
    public void insertComment(Comment comment);
    //删除评论，只能删除自己的评论
    public void deleteComment(Integer id);
    //找到某树洞的所有的评论
    public Page<Comment> findAllComments(int startPage, int sizePage, Integer iid);
    //某评论的详细评论
    public CommentCustomer findDetalComment(Integer cid);
    //增加评论的赞数
    public void updateCommentLaud(Integer id);

}
