package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "user") //동일하기 때문에 굳이 선언하지 않아도 됨
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "account") //동일하기 때문에 굳이 선언 안해도 됨
    private String account;
    private String email;
    private String phoneNumber; //자동으로 camel case 를 snake case 로 변환해줌 굳이 phone_number 로 안해도됨
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // 1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // Order_detail의 변수명과 동일하게 매핑
    private List<OrderDetail> orderDetailList;
}
