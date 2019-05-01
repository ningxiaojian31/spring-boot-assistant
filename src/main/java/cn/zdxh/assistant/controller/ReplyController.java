package cn.zdxh.assistant.controller;

import cn.zdxh.assistant.entity.Reply;
import cn.zdxh.assistant.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    //新增评论中的评论
    @ResponseBody
    @RequestMapping(value = "/rep",method = RequestMethod.POST)
    public String insertReply(@RequestBody Reply reply){
        replyService.insertReply(reply);
        return "回复评论成功！";
    }

    //删除自己的评论回复
    @ResponseBody
    @RequestMapping(value = "/rep/{rid}",method = RequestMethod.DELETE)
    public String deleteReply(@PathVariable("rid") Integer rid){
        replyService.deleteReply(rid);
        return "删除回复成功";
    }

    //增加评论赞数
    @ResponseBody
    @RequestMapping(value = "/rep/{id}",method = RequestMethod.PUT)
    public String updateCommentLaud(@PathVariable("id") Integer id){
        replyService.updateReplyLaud(id);
        return "成功点赞回复";
    }
}
