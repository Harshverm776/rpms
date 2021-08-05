package com.ct.rpm.service;

import com.ct.rpm.model.Vendor;
import com.ct.rpm.model.VendorStock;

public interface VendorStockService {

	public VendorStock save(VendorStock vendorStock);

	public Vendor getVendor(long productId, int quanity);

	public long getMaxQuantity(long productId);
}
