package com.truper.prueba.service.impl;

import com.truper.prueba.TO.StoreTO;
import com.truper.prueba.entity.StoreDO;
import com.truper.prueba.repository.IStoreRepository;
import com.truper.prueba.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements IStoreService {

  @Autowired
  private IStoreRepository storeRepository;


  @Override
  public StoreDO getStoreDOById(Long id) {
    return storeRepository.findById(id).orElseGet(null);
  }

  public static StoreTO buildStoreTO(StoreDO storeDO) {
    return new StoreTO(storeDO.getId(), storeDO.getName());
  }

}
