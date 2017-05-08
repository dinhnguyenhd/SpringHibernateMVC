package Service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.ProductDao;
import EntityMapping.Products;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public ArrayList<Products> listProduct(int page) {
		// TODO Auto-generated method stub
		return this.productDao.listProduct(page);
	}

	@Override
	public ArrayList<Products> addProduct(Products product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Products> removeProduct(Products product) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Products findProductbyId(int id) {
		return this.productDao.findProductbyId(id);
	}

}
