package com.truper.prueba.service.impl;

import com.truper.prueba.TO.OrderTO;
import com.truper.prueba.TO.ProductTO;
import com.truper.prueba.entity.OrderDO;
import com.truper.prueba.entity.StoreDO;
import com.truper.prueba.repository.IOrderRepository;
import com.truper.prueba.repository.IStoreRepository;
import com.truper.prueba.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {

  @Autowired
  private IOrderRepository orderRepository;

  @Autowired
  private IStoreRepository storeRepository;

  public OrderServiceImpl (IOrderRepository IOrderRepository) {
    IOrderRepository
  }

  @Override
  public OrderTO saveOrder(OrderTO orderTO) {
    StoreDO storeDO = storeRepository.findById(orderTO.getStoreId()).orElseGet(null);

    OrderDO orderDO = new OrderDO();
    if(Objects.nonNull(orderTO.getId())) {
      orderDO.setId(orderTO.getId());
    }
    orderDO.setDate(orderTO.getDate());
    orderDO.setStore(storeDO);
    orderDO.setTotal(calculateTotal(orderTO.getProducts()));
    orderRepository.save(orderDO);

    orderDO.setProductList(ProductServiceImpl.buildProductsDO(orderTO.getProducts(), orderDO));

    orderRepository.save(orderDO);
    orderTO.setId(orderDO.getId());
    return orderTO;
  }

  private BigDecimal calculateTotal(List<ProductTO> products) {
    double total = 0;
    if(!products.isEmpty()) {
      total = products.stream().map(productTO -> productTO.getPrice()).collect(Collectors.summingDouble(BigDecimal::doubleValue));
    }
    return new BigDecimal(total);
  }

  @Override
  public List<OrderTO> getAllOrders() {
    List<OrderDO> orderDOList = orderRepository.findAll();
    List<OrderTO> list = new ArrayList<>();

    if(!orderDOList.isEmpty()) {
      orderDOList.stream().forEach(orderDO -> list.add(buildOrderTO(orderDO)));
    }
    return list;
  }

  private static OrderTO buildOrderTO(OrderDO orderDO) {
    return new OrderTO(
      orderDO.getId(), orderDO.getDate(), orderDO.getTotal(), ProductServiceImpl.buildProductsTO(orderDO.getProductList()));
  }

  @Override
  public OrderTO getOrderById(Long id) {
    OrderDO orderDO = orderRepository.findById(id)
      .orElseThrow(() -> new NoSuchElementException("La orden con id " + id + "no existe"));

    return buildOrderTO(orderDO);
  }
}
