package com.truper.prueba.service;

import com.truper.prueba.TO.ProductTO;

import java.util.List;

public interface IProductService {

  ProductTO saveProduct(ProductTO productTO);

  List<ProductTO> getAllProducts();

  ProductTO getProductById(Long id);

}
