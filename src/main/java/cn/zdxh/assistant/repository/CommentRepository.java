package cn.zdxh.assistant.repository;

import cn.zdxh.assistant.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 利用spring data jpa编写接口
 */
public interface CommentRepository extends JpaRepository<Comment,Integer>,JpaSpecificationExecutor<Comment>{
}
