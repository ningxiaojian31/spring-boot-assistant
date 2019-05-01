package cn.zdxh.assistant.repository;

import cn.zdxh.assistant.entity.Publish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PublishRepository extends JpaRepository<Publish,Integer>,JpaSpecificationExecutor<Publish>{
}
