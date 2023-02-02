package com.catchmind.admin.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Header<T>{
    private LocalDateTime transactionTime;
    private String resultCode;
    private T data;
    private String description;

    // 데이터가 없는 정상응답의 경우
    public static <T>Header<T> ok() {
        return (Header<T>)Header.builder().transactionTime(LocalDateTime.now())
                .resultCode("ok").description("정상").build();
    }

    // 데이터가 있는 정상 응답의 경우
    public static <T>Header<T> OK (T data) {
        return (Header<T>)Header.builder().transactionTime(LocalDateTime.now())
                .resultCode("OK").description("정상").data(data).build();
    }

    // 에러 응답
    public static <T>Header<T> ERROR(String description) {
        return (Header<T>)Header.builder().transactionTime(LocalDateTime.now())
                .resultCode("ERROR").description(description).build();
    }

    // 페이징 처리 정상응답


}
