package Dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import EntityMapping.Products;

@Repository
public class ProductDaoImpl extends AbstractDao implements ProductDao {

	@Override
	public ArrayList<Products> listProduct(int page) {
		String hql = "from Products";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(page * 3);
		query.setMaxResults(3);
		@SuppressWarnings("unchecked")
		ArrayList<Products> list = (ArrayList<Products>) query.list();
		return list;
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

	@Override
	public Products findProductbyId(int id) {
		Products product = (Products) getSession().get(Products.class, id);
		return product;
	}

}
