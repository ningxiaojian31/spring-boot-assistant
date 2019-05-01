package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.Invitation;
import cn.zdxh.assistant.mapper.InvitationCustomerMapper;
import cn.zdxh.assistant.pojo.CommentCustomer;
import cn.zdxh.assistant.pojo.InvitationCustomer;
import cn.zdxh.assistant.repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvitationServiceImpl implements InvitationService{
    //注入两个dao层对象
    @Autowired
    private InvitationRepository invitationRepository;
    @Autowired
    private InvitationCustomerMapper invitationCustomerMapper;

    @Override
    public void insertInvitaion(Invitation invitation) {
        invitationRepository.save(invitation);
    }

    @Override
    public void deleteInvitation(Integer id) {
        invitationRepository.deleteById(id);
    }

    @Override
    public Page<Invitation> findAllInvitations(int startPage,int sizePage) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(startPage,sizePage,sort);
        Page<Invitation> page = invitationRepository.findAll(pageable);
        return page;
    }

    @Override
    public List<CommentCustomer> findDetalInvitation(Integer id) {
        return invitationCustomerMapper.findInvDetailById(id);
    }

    @Override
    public void updateInvitationLaud(Integer id) {
        Optional<Invitation> invitationOptional = invitationRepository.findById(id);
        if (invitationOptional.isPresent()){
            Invitation invitation = invitationOptional.get();
            Integer invLaud = invitation.getInvLaud();
            invitation.setInvLaud(invLaud+1);//赞数+1
            invitationRepository.save(invitation);//更新赞数
        }
    }
}
