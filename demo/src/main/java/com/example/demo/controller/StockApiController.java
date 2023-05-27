package com.example.demo.controller;

import com.example.demo.dto.StockResponseDto;
import com.example.demo.dto.StockResponseDto.ResponseDto.BodyDto.ItemsDto.ItemDto;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stock")
public class StockApiController {
    //private final StockService stockService;

    @Value("${stock.api.key}")
    private String stockApiKey;

    @Value("${stock.api.url}")
    private String stockApiUrl;

    @GetMapping("/update")
    public String updateStock() throws JsonProcessingException {
        String reqUrl = UriComponentsBuilder.fromUriString(stockApiUrl)
                .queryParam("resultType", "json")
                .queryParam("numOfRows", 10000)
                .queryParam("mrktCls", "KOSPI")
                .queryParam("pageNo", 1)
                .queryParam("beginBasDt", "20230525")
                .queryParam("serviceKey", stockApiKey)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        StockResponseDto responseDto = restTemplate.getForObject(reqUrl, StockResponseDto.class);

        assert responseDto != null;
        List<ItemDto> items = responseDto.getResponse().getBody().getItems().getItem();
//        for (ItemDto item : items) {
//            System.out.println(item.getBasDt());
//            System.out.println(item.getSrtnCd());
//            System.out.println(item.getIsinCd());
//            System.out.println(item.getItmsNm());
//            System.out.println(item.getMrktCtg());
//            System.out.println(item.getClpr());
//            System.out.println(item.getVs());
//            System.out.println(item.getFltRt());
//            System.out.println(item.getMkp());
//            System.out.println(item.getHipr());
//            System.out.println(item.getLopr());
//            System.out.println(item.getTrqu());
//            System.out.println(item.getTrPrc());
//            System.out.println(item.getLstgStCnt());
//            System.out.println(item.getMrktTotAmt());
//        }

        return "success";
    }
}
