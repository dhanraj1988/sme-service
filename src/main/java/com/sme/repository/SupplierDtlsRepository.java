package com.sme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sme.entity.SupplierDetails;

public interface SupplierDtlsRepository  extends CrudRepository<SupplierDetails, Long>{

	List<SupplierDetails> findBySupplierName(String supplierName);
}
