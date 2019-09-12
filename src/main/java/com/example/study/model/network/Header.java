package com.example.study.model.network;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@JsonInclude 를 이용하여 어떠한 값들만 포함할건지 설정가능
public class Header<T> {
    //api 통신시간
    @JsonProperty("transaction_time") //어노테이션으로 카멜케스로 바꿔줄수도 있음 근데 일일히 하기 귀찮으니 properties에 설정
    private String transactionTime;

    //api 응답코드
    private String resultCode;

    //api 부가설명
    private String description;

    private T data;
}
