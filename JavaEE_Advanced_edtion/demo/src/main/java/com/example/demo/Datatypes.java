package com.example.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author 方锐
 * @since 2023/4/29 20:01
 */
@Component
@ConfigurationProperties("dbtypes")
@Data
public class Datatypes {
    private List<String> name;// 这里的集合名字要和yml文件中的集合名字一样

}
