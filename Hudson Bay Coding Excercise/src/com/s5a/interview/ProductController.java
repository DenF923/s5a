package com.s5a.interview;

/**
 * @author Dennis Fung
 *
 */

public class ProductController {

    private Product currentProduct;
    private ServiceProduct serviceProduct; 
    
    public ProductController() {
    	this("Saks-brand-name");
    }
    
    public ProductController(String brandName) {
    	serviceProduct = new ServiceProduct();
    	addProduct(brandName);
    }

    public String showProduct() {
        return currentProduct.getBrandName();
    }

    public boolean addProduct(String brandName) {
    	currentProduct = new Product(brandName);
        return serviceProduct.add(currentProduct);
    }

    public String formattedBrandName() {
        return "Current product: " + currentProduct.getBrandName();
    }

}