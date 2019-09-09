package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String content;

    // LAZY = 지연로딩, EAGER = 즉시로
    // LAZY = select * from item where id = ?
    // EAGER = 연관관계가 설정된 모든 테이블끼리 조인이됨 -> 성능저하 (1 : 1 관계나 하나의 데이터만나오는 경우에만 쓸것)
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
