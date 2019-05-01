package cn.zdxh.assistant.entity;


import javax.persistence.*;

@Entity
@Table(name = "publish")
public class Publish {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //标记是拼饭还是拼伞
    @Column(name = "pub_sign")
    private String pubSign;
    //发布信息的照片
    @Column(name = "pub_image")
    private String pubImage;
    //发布的详细内容
    @Column(name = "pub_content")
    private String pubContent;
    //发布信息的用户外键
    @Column(name = "user_id")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPubSign() {
        return pubSign;
    }

    public void setPubSign(String pubSign) {
        this.pubSign = pubSign;
    }

    public String getPubImage() {
        return pubImage;
    }

    public void setPubImage(String pubImage) {
        this.pubImage = pubImage;
    }

    public String getPubContent() {
        return pubContent;
    }

    public void setPubContent(String pubContent) {
        this.pubContent = pubContent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
