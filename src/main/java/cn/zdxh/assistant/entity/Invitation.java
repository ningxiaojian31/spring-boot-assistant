package cn.zdxh.assistant.entity;



import javax.persistence.*;

@Entity
@Table(name = "invitation")
public class Invitation {
    //主键，id不要导错包
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //帖子内容
    @Column(name = "inv_content")
    private String invContent;
    //帖子赞数
    @Column(name = "inv_laud")
    private Integer invLaud;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvContent() {
        return invContent;
    }

    public void setInvContent(String invContent) {
        this.invContent = invContent;
    }

    public Integer getInvLaud() {
        return invLaud;
    }

    public void setInvLaud(Integer invLaud) {
        this.invLaud = invLaud;
    }
}
