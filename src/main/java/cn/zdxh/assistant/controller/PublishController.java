package cn.zdxh.assistant.controller;

import cn.zdxh.assistant.entity.Publish;
import cn.zdxh.assistant.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PublishController {
    @Autowired
    private PublishService publishService;

    //上传发布树洞的，返回图片地址
    @ResponseBody
    @RequestMapping(value = "/upload",method =RequestMethod.POST )
    public String uploadPublishPicture(@RequestParam("pic") MultipartFile multipartFile){
        return publishService.uploadPublishPicture(multipartFile);
    }

    //发布信息
    @ResponseBody
    @RequestMapping(value = "/pub",method = RequestMethod.POST)
    public String insertPublish(@RequestBody Publish publish){
        publishService.insertPublish(publish);
        return "发布信息成功";
    }

    //查询已经发布的信息(未预约)
    @ResponseBody
    @RequestMapping(value = "/pubs/{startPage}/{sizePage}",method = RequestMethod.GET)
    public Page<Publish> findAllPublishs(@PathVariable("startPage") int startPage, @PathVariable("sizePage") int sizePage){
        return publishService.findAllPublishs(startPage,sizePage);
    }
}
