package com.truper.prueba.service.impl;

import com.truper.prueba.TO.ProductTO;
import com.truper.prueba.entity.OrderDO;
import com.truper.prueba.entity.ProductDO;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl {

  public static List<ProductDO> buildProductsDO(List<ProductTO> productList, OrderDO order) {
    List<ProductDO> doList = new ArrayList<>();
    if(!productList.isEmpty()) {
      productList.stream().forEach(productTO -> {
        doList.add(buildProductDO(order, productTO));
      });
    }
    return doList;
  }

  private static ProductDO buildProductDO(OrderDO order, ProductTO productTO) {
    return new ProductDO(productTO.getCode(), productTO.getDescrption(), productTO.getPrice(), order);
  }

  public static List<ProductTO> buildProductsTO(List<ProductDO> productList) {
    List<ProductTO> list = new ArrayList<>();

    if(!productList.isEmpty()) {
      productList.stream().forEach(productDO -> list.add(buildProductTO(productDO)));
    }

    return list;
  }

  private static ProductTO buildProductTO(ProductDO productDO) {
    return new ProductTO(productDO.getId(), productDO.getCode(), productDO.getDescription(), productDO.getPrice());
  }
}
