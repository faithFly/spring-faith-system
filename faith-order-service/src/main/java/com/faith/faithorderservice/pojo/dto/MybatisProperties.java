package com.faith.faithorderservice.pojo.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mybatis")
public class MybatisProperties {
    //@ApiModelProperty("搜索指定包别名")
    private String typeAliasesPackage;
    //@ApiModelProperty("配置mapper的扫描，找到所有的mapper.xml映射文件")
    private String mapperLocations;
    //@ApiModelProperty("加载全局的配置文件")
    private String configLocation;
}
