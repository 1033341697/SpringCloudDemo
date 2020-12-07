package com.chiliuliu.service.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * oss相关操作的工具类
 *
 * @author Administrator
 */
@Component
public class OSSUtils {
    private static Logger logger = LoggerFactory.getLogger(OSSUtils.class);

    private static String endPoint;
    private static String accessId;
    private static String accessKey;
    private static String bucket;

    @Value("${oss.endpoint}")
    private void setEndPoint(String endPoint) {
        OSSUtils.endPoint = endPoint;
    }

    @Value("${oss.accessId}")
    private void setAccessId(String accessId) {
        OSSUtils.accessId = accessId;
    }

    @Value("${oss.accessKey}")
    private void setAccessKey(String accessKey) {
        OSSUtils.accessKey = accessKey;
    }

    @Value("${oss.bucket}")
    private void setBucket(String bucket) {
        OSSUtils.bucket = bucket;
    }

    /**
     * 创建模拟文件
     *
     * @param folder 模拟文件夹名如"qj_nanjing/"
     * @return 文件夹名
     */
    public String createFolder(String folder) {
        //获取客户端实例
        OSSClient client = getInstance();
        // 判断文件夹是否存在，不存在则创建
        if (!client.doesObjectExist(bucket, folder)) {
            // 创建文件夹
            client.putObject(bucket, folder, new ByteArrayInputStream(new byte[0]));
            logger.info("创建文件夹成功");
            // 得到文件夹名
            OSSObject object = client.getObject(bucket, folder);
            folder = object.getKey();
        }
        client.shutdown();
        return folder;
    }

    /**
     * 上传文件
     * 上传文件到OSS指定位置
     * 上传文件名采用当前文件的文件名
     *
     * @param file 上传文件
     * @param url  上传到oss服务器上的地址
     * @return 文件在服务器上的url
     */
    public String uploadFile(File file, String url) throws FileNotFoundException {
        //上传文件名采用合同文件名
        ObjectMetadata meta = new ObjectMetadata();
        InputStream content = new FileInputStream(file);
        meta.setContentLength(file.length());
        OSSClient client = getInstance();
        PutObjectResult putObjectResult = client.putObject(bucket, url + "/" + file.getName(), content, meta);
        String result = url + "/" + file.getName();
        logger.info("OSS上传文件：" + file.getName());
        client.shutdown();
        return result;
    }

    /**
     * 上传文件
     * 上传文件到OSS指定位置
     * 上传文件名重新指定文件名
     *
     * @param file 上传文件
     * @param url  上传到oss服务器上的地址
     * @param name 指定的文件名
     * @return 文件的url
     */
    public String uploadFile(File file, String url, String name) throws FileNotFoundException {
        //上传文件名采用合同文件名
        ObjectMetadata meta = new ObjectMetadata();
        InputStream content = new FileInputStream(file);
        meta.setContentLength(file.length());
        OSSClient client = getInstance();
        PutObjectResult putObjectResult = client.putObject(bucket, url + "/" + name, content, meta);
        String result = url + "/" + name;
        logger.info("OSS上传文件：" + name);
        client.shutdown();
        return result;
    }

    /**
     * 上传文件
     * 上传文件到OSS指定位置
     * 上传文件名采用当前文件的文件名
     *
     * @param multipartFile 上传文件流
     * @param url           上传到oss服务器上的地址
     * @return 文件在服务器上的url
     */
    public String uploadFile(MultipartFile multipartFile, String url) throws IOException {
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(multipartFile.getSize());
        OSSClient client = getInstance();
        client.putObject(bucket, url + "/" + multipartFile.getOriginalFilename(), multipartFile.getInputStream(), meta);
        client.shutdown();
        String result = url + "/" + multipartFile.getOriginalFilename();
        logger.info("OSS上传文件：" + multipartFile.getOriginalFilename());
        return result;
    }


