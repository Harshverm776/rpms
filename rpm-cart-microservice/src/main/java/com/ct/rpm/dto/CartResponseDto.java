package com.ct.rpm.dto;

import java.time.LocalDate;

import com.ct.rpm.model.Product;
import com.ct.rpm.model.Vendor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDto {
	private long cartId;	
	private String zipCode;
	private LocalDate deliveryDate;
	private long customerId;
	private long quantity;
	private Product product;
	private Vendor vendor;
}

