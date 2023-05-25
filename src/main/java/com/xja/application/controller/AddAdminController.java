package com.xja.application.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.xja.application.config.FastDFSClient;

import com.xja.application.pojo.Admins;
import com.xja.application.service.AdminsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admins")
@CrossOrigin
public class AddAdminController {


    @Resource
    private AdminsService adminsService;


    @PostMapping("/add")
    public R add(Admins admins){
        boolean save = adminsService.save(admins);


        return null;
    }

    @PostMapping("/uploadImg")
    public R uploadImg(MultipartFile file) {
        System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());
        String uploadServerAddress = "http://192.168.80.83/";

        FastDFSClient fastDFSClient = null;
        String originalFilename = file.getOriginalFilename();

        try {
            fastDFSClient = new FastDFSClient("classpath:fdfs_client.conf");
            String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String fileId = fastDFSClient.uploadFile(file.getBytes(), substring);
            String uploadUrl = uploadServerAddress + fileId;
            R r = new R();
            r.setCode(100);
            r.setMsg(uploadUrl);
            return r;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
