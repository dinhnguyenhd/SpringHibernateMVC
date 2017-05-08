package Service;

import java.util.ArrayList;

import EntityMapping.Products;

public interface ProductService {
	
	public ArrayList<Products> listProduct(int page);

	public ArrayList<Products> addProduct(Products product);

	public ArrayList<Products> removeProduct(Products product);
	
	public Products findProductbyId(int id);

}
