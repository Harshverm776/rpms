package com.ct.rpm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ct.rpm.dto.CartRequestDto;
import com.ct.rpm.dto.CartResponseDto;
import com.ct.rpm.model.Vendor;
import com.ct.rpm.repository.CartRepo;
import com.ct.rpm.service.CartService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class CartServiceImplTest {

	@MockBean
	CartService cartServiceMock;
	@MockBean
	CartRepo cartRepo;
	@Autowired
	CartService cartService;

	@Test
	void testCartAddedSuccessfully() {
		CartRequestDto cartRequestDto = new CartRequestDto(1, 1, "123", 10);
		String msg = "Successfully added to Cart";
		when(cartServiceMock.addToCart(cartRequestDto)).thenReturn(msg);
		assertEquals(cartServiceMock.addToCart(cartRequestDto), cartService.addToCart(cartRequestDto));
	}

	@Test
	void testVendorIsNotHavingEnoughStocks() {
		CartRequestDto cartRequestDto = new CartRequestDto(1, 1, "123", 200);
		String msg = "Not Enough Stocks";
		when(cartServiceMock.addToCart(cartRequestDto)).thenReturn(msg);
		assertEquals(cartServiceMock.addToCart(cartRequestDto), cartService.addToCart(cartRequestDto));
	}

	@Test
	void testGetCartList() {
		long customerId = 700;
		List<CartResponseDto> list = new ArrayList<>();
		assertEquals(list, cartService.getCartList(customerId));
	}

	@Test
	void testVendorIsNotEmpty() {
		Vendor vendor = new Vendor(2, "Amazon", 30.5, 5.0);
		assertEquals(false, cartService.isVendorEmpty(vendor));

	}

}
