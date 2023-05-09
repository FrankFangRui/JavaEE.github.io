package com.example.ssm_demo.mapper;

import com.example.ssm_demo.entity.viewobject.ArticleinfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 方锐
 * @since 2023/5/9 20:36
 */
@Mapper
public interface ArticleMapper {
    ArticleinfoVO getById(@Param("id") Integer id);
}
