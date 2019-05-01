package cn.zdxh.assistant.controller;

import cn.zdxh.assistant.entity.Invitation;
import cn.zdxh.assistant.pojo.CommentCustomer;
import cn.zdxh.assistant.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvitationController {
    @Autowired
    private InvitationService invitationService;

    //发布树洞
    @ResponseBody
    @RequestMapping(value = "/inv",method = RequestMethod.POST)
    public String insertInvitation(@RequestBody Invitation invitation){
        invitationService.insertInvitaion(invitation);
        return "发布树洞成功！";
    }

    //删除树洞
    @ResponseBody
    @RequestMapping(value = "/inv/{id}",method = RequestMethod.DELETE)
    public String deleteInvitation(@PathVariable("id") Integer id){
        invitationService.deleteInvitation(id);
        return "删除树洞成功！";
    }

    //找到所有的树洞
    @ResponseBody
    @RequestMapping(value = "/invs/{startPage}/{sizePage}",method = RequestMethod.GET)
    public Page<Invitation> findAllInvitations(@PathVariable("startPage") int startPage,@PathVariable("sizePage") int sizePage){
        return invitationService.findAllInvitations(startPage,sizePage);
    }

    //某条树洞详情
    @ResponseBody
    @RequestMapping(value = "/inv/{id}",method = RequestMethod.GET)
    public List<CommentCustomer> findDetalInvitation(@PathVariable("id") int id){
        return invitationService.findDetalInvitation(id);
    }

    //增加树洞赞数
    @ResponseBody
    @RequestMapping(value = "/inv/{id}",method = RequestMethod.PUT)
    public String updateInvitationLaud(@PathVariable("id") Integer id){
        invitationService.updateInvitationLaud(id);
        return "成功点赞树洞";
    }
}
