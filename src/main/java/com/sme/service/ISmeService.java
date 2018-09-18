package com.sme.service;

import java.util.List;

import com.sme.controller.UserLoginInfo;
import com.sme.entity.CustomerDetails;
import com.sme.entity.SupplierDetails;
import com.sme.entity.UserDetails;

public interface ISmeService {
     /*List<Article> getAllArticles();
     Article getArticleById(long articleId);
     
     void updateArticle(Article article);
     void deleteArticle(int articleId);*/
	boolean checkLogin(UserLoginInfo article);
	UserDetails addUser(UserDetails charts);
     List<UserDetails> getActiveCompanyDetails(String companyName,String supplierType);
     List<SupplierDetails> getSupplierList(String supplierName);
     boolean addSupplier(SupplierDetails supplierDtl);
     boolean addCustomer(CustomerDetails supplierDtl);
}
