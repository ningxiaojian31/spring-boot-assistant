package cn.zdxh.assistant.controller;

import cn.zdxh.assistant.entity.Comment;
import cn.zdxh.assistant.pojo.CommentCustomer;
import cn.zdxh.assistant.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    //添加评论
    @ResponseBody
    @RequestMapping(value = "/com",method = RequestMethod.POST)
    public String insertComment(@RequestBody Comment comment){
        comment.setComDate(new Date());
        commentService.insertComment(comment);
        return "评论成功！";
    }

    //删除自己的评论
    @ResponseBody
    @RequestMapping(value = "/com/{id}",method = RequestMethod.DELETE)
    public String deleteComment(@PathVariable("id") Integer id){
        commentService.deleteComment(id);
        return "成功删除评论！";
    }

    //找到某树洞的所有评论
    @ResponseBody
    @RequestMapping(value = "/coms/{iid}/{startPage}/{sizePage}",method = RequestMethod.GET)
    public Page<Comment> findAllComments(@PathVariable("iid") int iid,@PathVariable("startPage") int startPage,@PathVariable("sizePage") int sizePage){
        return commentService.findAllComments(startPage,sizePage,iid);
    }

    //某评论详情
    @ResponseBody
    @RequestMapping(value = "/com/{cid}",method = RequestMethod.GET)
    public CommentCustomer findDetalComment(@PathVariable("cid") Integer cid){
        return commentService.findDetalComment(cid);
    }

    //增加评论赞数
    @ResponseBody
    @RequestMapping(value = "/com/{id}",method = RequestMethod.PUT)
    public String updateCommentLaud(@PathVariable("id") Integer id){
        commentService.updateCommentLaud(id);
        return "成功点赞评论";
    }
}
