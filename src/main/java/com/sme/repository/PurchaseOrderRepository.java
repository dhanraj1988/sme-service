package com.sme.repository;

import org.springframework.data.repository.CrudRepository;

import com.sme.entity.PurchaseOrderVO;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrderVO, Long>{

}
