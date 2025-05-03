package com.truper.prueba.service;

import com.truper.prueba.TO.OrderTO;

import java.util.List;

public interface IOrderService {

  OrderTO saveOrder(OrderTO orderTO);

  List<OrderTO> getAllOrders();

  OrderTO getOrderById(Long id);

}
