package com.sme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sme.entity.CustomerDetails;
import com.sme.entity.UserDetails;

public interface CustomerDtlsRepository extends CrudRepository<CustomerDetails, Long>{
	List<UserDetails> findByCustomerName(String customerName);
}
