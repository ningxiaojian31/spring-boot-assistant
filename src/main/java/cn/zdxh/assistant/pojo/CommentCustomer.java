package cn.zdxh.assistant.pojo;


import java.util.Date;
import java.util.List;


public class CommentCustomer {
    //主键
    private Integer id;
    //评论时间
    private Date comDate;
    //评论内容
    private String comContent;
    //评论赞数
    private Integer comLaud;
    //帖子的外键
    private Integer invId;
    //评论用户的外键
    private Integer userId;
    //评论用户
    private UserCustomer user;
    //一个评论有多个嵌套评论
    private List<ReplyCustomer> replys;

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

    public UserCustomer getUser() {
        return user;
    }

    public void setUser(UserCustomer user) {
        this.user = user;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public List<ReplyCustomer> getReplys() {
        return replys;
    }

    public void setReplys(List<ReplyCustomer> replys) {
        this.replys = replys;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CommentCustomer{" +
                "id=" + id +
                ", comDate=" + comDate +
                ", comContent='" + comContent + '\'' +
                ", comLaud=" + comLaud +
                ", invId=" + invId +
                ", userId=" + userId +
                ", user=" + user +
                ", replys=" + replys +
                '}';
    }
}
