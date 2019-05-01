package cn.zdxh.assistant.entity;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicInsert
public class User {
    //主键id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //登录名
    @Column(name = "user_loginname")
    private String userLoginname;
    //登录密码
    @Column(name = "user_password")
    private String userPassword;
    //姓名
    @Column(name = "user_name")
    private String userName;
    //学号
    @Column(name = "user_studentID")
    private String userStudentID;
    //头像
    @Column(name = "user_image")
    private String userImage;
    //微信号
    @Column(name = "user_wx_number")
    private String userWxNumber;
    //用户或者管理员类型
    @Column(name = "user_type")
    private Integer userType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserLoginname() {
        return userLoginname;
    }

    public void setUserLoginname(String userLoginname) {
        this.userLoginname = userLoginname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStudentID() {
        return userStudentID;
    }

    public void setUserStudentID(String userStudentID) {
        this.userStudentID = userStudentID;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserWxNumber() {
        return userWxNumber;
    }

    public void setUserWxNumber(String userWxNumber) {
        this.userWxNumber = userWxNumber;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userLoginname='" + userLoginname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userStudentID='" + userStudentID + '\'' +
                ", userImage='" + userImage + '\'' +
                ", userWxNumber='" + userWxNumber + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