    /**
     * 上传文件
     * 上传文件到OSS指定位置
     * 上传文件名采用当前文件的文件名
     *
     * @param multipartFile 上传文件
     * @param url           上传到oss服务器上的地址
     * @return 文件在服务器上的预览路径
     */
    public String uploadFileReturnHttp(MultipartFile multipartFile, String url) throws IOException {
        //上传文件名采用合同文件名
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(multipartFile.getSize());
        OSSClient client = getInstance();
        PutObjectResult putObjectResult = client.putObject(bucket, url + "/" + multipartFile.getOriginalFilename(), multipartFile.getInputStream(), meta);
        String result = "https://" + OSSUtils.bucket + "." + OSSUtils.endPoint + "/" + url + "/" + multipartFile.getOriginalFilename();
        logger.info("OSS上传文件：" + multipartFile.getOriginalFilename());
        client.shutdown();
        return result;
    }


    /**
     * 上传文件
     * 上传文件到OSS指定位置
     * 上传文件名采用当前文件的文件名
     *
     * @param file 上传文件
     * @param url  上传到oss服务器上的地址
     * @return 文件在服务器上的预览路径
     */
    public String uploadFileReturnHttp(File file, String url) throws FileNotFoundException {
        //上传文件名采用合同文件名
        ObjectMetadata meta = new ObjectMetadata();
        InputStream content = new FileInputStream(file);
        meta.setContentLength(file.length());
        OSSClient client = getInstance();
        PutObjectResult putObjectResult = client.putObject(bucket, url + "/" + file.getName(), content, meta);
        String result = "https://" + OSSUtils.bucket + "." + OSSUtils.endPoint + "/" + url + "/" + file.getName();
        logger.info("OSS上传文件：" + file.getName());
        client.shutdown();
        return result;
    }


    /**
     * 下载文件
     *
     * @param ossFilePath 文件在oss上的url
     * @return 下载文件的文件流
     */
    public InputStream downloadFile(String ossFilePath) {
        // 创建OSSClient实例
        OSSClient ossClient = getInstance();
        InputStream objectContent;
        try {
            OSSObject object = ossClient.getObject(bucket, ossFilePath);
            objectContent = object.getObjectContent();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ossClient.shutdown();
        }
        return objectContent;
    }

    /**
     * 删除某个Object
     *
     * @param bucketUrl
     * @return
     */
    public boolean deleteObject(String bucketUrl) {
        // 创建OSSClient实例
        OSSClient ossClient = getInstance();
        try {
            // 删除Object.
            ossClient.deleteObject(bucket, bucketUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ossClient.shutdown();
        }
        return true;
    }

    /**
     * 删除多个Object
     *
     * @param bucketUrls
     * @return
     */
    public boolean deleteObjects(List<String> bucketUrls) {
        // 创建OSSClient实例
        OSSClient ossClient = getInstance();
        try {
            // 删除Object.
            DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(new DeleteObjectsRequest(bucket).withKeys(bucketUrls));
            List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ossClient.shutdown();
        }
        return true;
    }

    /**
     * 根据文件夹路径找出所有文件
     *
     * @param prefix 文件key所包含的前缀
     * @return
     */
    public List<String> getFileAllContent(String prefix) {
        OSSClient ossClient = getInstance();
        ObjectListing listing = ossClient.listObjects(bucket, prefix);
        ArrayList<String> list = new ArrayList<String>();
        // 遍历所有Object:目录下的文件
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            String key = objectSummary.getKey();
            list.add(key);
        }
        ossClient.shutdown();
        return list;
    }


    /**
     * OSSClient
     *
     * @return
     */
    public OSSClient getInstance() {
        OSSClient ossClient = new OSSClient(endPoint, accessId, accessKey);
        return ossClient;
    }


    public InputStream downloadFile(String ossFilePath, OSSClient ossClient) {
        // 创建OSSClient实例
        InputStream objectContent;
        try {
            OSSObject object = ossClient.getObject(bucket, ossFilePath);
            objectContent = object.getObjectContent();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return objectContent;
    }


    public boolean isExist(String path) {
        OSSClient ossClient = getInstance();
        boolean flag = ossClient.doesObjectExist(bucket, path);
        return flag;
    }

}
