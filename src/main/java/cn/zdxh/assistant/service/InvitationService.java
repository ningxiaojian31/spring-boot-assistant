package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.Invitation;
import cn.zdxh.assistant.pojo.CommentCustomer;
import cn.zdxh.assistant.pojo.InvitationCustomer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InvitationService {
    //新增帖子
    public void insertInvitaion(Invitation invitation);
    //删除帖子
    public void deleteInvitation(Integer id);
    //找到所有的帖子,分页
    public Page<Invitation> findAllInvitations(int startPage, int sizePage);
    //进入帖子详情
    public List<CommentCustomer> findDetalInvitation(Integer id);
    //增加帖子的赞数
    public void updateInvitationLaud(Integer id);
}
