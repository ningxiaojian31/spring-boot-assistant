package cn.zdxh.assistant.pojo;


public class OrderCustomer {
   //对方的预约信息
    private UserCustomer user;
    //发布的信息
    private PublishCustomer publish;

    public UserCustomer getUser() {
        return user;
    }

    public void setUser(UserCustomer user) {
        this.user = user;
    }

    public PublishCustomer getPublish() {
        return publish;
    }

    public void setPublish(PublishCustomer publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "OrderCustomer{" +
                "user=" + user +
                ", publish=" + publish +
                '}';
    }
}
