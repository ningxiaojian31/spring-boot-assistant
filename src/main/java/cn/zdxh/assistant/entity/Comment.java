package cn.zdxh.assistant.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //评论时间
    @Column(name = "com_date")
    private Date comDate;
    //评论内容
    @Column(name = "com_content")
    private String comContent;
    //评论赞数
    @Column(name = "com_laud")
    private Integer comLaud;
    //评论用户外键
    @Column(name = "user_id")
    private Integer userId;
    //帖子的外键
    @Column(name = "inv_id")
    private Integer invId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getComDate() {
        return comDate;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public Integer getComLaud() {
        return comLaud;
    }

    public void setComLaud(Integer comLaud) {
        this.comLaud = comLaud;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }
}
