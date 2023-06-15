package com.example.demo.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class StockResponseDto {
    private ResponseDto response;

    // Getter, Setter

    @Getter
    public static class ResponseDto {
        private HeaderDto header;
        private BodyDto body;

        // Getter, Setter

        @Getter
        public static class HeaderDto {
            private String resultCode;
            private String resultMsg;

            // Getter, Setter
        }

        @Getter
        public static class BodyDto {
            private int numOfRows;
            private int pageNo;
            private int totalCount;
            private ItemsDto items;

            // Getter, Setter

            @Getter
            public static class ItemsDto {
                private List<ItemDto> item;

                // Getter, Setter

                @Getter
                public static class ItemDto {
                    private String basDt;
                    private String srtnCd;
                    private String isinCd;
                    private String itmsNm;
                    private String mrktCtg;
                    private String clpr;
                    private String vs;
                    private String fltRt;
                    private String mkp;
                    private String hipr;
                    private String lopr;
                    private String trqu;
                    private String trPrc;
                    private String lstgStCnt;
                    private String mrktTotAmt;

                    // Getter, Setter
                }
            }
        }
    }
}
