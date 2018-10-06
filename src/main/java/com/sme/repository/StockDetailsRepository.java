package com.sme.repository;

import org.springframework.data.repository.CrudRepository;

import com.sme.controller.StockDetailsInfo;


public interface StockDetailsRepository extends CrudRepository<StockDetailsInfo, Long>{
	
	
}
