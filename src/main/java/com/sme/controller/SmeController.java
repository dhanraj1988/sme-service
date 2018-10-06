package com.sme.controller;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sme.entity.AccountDetails;
import com.sme.entity.BankDetails;
import com.sme.entity.CurrencyDetails;
import com.sme.entity.CustomerAccountDetails;
import com.sme.entity.CustomerBankDetails;
import com.sme.entity.CustomerCurrencyDetails;
import com.sme.entity.CustomerDetails;
import com.sme.entity.SupplierDetails;
import com.sme.entity.UserDetails;
import com.sme.service.IRegistrationMailSender;
import com.sme.service.ISmeService;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@RequestMapping("user")
// @CrossOrigin(origins = {"http://smepoc.azurewebsites.net"})
@CrossOrigin(origins = { "http://localhost:4200" })
// @CrossOrigin(origins = {"http://localhost:4200","*"})
public class SmeController {
	@Autowired
	private ISmeService articleService;

	@Autowired
	private JavaMailSender sender;

	// Fetches article by id
	@GetMapping(value = "article/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserLoginInfo> getArticleById(@PathVariable("id") Integer id) {
		System.out.println("Inside get Article");
		UserLoginInfo ob = new UserLoginInfo();
		// ob.setCompanyName("Spring1111");
		// BeanUtils.copyProperties(articleService.getArticleById(id), ob);
		String output = sendMail("dhanraj.santhanam@gmail.com", "username", "password");
		System.out.println("Mail op===> " + output);
		return new ResponseEntity<UserLoginInfo>(ob, HttpStatus.OK);
	}

	@GetMapping(value = "allCompanyDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserLoginInfo> getAllCompanyDtls() {
		System.out.println("Inside get Article");
		UserLoginInfo ob = new UserLoginInfo();
		// ob.setCompanyName("Spring1111");
		// BeanUtils.copyProperties(articleService.getArticleById(id), ob);
		return new ResponseEntity<UserLoginInfo>(ob, HttpStatus.OK);
	}
	
	/*@GetMapping(value= "CompanyDetailsByName/{companyName}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArticleInfo> getCompanyDtlsByName(@PathVariable("companyName") String companyName) {
		System.out.println("Inside get Article");
		ArticleInfo ob = new ArticleInfo();
		//ob.setCompanyName("Spring1111");
		//BeanUtils.copyProperties(articleService.getArticleById(id), ob);
		return new ResponseEntity<ArticleInfo>(ob, HttpStatus.OK);
	}*/
	
	//Fetches all articles 
/*	@GetMapping(value= "articles", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ArticleInfo>> getAllArticles() {
		List<ArticleInfo> responseArticleList = new ArrayList<>();
		List<Article> articleList = articleService.getAllArticles();
		for (int i = 0; i < articleList.size(); i++) {
			ArticleInfo ob = new ArticleInfo();
		    BeanUtils.copyProperties(articleList.get(i), ob);
		    responseArticleList.add(ob);    
		}
		return new ResponseEntity<List<ArticleInfo>>(responseArticleList, HttpStatus.OK);
	}*/

