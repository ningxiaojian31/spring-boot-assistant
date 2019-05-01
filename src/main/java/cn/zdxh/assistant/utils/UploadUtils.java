package cn.zdxh.assistant.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtils {

    /**
     * 由于不能用@Value直接给static的变量注入值，只能传值过来
     * @param uploadFolder、serverPath、staticAccessPath
     */

    public static String uploadPicture(MultipartFile multipartFile,String uploadFolder, String serverPath,String staticAccessPath){

        //获得原始名字
        String originalFilename = multipartFile.getOriginalFilename();
        //后缀名
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //前缀名
        String prefixName = UUID.randomUUID().toString();
        //拼接新的文件名
        String fileName=prefixName+suffixName;
        //本地路径名
        String pathName=uploadFolder+fileName;//文件上传的最大值默认为10M
        File file=new File(pathName);
        try {
            multipartFile.transferTo(file);//一个方法即可完成文件的上传
            return serverPath+staticAccessPath+fileName;//文件上传成功即返回图片访问路径
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "文件上传失败";
    }
}
