package com.example.demo.controller;

import com.example.demo.dto.StockResponseDto;
import com.example.demo.dto.StockResponseDto.ResponseDto.BodyDto.ItemsDto.ItemDto;
import com.example.demo.service.StockApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stock")
public class StockApiController {
    private final StockApiService stockApiService;

    @Value("${stock.api.key}")
    private String stockApiKey;

    @Value("${stock.api.url}")
    private String stockApiUrl;

    @GetMapping("/update")
    public String updateStock() throws JsonProcessingException {
        LocalDate date = LocalDate.parse("20230401", DateTimeFormatter.ofPattern("yyyyMMdd"));
           String sdate = date.toString().replaceAll("-", "");

        // date를 80일까지 증가시킴
        for (int i = 0; i < 80; i++) {
            String reqUrl = UriComponentsBuilder.fromUriString(stockApiUrl)
                    .queryParam("numOfRows", 10000)
                    .queryParam("mrktCls", "KOSPI")
                    .queryParam("pageNo", 1)
                    .queryParam("beginBasDt", sdate)
                    .queryParam("serviceKey", stockApiKey)
                    .queryParam("resultType", "json")
                    .toUriString();

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            StockResponseDto responseDto = restTemplate.getForObject(reqUrl, StockResponseDto.class);

            assert responseDto != null;
            List<ItemDto> items = responseDto.getResponse().getBody().getItems().getItem();
            stockApiService.saveItems(items, sdate);

            date = date.plusDays(1);
            sdate = date.toString().replaceAll("-", "");
        }

        return "success";
    }
}
