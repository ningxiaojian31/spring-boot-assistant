package cn.zdxh.assistant.repository;

import cn.zdxh.assistant.entity.Comment;
import cn.zdxh.assistant.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReposityTest {
        @Autowired
        CommentRepository commentRepository;

      @Autowired
        UserRepository userRepository;
        @Test
        public void testCommentRepository() {
            Comment comment=new Comment();
            comment.setComContent("嘻嘻，我也看见了~");
            comment.setComDate(new Date());
            comment.setComLaud(50);
            comment.setUserId(1);
            comment.setInvId(1);
            commentRepository.save(comment);
        }

    @Test
    public void testUserRepository() {
        User user=new User();
        user.setUserLoginname("xiao");
        user.setUserPassword("12345");
        user.setUserName("侧田");
        user.setUserStudentID("16053080");
        user.setUserWxNumber("5555200000");
        userRepository.save(user);
    }
}
