package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.User;
import cn.zdxh.assistant.mapper.UserCustomerMapper;
import cn.zdxh.assistant.pojo.UserCustomer;
import cn.zdxh.assistant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCustomerMapper userCustomerMapper;

    @Override
    public User registerUser(User user) {
        Specification<User> userSpecification=new Specification<User>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> namePath = root.get("userLoginname");//登录名是否唯一
                Path<Object> iDPath = root.get("userStudentID");//学生的学号是否唯一
                return criteriaBuilder.or(criteriaBuilder.equal(namePath,user.getUserLoginname()),criteriaBuilder.equal(iDPath,user.getUserStudentID()));
            }
        };
        Optional<User> one = userRepository.findOne(userSpecification);
        if (!one.isPresent()){
            user.setUserType(2);//设置注册的学生默认的类型为2
           return userRepository.save(user);
        }
        return null;
    }


    @Override
    public User loginUser(User user) {
        Specification<User> userSpecification=new Specification<User>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> namePath = root.get("userLoginname");//登录名是否正确
                Path<Object> wordPath = root.get("userPassword");//密码是否正确
                return criteriaBuilder.and(criteriaBuilder.equal(namePath,user.getUserLoginname()),criteriaBuilder.equal(wordPath,user.getUserPassword()));
            }
        };
        Optional<User> one = userRepository.findOne(userSpecification);
        if(one.isPresent()){
           return one.get();
        }
        return null;
    }

    @Override
    public void changePic(String uploadPath,Integer uid) {
        UserCustomer userCustomer = new UserCustomer();
        userCustomer.setId(uid);
        userCustomer.setUserImage(uploadPath);
        userCustomerMapper.changePic(userCustomer);
    }
}
