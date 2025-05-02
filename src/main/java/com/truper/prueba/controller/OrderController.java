package com.truper.prueba.controller;

import com.truper.prueba.TO.OrderTO;
import com.truper.prueba.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  private IOrderService orderService;


  @GetMapping
  public ResponseEntity<List<OrderTO>> getAllOrders() {
    return ResponseEntity.ok(orderService.getAllOrders());
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderTO> getOrderById(@PathVariable Long id) {
    return ResponseEntity.ok(orderService.getOrderById(id));
  }

  @PostMapping
  public ResponseEntity<OrderTO> createOrder(@RequestBody OrderTO orderTO) {
    return new ResponseEntity<>(orderService.saveOrder(orderTO), HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public ResponseEntity<OrderTO> updateOrder(@RequestBody OrderTO orderTO) {
    return ResponseEntity.ok(orderService.saveOrder(orderTO));
  }

}
