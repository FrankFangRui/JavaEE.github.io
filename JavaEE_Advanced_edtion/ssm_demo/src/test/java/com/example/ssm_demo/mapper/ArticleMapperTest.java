package com.example.ssm_demo.mapper;

import com.example.ssm_demo.entity.Articleinfo;
import com.example.ssm_demo.entity.viewobject.ArticleinfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 方锐
 * @since 2023/5/9 20:51
 */
@SpringBootTest
class ArcticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void getById() {
        ArticleinfoVO articleinfoVO = articleMapper.getById(1);
        System.out.println(articleinfoVO);
    }
}