package cn.zdxh.assistant.entity;



import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //申请预约的用户外键
    @Column(name = "user_id")
    private Integer userId;
    //预约信息的外键（里面包含被预约的用户信息）
    @Column(name = "pub_id")
    private Integer pubId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPubId() {
        return pubId;
    }

    public void setPubId(Integer pubId) {
        this.pubId = pubId;
    }
}
