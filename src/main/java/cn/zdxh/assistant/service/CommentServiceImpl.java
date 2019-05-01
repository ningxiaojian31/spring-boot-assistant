package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.Comment;
import cn.zdxh.assistant.mapper.CommentCustomerMapper;
import cn.zdxh.assistant.pojo.CommentCustomer;
import cn.zdxh.assistant.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentCustomerMapper commentCustomerMapper;

    @Override
    public void insertComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Page<Comment> findAllComments(int startPage, int sizePage, Integer iid) {
        //动态构建查询条件
        Specification<Comment> commentSpecification=new Specification<Comment>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> path = root.get("invId");
                Predicate equal = criteriaBuilder.equal(path, iid);//某树洞的所有的评论
                return equal;
            }
        };
        Sort sort=new Sort(Sort.Direction.DESC,"id");//时间倒叙
        Pageable pageable=new PageRequest(startPage,sizePage,sort);
        return commentRepository.findAll(commentSpecification,pageable);
    }

    @Override
    public CommentCustomer findDetalComment(Integer cid) {
        return commentCustomerMapper.findCommentDetailById(cid);
    }

    @Override
    public void updateCommentLaud(Integer id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()){
            Comment comment = commentOptional.get();
            Integer comLaud = comment.getComLaud();
            comment.setComLaud(comLaud+1);//赞数+1
            commentRepository.save(comment);//更新赞数
        }
    }
}
