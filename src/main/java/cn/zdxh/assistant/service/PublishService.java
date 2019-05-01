package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.Publish;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PublishService {
    //上传图片
    public String uploadPublishPicture(MultipartFile multipartFile);
    //发布信息
    public void insertPublish(Publish publish);
    //查看已经的信息
    public Page<Publish> findAllPublishs(int startPage, int sizePage);
    //删除发布
    public void deletePublish(Integer id);
}
