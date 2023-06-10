package com.example.demo.service;

import com.example.demo.domain.HoldingStock;
import com.example.demo.repository.HoldingStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class HoldingStockService {

    private final HoldingStockRepository holdingStockRepository;


}
