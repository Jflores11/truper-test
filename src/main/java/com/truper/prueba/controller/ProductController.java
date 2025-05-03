package com.truper.prueba.controller;

import com.truper.prueba.TO.ProductTO;
import com.truper.prueba.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private IProductService productService;

  @RequestMapping(name = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<ProductTO> updateProduct(@RequestBody ProductTO productTO) {
    return ResponseEntity.ok(productService.saveProduct(productTO));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductTO> getProductById(@PathVariable Long id) {
    return ResponseEntity.ok(productService.getProductById(id));
  }

  @GetMapping
  public ResponseEntity<List<ProductTO>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }

}
