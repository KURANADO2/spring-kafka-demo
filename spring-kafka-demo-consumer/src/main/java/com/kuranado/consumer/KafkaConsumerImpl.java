package com.kuranado.consumer;

import com.kuranado.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author: Xinling Jing
 * @Date: 2019-09-16 15:41
 */
@Slf4j
@Component
public class KafkaConsumerImpl {

    private static Random random;

    static {
        random = new Random();
    }

    @KafkaListener(topics = {"#{'${kafka.testTopic}'}"})
    public void listenTestTopic(ConsumerRecord<String, String> consumerRecord) {
        // 处理消息
        try {
            log.info("开始处理消息...key:[{}],value:[{}],offset:[{}],timestamp:[{}],topic:[{}],partition:[{}],",
                consumerRecord.key(),
                consumerRecord.value(), consumerRecord.offset(), consumerRecord.timestamp(), consumerRecord.topic(),
                consumerRecord.partition());
            Thread.sleep(2000);
            if (random.nextBoolean()) {
                int a = 1 / 0;
            }
            log.info("处理消息完成.key:[{}]", consumerRecord.key());
        } catch (InterruptedException e) {
            log.error("线程休眠出现异常", e);
        } catch (BusinessException e) {
            log.error("消息处理出现业务异常", e);
        } catch (Exception e) {
            log.error("消息处理出现未知异常", e);
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
