package com.xja.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xja.application.pojo.Admins;
import com.xja.application.service.AdminsService;
import com.xja.application.mapper.AdminsMapper;
import org.springframework.stereotype.Service;

/**
* @author 31651
* @description 针对表【admins】的数据库操作Service实现
* @createDate 2023-05-25 19:49:11
*/
@Service
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins>
    implements AdminsService{

}




