package cn.zdxh.assistant.repository;

import cn.zdxh.assistant.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InvitationRepository extends JpaRepository<Invitation,Integer>,JpaSpecificationExecutor<Invitation>{
}
