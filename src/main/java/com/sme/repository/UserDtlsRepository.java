package com.sme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sme.entity.UserDetails;

public interface UserDtlsRepository extends CrudRepository<UserDetails, Long>  {
//    List<Article> findByTitle(String title);
//    List<Article> findDistinctByCategory(String category);
    //List<Charts> findByTitleAndCategory(String company_name, String password);
	
	List<UserDetails> findByCompanyName(String companyName, Boolean inactive);
	List<UserDetails> findByCompanyNameAndPasswordAndInvalid(String companyName, String password, Boolean invalid);
	List<UserDetails> findByCompanyNameAndInvalid(String companyName, Boolean invalid);
	List<UserDetails> findByCompanyNameAndSupplierTypeAndInvalid(String companyName,String supplierType, Boolean invalid);
	List<UserDetails> findBySupplierTypeAndInvalid(String supplierType,  Boolean invalid);
	List<UserDetails> findByinvalid(Boolean invalid);
}
