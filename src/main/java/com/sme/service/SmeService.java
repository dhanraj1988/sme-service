package com.sme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.sme.controller.StockCategoryInfo;
import com.sme.controller.StockDetailsInfo;
import com.sme.controller.StoreDetailsInfo;
import com.sme.controller.SupplierDetailsInfo;
import com.sme.controller.UserLoginInfo;
import com.sme.entity.PurchaseInwardVO;
import com.sme.entity.PurchaseOrderVO;
import com.sme.entity.CustomerDetails;
import com.sme.entity.SupplierDetails;
import com.sme.entity.UserDetails;
/*import com.sme.repository.PurchaseInwardRepository;
import com.sme.repository.PurchaseOrderRepository;*/
import com.sme.repository.StockCategoryRepository;
import com.sme.repository.StoreDetailsRepository;
import com.sme.repository.SupplierDtlsRepository;
import com.sme.repository.UserDtlsRepository;
import com.sme.repository.CustomerDtlsRepository;
@Service
public class SmeService implements ISmeService {

	@Autowired
	private UserDtlsRepository userDtlsRepository;

	@Autowired
	private SupplierDtlsRepository supplierDtlsRepository;
/*
	@Autowired
	private StockDetailsRepository stockDetailsRepository;*/
	
	@Autowired
	private CustomerDtlsRepository customerDtlsRepository;
	

	@Autowired
	private StoreDetailsRepository storeDetailsRepository;

	/*@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private PurchaseInwardRepository purchaseInwardRepository;
*/
	@Autowired
	private StockCategoryRepository stockCategoryRepository;

	/*
	 * @Autowired private UserLoginRepository userLoginRepository;
	 */
	/*
	 * @Override public Article getArticleById(long articleId) { Article obj =
	 * articleRepository.findById(articleId).get(); return obj; }
	 */
	/*
	 * @Override public List<Article> getAllArticles(){ List<Article> list = new
	 * ArrayList<>(); articleRepository.findAll().forEach(e -> list.add(e));
	 * return list; }
	 */
	@Override
	public synchronized boolean checkLogin(UserLoginInfo article) {
		// List<UserLogin> list =
		// userLoginRepository.findByCompanyNameAndPassword(article.getUserName(),
		// article.getPassword(), false);
		List<UserDetails> list = userDtlsRepository.findByCompanyNameAndPasswordAndInvalid(article.getUserName(),
				article.getPassword(), false);
		if (list.size() > 0) {
			return true;
		} else {
			// articleRepository.save(article);
			return false;
		}
	}

	@Override
	public synchronized List<UserDetails> getActiveCompanyDetails(String companyName, String supplierType) {
		List<UserDetails> usr_list = new ArrayList<>();
		if ((null != companyName && !companyName.isEmpty()) && (null != supplierType && !supplierType.isEmpty())) {
			System.out.println("Inside Both not null");
			usr_list = userDtlsRepository.findByCompanyNameAndSupplierTypeAndInvalid(companyName, supplierType, false);
		} else if ((null != companyName && !companyName.isEmpty())
				&& (null == supplierType || supplierType.equals(""))) {
			System.out.println("Inside Both company not null");
			usr_list = userDtlsRepository.findByCompanyNameAndInvalid(companyName, false);
		} else if ((null != supplierType && !supplierType.isEmpty())
				&& (null == companyName || companyName.equals(""))) {
			System.out.println("Inside Both supplier not null");
			usr_list = userDtlsRepository.findBySupplierTypeAndInvalid(supplierType, false);
		} else if ((null == supplierType || supplierType.equals(""))
				&& (null == companyName || companyName.equals(""))) {
			System.out.println("Inside Both null");
			usr_list = userDtlsRepository.findByinvalid(false);
		}

		return usr_list;
	}

	@Override
	public synchronized UserDetails addUser(UserDetails charts) {
		UserDetails usrDtl = userDtlsRepository.save(charts);
		return usrDtl;
	}

	@Override
	public synchronized boolean addSupplier(SupplierDetails supplierDtl) {
		supplierDtlsRepository.save(supplierDtl);
		return true;
	}

	/*@Override
	public synchronized StockDetailsInfo addStock(StockDetailsInfo stockDetailsInfo) {
		StockDetailsInfo addedStockDetailsInfo = stockDetailsRepository.save(stockDetailsInfo);
		return addedStockDetailsInfo;
	}*/

	@Override
	public synchronized boolean addStore(StoreDetailsInfo storeDetailsInfo) {
		StoreDetailsInfo addedStoreDetailsInfo = storeDetailsRepository.save(storeDetailsInfo);
		if (addedStoreDetailsInfo == null) {
			return false;
		}
		return true;
	}

	/*@Override
	public PurchaseOrderVO addPurchaseOrder(PurchaseOrderVO purchaseOrderVO) {

		PurchaseOrderVO savedPurchaseOrderVO = purchaseOrderRepository.save(purchaseOrderVO);
		return savedPurchaseOrderVO;

	}

	public PurchaseInwardVO addPurchaseInward(PurchaseInwardVO purchaseInwardVO) {
		PurchaseInwardVO savedpurchaseInwardVO = purchaseInwardRepository.save(purchaseInwardVO);
		return savedpurchaseInwardVO;
	}*/

	public StockCategoryInfo addStockCategory(StockCategoryInfo stockCategoryInfo) {
		StockCategoryInfo savedstockCategoryInfo = stockCategoryRepository.save(stockCategoryInfo);
		return savedstockCategoryInfo;
	}

	public List<StockCategoryInfo> getStockCategorywithStock() {
		List<StockCategoryInfo> stockCategoryInfoWithStock = (List<StockCategoryInfo>) stockCategoryRepository.findAll();
		
		
		return stockCategoryInfoWithStock;
	}
		@Override
	public synchronized boolean addCustomer(CustomerDetails customerDetails){
	 /*  List<Article> list = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory()); 	
       if (list.size() > 0) {
    	   return false;
       } else {*/
		customerDtlsRepository.save(customerDetails);
    	   return true;
       }
	@Override
	public List<SupplierDetails> getSupplierList(String supplierName) {
		List<SupplierDetails> supplierList = new ArrayList<>();
		if((null!=supplierName)){
			supplierList = supplierDtlsRepository.findBySupplierName(supplierName);
		}else {
			supplierList = (List<SupplierDetails>) supplierDtlsRepository.findAll();	
		}
		
		return supplierList;
	}

	@Override
	public StockDetailsInfo addStore(StockDetailsInfo stockDetailsInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockDetailsInfo addStock(StockDetailsInfo stockDetailsInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseInwardVO addPurchaseInward(PurchaseInwardVO purchaseInwardVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseOrderVO addPurchaseOrder(PurchaseOrderVO purchaseOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDetails> getCustomerList(String customerName) {
		List<CustomerDetails> customerList = new ArrayList<>();
		if((null!=customerName)){
			customerList = customerDtlsRepository.findByCustomerName(customerName);
		}else {
			customerList = (List<CustomerDetails>) customerDtlsRepository.findAll();	
		}
		
		return customerList;
	}
}
