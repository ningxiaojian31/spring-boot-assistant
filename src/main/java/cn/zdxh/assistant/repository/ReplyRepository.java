package cn.zdxh.assistant.repository;

import cn.zdxh.assistant.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 利用spring data jpa编写接口
 */
public interface ReplyRepository extends JpaRepository<Reply,Integer>,JpaSpecificationExecutor<Reply>{
}
