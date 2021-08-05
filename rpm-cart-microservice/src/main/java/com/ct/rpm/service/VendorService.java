package com.ct.rpm.service;


import com.ct.rpm.model.Vendor;

public interface VendorService {
	
	public Vendor saveVendore(Vendor vendore);
	public Vendor getVendoreById(long vendoreId);
	
}
