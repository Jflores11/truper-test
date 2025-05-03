package com.truper.prueba.service.impl;

import com.truper.prueba.TO.ProductTO;
import com.truper.prueba.entity.OrderDO;
import com.truper.prueba.entity.ProductDO;
import com.truper.prueba.repository.IProductRepository;
import com.truper.prueba.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements IProductService {

  @Autowired
  private IProductRepository productRepository;

  @Override
  public ProductTO saveProduct(ProductTO productTO) {
    ProductDO productDO = getProductDO(productTO.getId());

    productDO.setCode(Objects.nonNull(productTO.getCode()) ? productTO.getCode() : productDO.getCode());
    productDO.setDescription(Objects.nonNull(productTO.getDescription()) ? productTO.getDescription() : productDO.getDescription());
    productDO.setPrice(Objects.nonNull(productTO.getPrice()) ? productTO.getPrice() : productDO.getPrice());

    productRepository.save(productDO);
    return productTO;
  }

  @Override
  public List<ProductTO> getAllProducts() {
    List<ProductDO> list = productRepository.findAll();
    return buildProductsTO(list);
  }

  @Override
  public ProductTO getProductById(Long id) {
    return buildProductTO(getProductDO(id));
  }

  public static List<ProductDO> buildProductsDO(List<ProductTO> productList, OrderDO order) {
    List<ProductDO> doList = new ArrayList<>();
    if(!productList.isEmpty()) {
      productList.stream().forEach(productTO -> doList.add(buildProductDO(order, productTO)));
    }
    return doList;
  }

  private static ProductDO buildProductDO(OrderDO order, ProductTO productTO) {
    return new ProductDO(productTO.getCode(), productTO.getDescription(), productTO.getPrice(), order);
  }

  public static List<ProductTO> buildProductsTO(List<ProductDO> productList) {
    List<ProductTO> list = new ArrayList<>();

    if(!productList.isEmpty()) {
      productList.stream().forEach(productDO -> list.add(buildProductTO(productDO)));
    }

    return list;
  }

  private ProductDO getProductDO(Long id) {
    ProductDO productDO = productRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("El producto con id " + id + " no existe."));
    return productDO;
  }

  private static ProductTO buildProductTO(ProductDO productDO) {
    return new ProductTO(productDO.getId(), productDO.getCode(), productDO.getDescription(),
      productDO.getPrice(), productDO.getOrder().getId());
  }

}
