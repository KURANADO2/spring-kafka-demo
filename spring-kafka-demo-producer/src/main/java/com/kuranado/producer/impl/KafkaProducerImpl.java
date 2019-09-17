package com.kuranado.producer.impl;

import com.kuranado.config.KafkaConfig;
import com.kuranado.producer.KafkaProducer;

import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.common.PartitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Xinling Jing
 * @Date: 2019-09-16 15:24
 */
@Component
@Slf4j
public class KafkaProducerImpl implements KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private KafkaConfig kafkaConfig;

    @Override
    public void sendMessage(String key, String msg) {
        Integer partitionNum = getPartitionNum(kafkaConfig.getTestTopic(), key);
        kafkaTemplate.send(kafkaConfig.getTestTopic(), partitionNum, key, msg);
        log.info("消息发送成功,key:[{}],value:[{}]", key, msg);
    }

    private Integer getPartitionNum(String topic, String key) {
        List<PartitionInfo> partitions = kafkaTemplate.partitionsFor(topic);
        int numPartitions = partitions.size();
        int partitionNum = key.hashCode();
        partitionNum = partitionNum < 0 ? -1 * partitionNum : partitionNum;
        Integer num = partitionNum % numPartitions;
        return num;
    }
}