	// Creates a new article
/*	@PostMapping(value= "article", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> addArticle(@RequestBody ArticleInfo articleInfo, UriComponentsBuilder builder) {
		Article article = new Article();
		BeanUtils.copyProperties(articleInfo, article);
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}*/
		@PostMapping(value= "postcustomer", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDetails> addArticle(@RequestBody UserDetails articleInfo, UriComponentsBuilder builder) {
		System.out.println("articleInfo Email ===>"+articleInfo.getCompanyEmail());
		//UserDetails article = new UserDetails();
		
		//BeanUtils.copyProperties(articleInfo, article);
		System.out.println("Email ===>"+articleInfo.getCompanyEmail());
		System.out.println("Inside customer Article");
		if(articleInfo.getCompanyName()!=null){
			System.out.println("Charts"+articleInfo.getCompanyName());}
		if(articleInfo.getTitle()!=null){
			System.out.println("Charts"+articleInfo.getTitle());}
		if(articleInfo.getSupplierType()!=null){
			System.out.println("Charts"+articleInfo.getSupplierType());}
		articleInfo.setInvalid(false);
		UserDetails usrDtl = new UserDetails();
		if(articleInfo.getCompanyName()!=null && !articleInfo.getCompanyName().trim().equals("")){
		usrDtl = articleService.addUser(articleInfo);
        
        String output = sendMail(articleInfo.getCompanyEmail(), articleInfo.getCompanyName(), articleInfo.getPassword());
		//return new ResponseEntity<UserDetails>(usrDtl, HttpStatus.CREATED);
        return new ResponseEntity<UserDetails>(usrDtl, HttpStatus.OK);
		}else{
			return new ResponseEntity<UserDetails>(usrDtl, HttpStatus.FAILED_DEPENDENCY);
		}
	}

	@PostMapping(value = "postcustomer", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDetails> addUserRegistration(@RequestBody UserDetails articleInfo,
			UriComponentsBuilder builder) {
		UserDetails usrDtl = new UserDetails();
		if (articleInfo.getCompanyName() != null && !articleInfo.getCompanyName().trim().equals("")) {
			usrDtl = articleService.addUser(articleInfo);

			String output = sendMail(articleInfo.getCompanyEmail(), articleInfo.getCompanyName(),
					articleInfo.getPassword());
			// return new ResponseEntity<UserDetails>(usrDtl,
			// HttpStatus.CREATED);
			return new ResponseEntity<UserDetails>(usrDtl, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserDetails>(usrDtl, HttpStatus.FAILED_DEPENDENCY);
		}
	}

	@PostMapping(value = "savesupplier", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Boolean addSupplier(@RequestBody SupplierDetailsInfo supplierDtlInfo, UriComponentsBuilder builder) {
		System.out.println("Inside add Supplier");
		SupplierDetails supplierDtl = new SupplierDetails();
		supplierDtl.setSupplierName(supplierDtlInfo.getSuppliername());
		System.out.println("Inside add Supplier supplierDtlInfo.getSuppliername() ==>"+supplierDtlInfo.getSuppliername());
		supplierDtl.setPaymentmode(supplierDtlInfo.getPaymentmode());
		supplierDtl.setPostalcode(supplierDtlInfo.getPostalcode());
		supplierDtl.setTown(supplierDtlInfo.getTown());
		supplierDtl.setEmail(supplierDtlInfo.getEmail());
		supplierDtl.setPhonenumber(supplierDtlInfo.getPhonenumber());
		ArrayList<AccountDetails> accList = new ArrayList<>();
		ArrayList<BankDetails> bankList = new ArrayList<>();
		ArrayList<CurrencyDetails> currencyList = new ArrayList<>();
		for(AccountDetailsInfo AccountDetailObj:supplierDtlInfo.getAccountdetailslist()){
			AccountDetails accDtl = new AccountDetails();
			System.out.println("Inside add Supplier Account   ==>"+AccountDetailObj.getCode());
			BeanUtils.copyProperties(AccountDetailObj, accDtl);
			accDtl.setSupplier(supplierDtl);
			accList.add(accDtl);
		}
		BankDetails bnkDtl = new BankDetails();
		CurrencyDetails curDtl = new CurrencyDetails();
		BeanUtils.copyProperties(supplierDtlInfo.getBankdetails(), bnkDtl);
		bnkDtl.setSupplier(supplierDtl);
		bankList.add(bnkDtl);
		BeanUtils.copyProperties(supplierDtlInfo.getCurrencydetails(), curDtl);
		curDtl.setSupplier(supplierDtl);
		currencyList.add(curDtl);
		supplierDtl.setAccountdetails(accList);
		supplierDtl.setBankdetails(bankList);
		supplierDtl.setCurrencydetails(currencyList);
		/*List<BankDetails> bankList = new ArrayList<>();
		for(BankDetailsInfo BankDetailsObj:supplierDtlInfo.getBankdetails()){
			BankDetails bank_dtl = new BankDetails();
			BeanUtils.copyProperties(BankDetailsObj, bank_dtl);
			bankList.add(bank_dtl);
		}
		supplierDtl.setBankdetails(bankList);
		List<CurrencyDetails> currencyList = new ArrayList<>();
		for(CurrencyDetailsInfo CurrencyDetailsObj:supplierDtlInfo.getCurrencydetails()){
			CurrencyDetails currencyDtl = new CurrencyDetails();
			BeanUtils.copyProperties(CurrencyDetailsObj, currencyDtl);
			currencyList.add(currencyDtl);
		}
		supplierDtl.setCurrencydetails(currencyList);*/
        boolean flag = articleService.addSupplier(supplierDtl);
        /*if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
       /* HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(articleInfo.getCompanyName()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);*/
		return true;
	}
	
	@PostMapping(value= "savecustomer", produces= { MediaType.APPLICATION_JSON_VALUE })
	public Boolean addcustomer(@RequestBody CustomerDetailsInfo customerDtlInfo, UriComponentsBuilder builder) {
		System.out.println("Inside add Supplier");
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustomerName(customerDtlInfo.getCustomername());
		System.out.println("Inside add Customer customerDtlInfo.getCustomername() ==>"+customerDtlInfo.getCustomername());
		customerDetails.setPaymentmode(customerDtlInfo.getPaymentmode());
		customerDetails.setPostalcode(customerDtlInfo.getPostalcode());
		customerDetails.setTown(customerDtlInfo.getTown());
		customerDetails.setEmail(customerDtlInfo.getEmail());
		customerDetails.setPhonenumber(customerDtlInfo.getPhonenumber());
		ArrayList<CustomerAccountDetails> accList = new ArrayList<>();
		ArrayList<CustomerBankDetails> bankList = new ArrayList<>();
		ArrayList<CustomerCurrencyDetails> currencyList = new ArrayList<>();
		for(AccountDetailsInfo AccountDetailObj:customerDtlInfo.getAccountdetailslist()){
			CustomerAccountDetails accDtl = new CustomerAccountDetails();
			System.out.println("Inside add Customer Account   ==>"+AccountDetailObj.getCode());
			BeanUtils.copyProperties(AccountDetailObj, accDtl);
			accDtl.setCustomer(customerDetails);
			accList.add(accDtl);
		}
		CustomerBankDetails bnkDtl = new CustomerBankDetails();
		CustomerCurrencyDetails curDtl = new CustomerCurrencyDetails();
		BeanUtils.copyProperties(customerDtlInfo.getBankdetails(), bnkDtl);
		bnkDtl.setCustomer(customerDetails);
		bankList.add(bnkDtl);
		BeanUtils.copyProperties(customerDtlInfo.getCurrencydetails(), curDtl);
		curDtl.setCustomer(customerDetails);
		currencyList.add(curDtl);
		customerDetails.setAccountdetails(accList);
		customerDetails.setBankdetails(bankList);
		customerDetails.setCurrencydetails(currencyList);
		/*List<BankDetails> bankList = new ArrayList<>();
		for(BankDetailsInfo BankDetailsObj:supplierDtlInfo.getBankdetails()){
			BankDetails bank_dtl = new BankDetails();
			BeanUtils.copyProperties(BankDetailsObj, bank_dtl);
			bankList.add(bank_dtl);
		}
		supplierDtl.setBankdetails(bankList);
		List<CurrencyDetails> currencyList = new ArrayList<>();
		for(CurrencyDetailsInfo CurrencyDetailsObj:supplierDtlInfo.getCurrencydetails()){
			CurrencyDetails currencyDtl = new CurrencyDetails();
			BeanUtils.copyProperties(CurrencyDetailsObj, currencyDtl);
			currencyList.add(currencyDtl);
		}
		supplierDtl.setCurrencydetails(currencyList);*/
        boolean flag = articleService.addCustomer(customerDetails);
        /*if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
       /* HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(articleInfo.getCompanyName()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);*/
		return flag;
	}
	
	/*@PostMapping(value= "getCompanyDetails", produces= { MediaType.APPLICATION_JSON_VALUE })
	public List<ChartsInfo> getSupplier(@RequestBody ChartsInfo articleInfo, UriComponentsBuilder builder) {
		UserLoginInfo article = new UserLoginInfo();
		//BeanUtils.copyProperties(articleInfo, article);
		System.out.println("==========>getCompanyDetails");
		System.out.println("article UU====>  "+articleInfo.getCompanyName());
		System.out.println("article P====>  "+articleInfo.getSupplierType());
        List<UserDetails> usrList = articleService.getActiveCompanyDetails(articleInfo.getCompanyName(),articleInfo.getSupplierType());
        List<ChartsInfo> usrInfoList = new ArrayList<>();
        for (UserDetails userDetailsObj:usrList){
        	ChartsInfo usrInfo = new ChartsInfo();
        		BeanUtils.copyProperties(userDetailsObj, usrInfo);
        	usrInfoList.add(usrInfo);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(articleInfo.getCompanyName()).toUri());
        return new ResponseEntity<ChartsInfo>(usrInfoList, HttpStatus.OK);
        System.out.println("usrInfoList ===>"+usrInfoList.size());
        for(ChartsInfo userDetailsObj:usrInfoList){
        	System.out.println("userDetailsObj ===>"+userDetailsObj.getCompanyName());
        }
        
        return usrInfoList;
	}*/
	
	@PostMapping(value= "logincustomer", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserLoginInfo> addArticle(@RequestBody UserLoginInfo articleInfo, UriComponentsBuilder builder) {
		UserLoginInfo article = new UserLoginInfo();
		//BeanUtils.copyProperties(articleInfo, article);
		System.out.println("==========>logincustomer");
		System.out.println("article UU====>  "+articleInfo.getUserName());
		System.out.println("article P====>  "+articleInfo.getPassword());
		List<TestModel> test = articleInfo.getTestarray();
		for (TestModel obj: test){
		System.out.println("article P====>  "+obj.getName());
		}
        boolean flag = articleService.checkLogin(articleInfo);
        article.setValid(flag);
        System.out.println("flag ====>  "+flag);
        /*if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(builder.path("/article/{id}").buildAndExpand(articleInfo.getUserName()).toUri());
        return new ResponseEntity<UserLoginInfo>(article, HttpStatus.OK);
		//return flag;
	}
	@PostMapping(value= "getCompanyDetails", produces= { MediaType.APPLICATION_JSON_VALUE })
	public List<ChartsInfo> filterCompany(@RequestBody ChartsInfo articleInfo, UriComponentsBuilder builder) {
		UserLoginInfo article = new UserLoginInfo();
		//BeanUtils.copyProperties(articleInfo, article);
		System.out.println("==========>getCompanyDetails");
		System.out.println("article UU====>  "+articleInfo.getCompanyName());
		System.out.println("article P====>  "+articleInfo.getSupplierType());
        List<UserDetails> usrList = articleService.getActiveCompanyDetails(articleInfo.getCompanyName(),articleInfo.getSupplierType());
        List<ChartsInfo> usrInfoList = new ArrayList<>();
        for (UserDetails userDetailsObj:usrList){
        	ChartsInfo usrInfo = new ChartsInfo();
        		BeanUtils.copyProperties(userDetailsObj, usrInfo);
        	usrInfoList.add(usrInfo);
        }
        /*HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(articleInfo.getCompanyName()).toUri());
        return new ResponseEntity<ChartsInfo>(usrInfoList, HttpStatus.OK);*/
        System.out.println("usrInfoList ===>"+usrInfoList.size());
        for(ChartsInfo userDetailsObj:usrInfoList){
        	System.out.println("userDetailsObj ===>"+userDetailsObj.getCompanyName());
        }
        
        return usrInfoList;
	}
	
	@PostMapping(value= "getsupplierlist", produces= { MediaType.APPLICATION_JSON_VALUE })
	public List<SupplierDetailsInfo> getSupplierList(@RequestBody SupplierDetails supplierInfo, UriComponentsBuilder builder) {
		System.out.println("Inside Get Supplier List");

        List<SupplierDetails> supplierList = articleService.getSupplierList(supplierInfo.getSupplierName());
        List<SupplierDetailsInfo> supplierInfoList = new ArrayList<>();
        for (SupplierDetails supplierObj:supplierList){
        	SupplierDetailsInfo supplierDtl = new SupplierDetailsInfo();
    		supplierDtl.setSuppliername(supplierObj.getSupplierName());
    		supplierDtl.setPaymentmode(supplierObj.getPaymentmode());
    		supplierDtl.setPostalcode(supplierObj.getPostalcode());
    		supplierDtl.setTown(supplierObj.getTown());
    		supplierDtl.setEmail(supplierObj.getEmail());
    		supplierDtl.setPhonenumber(supplierObj.getPhonenumber());
    		ArrayList<AccountDetailsInfo> accList=new ArrayList<>();

    		for(AccountDetails accountDetail:supplierObj.getAccountdetails()){
    			AccountDetailsInfo accDtl = new AccountDetailsInfo();
    			BeanUtils.copyProperties(accountDetail, accDtl);
    			accList.add(accDtl);
    		}
    		supplierDtl.setAccountdetailslist(accList);
    		BankDetailsInfo bnkDtl = new BankDetailsInfo();
    		CurrencyDetailsInfo curDtl = new CurrencyDetailsInfo();
    		BeanUtils.copyProperties(supplierObj.getBankdetails(), bnkDtl);
    		BeanUtils.copyProperties(supplierObj.getCurrencydetails(), curDtl);
    		supplierDtl.setBankdetails(bnkDtl);
    		supplierDtl.setCurrencydetails(curDtl);
    		supplierInfoList.add(supplierDtl);
        }
        System.out.println("usrInfoList ===>"+supplierInfoList.size());
        for(SupplierDetailsInfo supplierDetailsObj:supplierInfoList){
        	System.out.println("supplierDetailsObj ===>"+supplierDetailsObj);
        }
        
        return supplierInfoList;
	}
	@PostMapping(value= "getcustomerlist", produces= { MediaType.APPLICATION_JSON_VALUE })
	public List<CustomerDetailsInfo> getCustomerList(@RequestBody CustomerDetails customerInfo, UriComponentsBuilder builder) {
		System.out.println("Inside Get Supplier List");

        List<CustomerDetails> customerList = articleService.getCustomerList(customerInfo.getCustomerName());
        List<CustomerDetailsInfo> customerInfoList = new ArrayList<>();
        for (CustomerDetails customerObj:customerList){
        	CustomerDetailsInfo customerDtl = new CustomerDetailsInfo();
        	customerDtl.setCustomername(customerObj.getCustomerName());
        	customerDtl.setPaymentmode(customerObj.getPaymentmode());
        	customerDtl.setPostalcode(customerObj.getPostalcode());
        	customerDtl.setTown(customerObj.getTown());
        	customerDtl.setEmail(customerObj.getEmail());
        	customerDtl.setPhonenumber(customerObj.getPhonenumber());
    		ArrayList<AccountDetailsInfo> accList=new ArrayList<>();

    		for(CustomerAccountDetails accountDetail:customerObj.getAccountdetails()){
    			AccountDetailsInfo accDtl = new AccountDetailsInfo();
    			BeanUtils.copyProperties(accountDetail, accDtl);
    			accList.add(accDtl);
    		}
    		customerDtl.setAccountdetailslist(accList);
    		BankDetailsInfo bnkDtl = new BankDetailsInfo();
    		CurrencyDetailsInfo curDtl = new CurrencyDetailsInfo();
    		BeanUtils.copyProperties(customerObj.getBankdetails(), bnkDtl);
    		BeanUtils.copyProperties(customerObj.getCurrencydetails(), curDtl);
    		customerDtl.setBankdetails(bnkDtl);
    		customerDtl.setCurrencydetails(curDtl);
    		customerInfoList.add(customerDtl);
        }
        System.out.println("usrInfoList ===>"+customerInfoList.size());
        for(CustomerDetailsInfo customerDetailsObj:customerInfoList){
        	System.out.println("customerDetailsObj ===>"+customerDetailsObj);
        }
        
        return customerInfoList;
	}
	
	
	//Updates article
	/*@PutMapping(value= "article", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArticleInfo> updateArticle(@RequestBody ArticleInfo articleInfo) {
		Article article = new Article();
		BeanUtils.copyProperties(articleInfo, article);		
		articleService.updateArticle(article);
		
		ArticleInfo ob = new ArticleInfo();
		BeanUtils.copyProperties(article, ob);
		return new ResponseEntity<ArticleInfo>(ob, HttpStatus.OK);
	}*/
	
	/*//Deletes article by id
	@DeleteMapping(value= "article/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}*/	
		@PostMapping(value = "saveStoreDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Boolean> saveStoreDetails(@RequestBody StoreDetailsInfo storeDetailsInfo,
			UriComponentsBuilder builder) {
		Boolean result = articleService.addStore(storeDetailsInfo);

		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	public String sendMail(String email,String userName,String password) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
        	String text = "You are Succesfully registered in the SME System, Please use the below credentials to login \n"
        				+"Username : "+userName+"\n"
        				+"Password : "+password;
            helper.setTo(email);
            helper.setText(text);
            helper.setSubject("SME Registration Succesful");
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        return "Mail Sent Success!";
    }
} 