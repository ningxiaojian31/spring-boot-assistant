package cn.zdxh.assistant.service;

import cn.zdxh.assistant.entity.Publish;
import cn.zdxh.assistant.repository.PublishRepository;
import cn.zdxh.assistant.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class PublishServiceImpl implements PublishService {
    @Autowired
    private PublishRepository publishRepository;
    //图片存储路径
    @Value("${file.uploadFolder}")
    public String uploadFolder;

    //服务器路径
    @Value("${server.path}")
    private String serverPath;

    //静态资源对外暴露的访问路径
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;


    @Override
    public String uploadPublishPicture(MultipartFile multipartFile) {
       return UploadUtils.uploadPicture(multipartFile,uploadFolder, serverPath,staticAccessPath);
    }
    @Override
    public void insertPublish(Publish publish) {
        publishRepository.save(publish);
    }

    @Override
    public Page<Publish> findAllPublishs(int startPage, int sizePage) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(startPage,sizePage,sort);
        Page<Publish> page = publishRepository.findAll(pageable);
        return page;
    }

    @Override
    public void deletePublish(Integer id) {
        publishRepository.deleteById(id);
    }
}
