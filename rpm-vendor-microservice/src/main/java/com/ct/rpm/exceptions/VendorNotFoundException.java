package com.ct.rpm.exceptions;

public class VendorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VendorNotFoundException(String msg) {
		super(msg);
	}

}
