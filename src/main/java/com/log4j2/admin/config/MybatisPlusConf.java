package com.log4j2.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @描述: mybatis配置
 * @制作人: jian
 * @时间: 2019-08-0922:19
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.log4j2.admin.mapper*")
public class MybatisPlusConf {
}
