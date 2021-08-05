package com.ct.rpm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ct.rpm.exceptions.VendorNotFoundException;
import com.ct.rpm.model.Vendor;
import com.ct.rpm.repo.VendorRepository;
import com.ct.rpm.service.VendorService;

@SpringBootTest
class VendorServiceImplTest {

	@Autowired
	VendorService vendorService;

	@MockBean
	VendorRepository vendorRepository;

	@Test
	void testFindByVendorId() {
		Vendor vendor = new Vendor(1, "Amazon", 30.5, 5.0);
		long vendorId = 1;
		when(vendorRepository.findById(vendorId)).thenReturn(vendor);
		assertEquals(vendorService.findByVendorId(vendorId).getVendorId(), vendor.getVendorId());
	}

	@Test
	void testFindByVendorIdVendorNotFoundException() {
		long vendorId = 101;
		when(vendorRepository.findById(vendorId)).thenReturn(null);
		Exception exception = assertThrows(VendorNotFoundException.class, () -> vendorService.findByVendorId(vendorId));
		assertEquals("Vendore With id [" + vendorId + "] not found", exception.getMessage());
	}
}
