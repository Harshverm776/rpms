package com.ct.rpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.rpm.model.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Long>{

	
}
