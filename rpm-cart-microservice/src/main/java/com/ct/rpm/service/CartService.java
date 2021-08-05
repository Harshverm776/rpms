package com.ct.rpm.service;

import java.util.List;

import com.ct.rpm.dto.CartRequestDto;
import com.ct.rpm.dto.CartResponseDto;
import com.ct.rpm.model.Vendor;

public interface CartService {
	
	public String addToCart(CartRequestDto cartRequestDto);
	public List<CartResponseDto> getCartList(long customerId);
	public boolean isVendorEmpty(Vendor vendor);
	
	
}
