package com.ct.rpm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.rpm.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
	public Vendor findById(long vendorId);
}
