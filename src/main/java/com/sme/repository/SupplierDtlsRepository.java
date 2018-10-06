package com.sme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sme.entity.SupplierDetails;
import com.sme.entity.UserDetails;

public interface SupplierDtlsRepository  extends CrudRepository<SupplierDetails, Long>{

	List<SupplierDetails> findBySupplierName(String supplierName);
}
