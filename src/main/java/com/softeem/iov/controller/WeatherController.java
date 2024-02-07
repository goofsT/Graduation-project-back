package com.softeem.iov.controller;
import com.softeem.iov.entity.Weather;
import com.softeem.iov.service.impl.WeatherService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;
    @RequestMapping("/getWeather")
    public ResponseData getWeather() throws IOException {
        //获取天气数据
        List<Weather> weathers = weatherService.getWeather("101200101");
        return ResponseData.success(weathers);
    }


}
