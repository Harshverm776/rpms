package com.ct.rpm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.rpm.model.Vendor;
import com.ct.rpm.service.VendorService;
import com.ct.rpm.service.VendorStockService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/vendor")
@Slf4j
public class VendorController {

	@Autowired
	VendorStockService vendorStockService;
	@Autowired
	VendorService vendorService;

	@GetMapping("/{productId}/{quantity}")
	public Vendor getBestVendor(@PathVariable int productId, @PathVariable int quantity) {
		log.info("GetBestVendor inside controller started");
		return vendorStockService.getVendor(productId, quantity);
	}

	@GetMapping("/{vendorId}")
	public Vendor getVendor(@PathVariable long vendorId) {
		log.info("GetVendor inside controller started");
		return vendorService.findByVendorId(vendorId);
	}

}
