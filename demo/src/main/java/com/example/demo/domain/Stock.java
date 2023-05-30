package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Stock extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID")
    private Long stockId;

    @Column(length = 100, nullable = false)
    private String stockName; // 종목의 명칭

    private String basDt; //  기준일자

    private Integer clpr; // 정규시장의 매매시간종료시까지 형성되는 최종가격

    private Integer mkp; // 정규시장의 매매시간개시후 형성되는 최초가격

    private Integer hipr; // 하루 중 가격의 최고치

    private Integer lopr; // 하루 중 가격의 최저치

    private Integer trqu; // 체결수량의 누적 합계


    // Builder를 통한 초기화
    @Builder
    public Stock(String stockName) {
        this.stockName = stockName;
    }


    public void update() {
    }


}