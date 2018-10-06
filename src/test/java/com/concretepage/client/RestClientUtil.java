package com.concretepage.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sme.controller.AccountDetailsInfo;
import com.sme.controller.ChartsInfo;
import com.sme.controller.StockCategoryInfo;
import com.sme.controller.StockVO;
import com.sme.controller.SupplierDetailsInfo;
import com.sme.controller.UserLoginInfo;
import com.sme.entity.Article;
import com.sme.entity.UserDetails;
public class RestClientUtil {
    public void getArticleByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "https://smeservice.azurewebsites.net/spring-boot-demo-0.0.1-SNAPSHOT/user/article/{1}";
        	//String url = "https://servicers.azurewebsites.net/user/article/1";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Article> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Article.class, 1);
        Article article = responseEntity.getBody();
        System.out.println("Id:"+article.getArticleId()+", Title:"+article.getTitle()
                 +", Category:"+article.getCategory());      
    }
	public void getAllArticlesDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/articles";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Article[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Article[].class);
        Article[] articles = responseEntity.getBody();
        for(Article article : articles) {
              System.out.println("Id:"+article.getArticleId()+", Title:"+article.getTitle()
                      +", Category: "+article.getCategory());
        }
    }
    public void addArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/article";
	    Article objArticle = new Article();
	    objArticle.setTitle("Spring REST Security using Hibernate");
	    objArticle.setCategory("Spring");
        HttpEntity<Article> requestEntity = new HttpEntity<Article>(objArticle, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void addcustomer() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/postcustomer";
	    UserDetails objArticle = new UserDetails();
	    objArticle.setTitle("Spring REST");
	    objArticle.setCompanyEmail("admin@gmail.com");
	    objArticle.setPassword("admin");
        HttpEntity<UserDetails> requestEntity = new HttpEntity<UserDetails>(objArticle, headers);
        objArticle.setCompanyName("Spring");
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri);    	
    }
    
    public void getCompanyDetails() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/getCompanyDetails";
	    ChartsInfo objArticle = new ChartsInfo();
	    objArticle.setCompanyName("admin");
	    objArticle.setCompanyEmail("admin@gmail.com");
	    objArticle.setPassword("admin");
	    //objArticle.setSupplierType("Local");
        HttpEntity<ChartsInfo> requestEntity = new HttpEntity<ChartsInfo>(objArticle, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    
    public void getSupplierDetails() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/getsupplierlist";
	    SupplierDetailsInfo supplierObj=new SupplierDetailsInfo();
	    supplierObj.setSuppliername("DDD");
	    supplierObj.setPostalcode(123);
	    
        HttpEntity<SupplierDetailsInfo> requestEntity = new HttpEntity<SupplierDetailsInfo>(supplierObj, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
    }
    
    public void addsupplier() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/addsupplier";
	    SupplierDetailsInfo spf = new SupplierDetailsInfo();
	    spf.setSuppliername("DD1");
	    spf.setEmail("asdf@g.com");
	    AccountDetailsInfo adf = new AccountDetailsInfo();
	    adf.setNumber("121");
	    AccountDetailsInfo adf1 = new AccountDetailsInfo();
	    adf.setNumber("1234");
	    List<AccountDetailsInfo> asdf = new ArrayList<AccountDetailsInfo>();
	    asdf.add(adf);
	    asdf.add(adf1);
	    //spf.setAccountdetails(asdf);
        HttpEntity<SupplierDetailsInfo> requestEntity = new HttpEntity<SupplierDetailsInfo>(spf, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void checkLogin() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/logincustomer";
	    UserLoginInfo objArticle = new UserLoginInfo();
	    objArticle.setPassword("password123");
	    objArticle.setUserName("Syntel");
	    
        HttpEntity<UserLoginInfo> requestEntity = new HttpEntity<UserLoginInfo>(objArticle, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/article";
	    Article objArticle = new Article();
	    objArticle.setArticleId(1);
	    objArticle.setTitle("Update:Java Concurrency");
	    objArticle.setCategory("Java");
        HttpEntity<Article> requestEntity = new HttpEntity<Article>(objArticle, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/article/{id}";
        HttpEntity<Article> requestEntity = new HttpEntity<Article>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    
    public void addstock() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/addsupplier";
	    SupplierDetailsInfo spf = new SupplierDetailsInfo();
	    spf.setSuppliername("DD1");
	    spf.setEmail("asdf@g.com");
	    AccountDetailsInfo adf = new AccountDetailsInfo();
	    adf.setNumber("121");
	    AccountDetailsInfo adf1 = new AccountDetailsInfo();
	    adf.setNumber("1234");
	    List<AccountDetailsInfo> asdf = new ArrayList<AccountDetailsInfo>();
	    asdf.add(adf);
	    asdf.add(adf1);
	    //spf.setAccountdetails(asdf);
        HttpEntity<SupplierDetailsInfo> requestEntity = new HttpEntity<SupplierDetailsInfo>(spf, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void addstockCategory() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/addsupplier";
	    SupplierDetailsInfo spf = new SupplierDetailsInfo();
	    spf.setSuppliername("DD1");
	    spf.setEmail("asdf@g.com");
	    AccountDetailsInfo adf = new AccountDetailsInfo();
	    adf.setNumber("121");
	    AccountDetailsInfo adf1 = new AccountDetailsInfo();
	    adf.setNumber("1234");
	    List<AccountDetailsInfo> asdf = new ArrayList<AccountDetailsInfo>();
	    asdf.add(adf);
	    asdf.add(adf1);
	    //spf.setAccountdetails(asdf);
        HttpEntity<SupplierDetailsInfo> requestEntity = new HttpEntity<SupplierDetailsInfo>(spf, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void TestgetStockCategoryWithStock() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/inventory/getstockcategorywithstock";
	    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	    System.out.println("CAAAALLLLLLLINNNNNNGGGGGGGGG");
        ResponseEntity<StockCategoryInfo[]> responseEntity = restTemplate.getForEntity(url, StockCategoryInfo[].class);
        		//exchange(url, HttpMethod.GET, requestEntity, StockCategoryInfo[].class);
        StockCategoryInfo[] articles = responseEntity.getBody();
        for(StockCategoryInfo article : articles) {
              System.out.println("Category Name:"+article.getStockcategoryname()+", Title:"+article.getStockctgid());
              ArrayList<StockVO> stock =  (ArrayList<StockVO>) article.getStockVO();
              
              for(StockVO StockVObj:stock){
            	  System.out.println("StockVObj StockName: "+StockVObj.getStockname()+" , StockId: "+StockVObj.getStockid());
              }
        }  	
    }
    
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getArticleByIdDemo();
    	util.getSupplierDetails();
        //util.addsupplier();
        //util.checkLogin();
    	//util.addArticleDemo();
    	//util.updateArticleDemo();
    	//util.deleteArticleDemo();
    	//util.getAllArticlesDemo();
    	//util.addcustomer();
    	util.TestgetStockCategoryWithStock();
util.getSupplierDetails();
    }    
}
