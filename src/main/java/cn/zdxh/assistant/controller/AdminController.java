package cn.zdxh.assistant.controller;

import cn.zdxh.assistant.entity.Invitation;
import cn.zdxh.assistant.entity.Publish;
import cn.zdxh.assistant.entity.User;
import cn.zdxh.assistant.service.InvitationService;
import cn.zdxh.assistant.service.PublishService;
import cn.zdxh.assistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private PublishService publishService;

    //跳到登录页面
    @GetMapping(value = "/index")
    public String index(){
        return "login";
    }

    //管理员登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginUser(User user, HttpSession session){
        User admin=userService.loginUser(user);
        //判断用户名和密码是否正确，再判断是否是管理员
        if (admin!=null && admin.getUserType()==1){
            //把信息存进session
            session.setAttribute("admin",admin);
            return "homePage";
        }
        session.setAttribute("msg","用户名或密码错误！");
        return "login";

    }

    //跳到后台首页
    @GetMapping(value = "/homePage")
    public String tohomePage(){
        return "homePage";
    }

    //显示所有的树洞,分页
    @GetMapping(value = "/invs/{sizePage}")
    public String showInvitations(Model model,int startPage,@PathVariable("sizePage") int sizePage){
        List<Invitation> invitations=new ArrayList<>();
        Page<Invitation> allInvitations = invitationService.findAllInvitations(startPage, sizePage);
        int totalPages = allInvitations.getTotalPages();
        invitations=allInvitations.getContent();
        model.addAttribute("invitations",invitations);
        model.addAttribute("totalPages",totalPages);
        return "showInvitation";
    }

    //删除树洞
    @GetMapping(value = "/deleteInv")
    public String  deleteInvitation(Integer id){
        invitationService.deleteInvitation(id);
        return "redirect:/admin/invs/5?startPage=0";
    }

    //显示所有的发布,分页
    @GetMapping(value = "/pubs/{sizePage}")
    public String showPublishs(Model model,int startPage,@PathVariable("sizePage") int sizePage){
        List<Publish> publishes=new ArrayList<>();
        Page<Publish> allPublishs = publishService.findAllPublishs(startPage, sizePage);
        publishes=allPublishs.getContent();
        int totalPages = allPublishs.getTotalPages();
        model.addAttribute("publishes",publishes);
        model.addAttribute("totalPages",totalPages);
        return "showPublishs";
    }

    //删除发布
    @GetMapping(value = "/deletePub")
    public String deletePublish(Integer id){
        publishService.deletePublish(id);
        return "redirect:/admin/pubs/5?startPage=0";
    }
}
