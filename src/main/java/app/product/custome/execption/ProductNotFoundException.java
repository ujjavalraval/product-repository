package app.product.custome.execption;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String message) {
		  super(message);
	      log.info("Custome Error Occuring..");
	 }
}
