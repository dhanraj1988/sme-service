package com.sme.repository;

import org.springframework.data.repository.CrudRepository;

import com.sme.controller.StockCategoryInfo;

public interface StockCategoryRepository extends CrudRepository<StockCategoryInfo, Long>{

}
