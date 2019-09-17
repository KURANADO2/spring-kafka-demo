package com.kuranado.producer;

/**
 * @Author: Xinling Jing
 * @Date: 2019-09-16 15:24
 */
public interface KafkaProducer {

    void sendMessage(String key, String msg);
}
