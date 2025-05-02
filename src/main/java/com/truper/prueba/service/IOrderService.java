package com.truper.prueba.service;

import com.truper.prueba.TO.OrderTO;

import java.util.List;

public interface IOrderService {

  public OrderTO saveOrder(OrderTO orderTO);

  public List<OrderTO> getAllOrders();

  public OrderTO getOrderById(Long id);

}
