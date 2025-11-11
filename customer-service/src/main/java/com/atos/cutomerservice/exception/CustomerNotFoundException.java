package com.atos.cutomerservice.exception;

public class CustomerNotFoundException extends RuntimeException{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5917935585860597545L;

	public CustomerNotFoundException(Long idCustomer) {
		super("Customer not found with Id  "+ idCustomer);
	}

}
