package com.sme.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sme.entity.PurchaseInwardVO;
import com.sme.entity.PurchaseOrderVO;
import com.sme.service.ISmeService;
import com.sme.utils.Utils;

@RestController
@RequestMapping("inventory")
// @CrossOrigin(origins = {"http://smepoc.azurewebsites.net"})
@CrossOrigin(origins = { "http://localhost:4200" })
// @CrossOrigin(origins = {"http://localhost:4200","*"})
public class InventoryController {

	@Autowired
	private ISmeService articleService;

	@Autowired
	private JavaMailSender sender;

	@PostMapping(value = "addStock", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> saveStockDetails(@RequestBody StockDetailsInfo stockDetailsInfo,
			UriComponentsBuilder builder) {
		StockDetailsInfo addedStock = articleService.addStore(stockDetailsInfo);

		if (addedStock == null || addedStock.equals("")) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				builder.path("/saveStockDetails/{stockname}").buildAndExpand(addedStock.getStockname()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PostMapping(value="addpurchaseorder",produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PurchaseOrderVO> addPurchaseOrder(@RequestBody PurchaseOrderVO purchaseOrderVO,
			UriComponentsBuilder builder) {
		purchaseOrderVO.setRowcredt(Utils.getCurrentTime());

		PurchaseOrderVO savedPurchaseOrderVO = articleService.addPurchaseOrder(purchaseOrderVO);

		if (null != savedPurchaseOrderVO || savedPurchaseOrderVO.equals("")) {
			return new ResponseEntity<PurchaseOrderVO>(savedPurchaseOrderVO, HttpStatus.OK);
		} else {
			return new ResponseEntity<PurchaseOrderVO>(savedPurchaseOrderVO, HttpStatus.FAILED_DEPENDENCY);
		}
	}

	@PostMapping(value = "addpurchaseinward", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PurchaseInwardVO> addPurchaseinward(@RequestBody PurchaseInwardVO purchaseInwardVO,
			UriComponentsBuilder builder) {
		purchaseInwardVO.setRowcredt(Utils.getCurrentTime());

		PurchaseInwardVO savedPurchaseOrderVO = articleService.addPurchaseInward(purchaseInwardVO);

		/*String output = sendMail(articleInfo.getCompanyEmail(), articleInfo.getCompanyName(),
				articleInfo.getPassword());
*/
		// return new ResponseEntity<UserDetails>(usrDtl, //
		// HttpStatus.CREATED);
		if (null != savedPurchaseOrderVO && !savedPurchaseOrderVO.equals("")) {
			return new ResponseEntity<PurchaseInwardVO>(savedPurchaseOrderVO, HttpStatus.OK);
		} else {
			return new ResponseEntity<PurchaseInwardVO>(savedPurchaseOrderVO, HttpStatus.FAILED_DEPENDENCY);
		}
	}

	// @RequestBody StockCategoryInfo stockCategoryInfo,
	@GetMapping(value = "getstockcategorywithstock", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<StockCategoryInfo>> getStockCategoryWithstock() {
		List<StockCategoryInfo> stockCategoryWithStock = articleService.getStockCategorywithStock();
		if (null != stockCategoryWithStock && stockCategoryWithStock.size() > 0) {
			return new ResponseEntity<List<StockCategoryInfo>>(stockCategoryWithStock, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<StockCategoryInfo>>(stockCategoryWithStock, HttpStatus.FAILED_DEPENDENCY);
		}
	}

	@PostMapping(value = "addstockcategory", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StockCategoryInfo> addStockCategory(@RequestBody StockCategoryInfo stockCategoryInfo,
			UriComponentsBuilder builder) {
		stockCategoryInfo.setRowcredt(Utils.getCurrentTime());

		StockCategoryInfo savedstockCategoryInfo = articleService.addStockCategory(stockCategoryInfo);

		/*
		 * String output = sendMail(articleInfo.getCompanyEmail(),
		 * articleInfo.getCompanyName(), articleInfo.getPassword());
		 */
		// return new ResponseEntity<UserDetails>(usrDtl,
		// HttpStatus.CREATED);
		/*
		 * ResponseEntity<Void>(HttpStatus.CONFLICT); } HttpHeaders headers =
		 * new HttpHeaders();
		 * headers.setLocation(builder.path("/article/{id}").buildAndExpand(
		 * article.getArticleId()).toUri()); return new
		 * ResponseEntity<Void>(headers, HttpStatus.CREATED);
		 */
		if (null != savedstockCategoryInfo || savedstockCategoryInfo.equals("")) {
			return new ResponseEntity<StockCategoryInfo>(savedstockCategoryInfo, HttpStatus.OK);
		} else {
			return new ResponseEntity<StockCategoryInfo>(savedstockCategoryInfo, HttpStatus.FAILED_DEPENDENCY);
		}
	}
}
