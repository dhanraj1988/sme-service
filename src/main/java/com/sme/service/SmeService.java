package com.sme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sme.controller.UserLoginInfo;
import com.sme.entity.CustomerDetails;
import com.sme.entity.SupplierDetails;
import com.sme.entity.UserDetails;
import com.sme.repository.CustomerDtlsRepository;
import com.sme.repository.SupplierDtlsRepository;
import com.sme.repository.UserDtlsRepository;
@Service
public class SmeService implements ISmeService {
	@Autowired
	private UserDtlsRepository userDtlsRepository;
	
	@Autowired
	private SupplierDtlsRepository supplierDtlsRepository;
	
	@Autowired
	private CustomerDtlsRepository customerDtlsRepository;
	
	/*@Autowired
	private UserLoginRepository userLoginRepository;*/
	/*@Override
	public Article getArticleById(long articleId) {
		Article obj = articleRepository.findById(articleId).get();
		return obj;
	}*/	
	/*@Override
	public List<Article> getAllArticles(){
		List<Article> list = new ArrayList<>();
		articleRepository.findAll().forEach(e -> list.add(e));
		return list;
	}*/
	@Override
	public synchronized boolean checkLogin(UserLoginInfo article){
	   //List<UserLogin> list = userLoginRepository.findByCompanyNameAndPassword(article.getUserName(), article.getPassword(), false); 	
		List<UserDetails> list = userDtlsRepository.findByCompanyNameAndPasswordAndInvalid(article.getUserName(), article.getPassword(), false);
       if (list.size() > 0) {
    	   return true;
       } else {
    	   //articleRepository.save(article);
    	   return false;
       }
	}
	@Override
	public synchronized List<UserDetails> getActiveCompanyDetails(String companyName,String supplierType){
		List<UserDetails> usr_list = new ArrayList<>();
		if((null!=companyName && !companyName.isEmpty()) && (null!=supplierType && !supplierType.isEmpty())){
			System.out.println("Inside Both not null");
			usr_list = userDtlsRepository.findByCompanyNameAndSupplierTypeAndInvalid(companyName, supplierType, false);
		}else if((null!=companyName && !companyName.isEmpty()) && (null==supplierType || supplierType.equals(""))){
			System.out.println("Inside Both company not null");
			usr_list = userDtlsRepository.findByCompanyNameAndInvalid(companyName, false);
		}else if((null!=supplierType && !supplierType.isEmpty()) && (null==companyName || companyName.equals(""))){
			System.out.println("Inside Both supplier not null");
			usr_list = userDtlsRepository.findBySupplierTypeAndInvalid(supplierType, false); 	
		}else if((null==supplierType || supplierType.equals("")) && (null==companyName || companyName.equals(""))){
			System.out.println("Inside Both null");
			usr_list = userDtlsRepository.findByinvalid(false);
		}
	   
       return usr_list;
	}
	@Override
	public synchronized UserDetails addUser(UserDetails charts){
	 /*  List<Article> list = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory()); 	
       if (list.size() > 0) {
    	   return false;
       } else {*/
		UserDetails  usrDtl = userDtlsRepository.save(charts);
    	   return usrDtl;
       //}
	}
	
	@Override
	public synchronized boolean addSupplier(SupplierDetails supplierDtl){
	 /*  List<Article> list = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory()); 	
       if (list.size() > 0) {
    	   return false;
       } else {*/
		supplierDtlsRepository.save(supplierDtl);
    	   return true;
       //}
	}
	/*@Override
	public void updateArticle(Article article) {
		articleRepository.save(article);
	}
	@Override
	public void deleteArticle(int articleId) {
		articleRepository.delete(getArticleById(articleId));
	}*/
	
	@Override
	public synchronized boolean addCustomer(CustomerDetails customerDetails){
	 /*  List<Article> list = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory()); 	
       if (list.size() > 0) {
    	   return false;
       } else {*/
		customerDtlsRepository.save(customerDetails);
    	   return true;
       }
}
