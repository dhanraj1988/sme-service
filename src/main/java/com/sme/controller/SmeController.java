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

import com.sme.entity.AccountDetail;
import com.sme.entity.BankDetails;
import com.sme.entity.CurrencyDetails;
import com.sme.entity.SupplierDetails;
import com.sme.entity.UserDetails;
import com.sme.service.IRegistrationMailSender;
import com.sme.service.ISmeService;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@RequestMapping("user")
//@CrossOrigin(origins = {"http://smepoc.azurewebsites.net"})
@CrossOrigin(origins = {"http://localhost:4200","*"})
public class SmeController {
	@Autowired
	private ISmeService articleService;
	
	@Autowired
    private JavaMailSender sender;
	
	//Fetches article by id
	@GetMapping(value= "article/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserLoginInfo> getArticleById(@PathVariable("id") Integer id) {
		System.out.println("Inside get Article");
		UserLoginInfo ob = new UserLoginInfo();
		//ob.setCompanyName("Spring1111");
		//BeanUtils.copyProperties(articleService.getArticleById(id), ob);
		String output = sendMail("dhanraj.santhanam@gmail.com", "username", "password");
		System.out.println("Mail op===> "+output);
		return new ResponseEntity<UserLoginInfo>(ob, HttpStatus.OK);
	}
	
	@GetMapping(value= "allCompanyDetails", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserLoginInfo> getAllCompanyDtls() {
		System.out.println("Inside get Article");
		UserLoginInfo ob = new UserLoginInfo();
		//ob.setCompanyName("Spring1111");
		//BeanUtils.copyProperties(articleService.getArticleById(id), ob);
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
	
	//Creates a new article
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
	@PostMapping(value= "addsupplier", produces= { MediaType.APPLICATION_JSON_VALUE })
	public Boolean addSupplier(@RequestBody SupplierDetailsInfo supplierDtlInfo, UriComponentsBuilder builder) {
		System.out.println("Inside add Supplier");
		SupplierDetails supplierDtl = new SupplierDetails();
		supplierDtl.setSupplierName(supplierDtlInfo.getSuppliername());
		supplierDtl.setPaymentmode(supplierDtlInfo.getPaymentmode());
		supplierDtl.setPostalcode(supplierDtlInfo.getPostalcode());
		supplierDtl.setTown(supplierDtlInfo.getTown());
		supplierDtl.setEmail(supplierDtlInfo.getEmail());
		supplierDtl.setPhonenumber(supplierDtlInfo.getPhonenumber());
		List<AccountDetail> accList = new ArrayList<>();
		for(AccountDetailsInfo AccountDetailObj:supplierDtlInfo.getAccountdetails()){
			AccountDetail accDtl = new AccountDetail();
			BeanUtils.copyProperties(AccountDetailObj, accDtl);
			accList.add(accDtl);
		}
		supplierDtl.setAccountdetails(accList);
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
	
	@PostMapping(value= "logincustomer", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserLoginInfo> addArticle(@RequestBody UserLoginInfo articleInfo, UriComponentsBuilder builder) {
		UserLoginInfo article = new UserLoginInfo();
		//BeanUtils.copyProperties(articleInfo, article);
		System.out.println("==========>logincustomer");
		System.out.println("article UU====>  "+articleInfo.getUserName());
		System.out.println("article P====>  "+articleInfo.getPassword());
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