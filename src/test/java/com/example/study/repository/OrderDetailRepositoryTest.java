package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import net.minidev.json.JSONUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){

        OrderDetail orderDetail = new OrderDetail();

        //orderDetail.setItemId(1L);
        orderDetail.setOrderAt(LocalDateTime.now());
        //orderDetail.setUserId(4L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        Assert.assertNotNull(newOrderDetail);

    }

    @Test
    public void read(){

        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);

        orderDetail.ifPresent(System.out::println);

    }
}
