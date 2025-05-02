package com.truper.prueba.repository;

import com.truper.prueba.entity.OrderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDO, Long> {
}
