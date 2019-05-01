package cn.zdxh.assistant.entity;

import javax.persistence.*;

@Entity
@Table(name = "reply")
public class Reply {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //回复类型
    @Column(name = "re_type")
    private Integer reType;
    //回复内容
    @Column(name = "re_content")
    private String reContent;
    //回复的赞数
    @Column(name = "re_laud")
    private Integer reLaud;
    //回复的帖子外键
    @Column(name = "com_id")
    private Integer comId;
    //回复人的外键
    @Column(name = "user_id_from")
    private Integer userIdFrom;
    //被回复人的外键
    @Column(name = "user_id_to")
    private Integer userIdTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReType() {
        return reType;
    }

    public void setReType(Integer reType) {
        this.reType = reType;
    }

    public String getReContent() {
        return reContent;
    }

    public void setReContent(String reContent) {
        this.reContent = reContent;
    }

    public Integer getReLaud() {
        return reLaud;
    }

    public void setReLaud(Integer reLaud) {
        this.reLaud = reLaud;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getUserIdFrom() {
        return userIdFrom;
    }

    public void setUserIdFrom(Integer userIdFrom) {
        this.userIdFrom = userIdFrom;
    }

    public Integer getUserIdTo() {
        return userIdTo;
    }

    public void setUserIdTo(Integer userIdTo) {
        this.userIdTo = userIdTo;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", reType=" + reType +
                ", reContent='" + reContent + '\'' +
                ", reLaud=" + reLaud +
                ", comId=" + comId +
                ", userIdFrom=" + userIdFrom +
                ", userIdTo=" + userIdTo +
                '}';
    }
}
