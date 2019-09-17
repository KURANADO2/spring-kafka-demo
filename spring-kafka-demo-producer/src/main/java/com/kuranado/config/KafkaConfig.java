package com.kuranado.config;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Xinling Jing
 * @Date: 2019-09-16 15:28
 */
@Component
@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaConfig {

    private String testTopic;
}
