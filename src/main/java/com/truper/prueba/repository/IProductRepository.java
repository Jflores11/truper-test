package com.truper.prueba.repository;

import com.truper.prueba.entity.ProductDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductDO, Long> {
}
