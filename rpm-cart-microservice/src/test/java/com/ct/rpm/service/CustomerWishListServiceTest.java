package com.ct.rpm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ct.rpm.dto.CustomerWishListDTO;
import com.ct.rpm.dto.CustomerWishListRequestDTO;
import com.ct.rpm.dto.StatusDTO;
import com.ct.rpm.model.CustomerWishList;
import com.ct.rpm.model.Product;
import com.ct.rpm.repository.CustomerWishListRepo;
import com.ct.rpm.service.CustomerWishListService;
import com.ct.rpm.service.ProductService;

@SpringBootTest
class CustomerWishListServiceTest {

	@MockBean
	private CustomerWishListRepo customerRepo;
	@MockBean
	private ProductService productService;
	@Autowired
	private CustomerWishListService customerWishListService;

	@Test
	 void testSave() {
		CustomerWishListRequestDTO customerWishList = new CustomerWishListRequestDTO(1l, 2l, 10);
		CustomerWishList wish = new CustomerWishList(2l, 8, LocalDate.of(2021, 05, 04), 1l);
		when(customerRepo.save(wish)).thenReturn(wish);
		assertEquals(customerWishListService.save(customerWishList), new StatusDTO("SuccessFully Added to WishList"));
	}

	@Test
	 void testGetCartDetails() {
		CustomerWishList wish = new CustomerWishList(2l, 8, LocalDate.of(2021, 05, 04), 1l);
		long customerId = 2l;
		CustomerWishList customerWishList = new CustomerWishList(2l, 8, LocalDate.of(2021, 05, 04), 1l);
		List<CustomerWishList> list = new ArrayList<>();
		list.add(customerWishList);
		Product product = new Product(2, "Heaphone", 500, "description", "imageName", 5);
		CustomerWishListDTO customerWishListDTO = new CustomerWishListDTO(0l, 8, LocalDate.of(2021, 05, 04), 1l,
				product);
		List<CustomerWishListDTO> newList = new ArrayList<CustomerWishListDTO>();
		newList.add(customerWishListDTO);
		when(customerRepo.getCustomerListById(customerId)).thenReturn(list);
		when(productService.getProductbyId(wish.getProductId())).thenReturn(product);
		assertEquals(customerWishListService.getCartDetails(customerId), newList);
	}

}
