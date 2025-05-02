package com.truper.prueba.repository;

import com.truper.prueba.entity.StoreDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoreRepository extends JpaRepository<StoreDO, Long> {
}
