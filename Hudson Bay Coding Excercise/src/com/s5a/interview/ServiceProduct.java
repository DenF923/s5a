package com.s5a.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dennis Fung
 *
 */

public class ServiceProduct {

	private List<Product> products;
	
	public ServiceProduct() {
		products = new ArrayList<Product>();
	}
	
	public boolean add(Product product) {
		return products.add(product);
	}

}
