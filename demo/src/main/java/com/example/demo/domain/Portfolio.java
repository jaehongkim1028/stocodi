package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Portfolio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long portfolioId;

        @Column(name = "EMAIL")
        private String email;

        @Column(nullable = false)
        private Integer initialCash;

        @Column(nullable = false)
        private Integer currentCash;

        @Column(nullable = false)
        private Integer totalAsset;

        // 칼럼 추가 필요
        @Column(nullable = false)
        private String portfolioName;


//        public String getName() {
//                return portfolioName;
//        } Getter 사용

}
