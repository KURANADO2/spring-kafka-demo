package com.kuranado.controller;

import com.alibaba.fastjson.JSON;

import com.kuranado.model.req.RequestModel;
import com.kuranado.model.res.ResponseModel;
import com.kuranado.producer.KafkaProducer;
import com.kuranado.result.JsonResult;


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xinling Jing
 * @Date: 2019-09-16 16:14
 */
@RestController
@Slf4j
public class KafkaTestController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/test")
    public JsonResult<ResponseModel> test(@RequestBody RequestModel requestModel) {

        kafkaProducer.sendMessage(requestModel.getVin().toString(), JSON.toJSONString(requestModel));

        ResponseModel responseModel = new ResponseModel();
        responseModel.setVin(requestModel.getVin());

        return new JsonResult<ResponseModel>(responseModel);
    }
}
