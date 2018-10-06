package com.sme.service;

import java.util.ArrayList;
import java.util.List;

import com.sme.controller.StockCategoryInfo;
import com.sme.controller.StockDetailsInfo;
import com.sme.controller.StoreDetailsInfo;
import com.sme.controller.UserLoginInfo;
import com.sme.entity.PurchaseInwardVO;
import com.sme.entity.PurchaseOrderVO;
import com.sme.entity.CustomerDetails;
import com.sme.entity.SupplierDetails;
import com.sme.entity.UserDetails;

public interface ISmeService {
	/*
	 * List<Article> getAllArticles(); Article getArticleById(long articleId);
	 * 
	 * void updateArticle(Article article); void deleteArticle(int articleId);
	 */
	boolean addStore(StoreDetailsInfo storeDetailsInfo);

	boolean checkLogin(UserLoginInfo article);

	UserDetails addUser(UserDetails charts);
     List<UserDetails> getActiveCompanyDetails(String companyName,String supplierType);
     List<SupplierDetails> getSupplierList(String supplierName);
     boolean addSupplier(SupplierDetails supplierDtl);
     boolean addCustomer(CustomerDetails supplierDtl);
	StockDetailsInfo addStock(StockDetailsInfo stockDetailsInfo);


	PurchaseInwardVO addPurchaseInward(PurchaseInwardVO purchaseInwardVO);

	StockCategoryInfo addStockCategory(StockCategoryInfo stockCategoryInfo);

	List<StockCategoryInfo> getStockCategorywithStock();

	StockDetailsInfo addStore(StockDetailsInfo stockDetailsInfo);

	PurchaseOrderVO addPurchaseOrder(PurchaseOrderVO purchaseOrderVO);

	List<CustomerDetails> getCustomerList(String customerName);
}
