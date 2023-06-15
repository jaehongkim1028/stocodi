package com.example.demo.service;

import com.example.demo.domain.Stock;
import com.example.demo.dto.StockResponseDto;
import com.example.demo.repository.StockApiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockApiService {
    //repository
    private StockApiRepository stockApiRepository;

    //constructor
    public StockApiService(StockApiRepository stockApiRepository) {
        this.stockApiRepository = stockApiRepository;
    }

    // get stock list from param and save all
    public void saveItems(List<StockResponseDto.ResponseDto.BodyDto.ItemsDto.ItemDto> items, String date){
        for (StockResponseDto.ResponseDto.BodyDto.ItemsDto.ItemDto item : items) {
           // item의 ItmsNm Clpr Mkp Hipr Lopr Trqu 를 가져와서 entity로 만든 후 repository에 저장
            Stock stock = Stock.builder()
                    .stockName(item.getItmsNm())
                    .stockEndPrice(item.getClpr())
                    .stockMaxPrice(item.getHipr())
                    .stockMinPrice(item.getLopr())
                    .stockStartPrice(item.getMkp())
                    .stockDate(date)
                    .stockQuantity(item.getTrqu())
                    .build();
            stockApiRepository.save(stock);
        }
    }

}
