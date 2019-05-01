package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.Reply;
import cn.zdxh.assistant.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public void insertReply(Reply reply) {
        replyRepository.save(reply);
    }

    @Override
    public void deleteReply(Integer rid) {
        replyRepository.deleteById(rid);
    }

    @Override
    public void updateReplyLaud(Integer id) {
        Optional<Reply> replyOptional = replyRepository.findById(id);
        if (replyOptional.isPresent()){
            Reply reply = replyOptional.get();
            Integer repLaud = reply.getReLaud();
            reply.setReLaud(repLaud+1);//赞数+1
            replyRepository.save(reply);//更新赞数
        }
    }

}
