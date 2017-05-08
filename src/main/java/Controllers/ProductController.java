package Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import EntityMapping.Products;
import Service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product/list/{page}", method = RequestMethod.GET)
	public ModelAndView listProduct(@PathVariable("page") int page) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Products> list = this.productService.listProduct(page);
		mv.addObject("list", list);
		mv.setViewName("listProduct");
		return mv;

	}

	@RequestMapping(value = "product/list/ajax/{page}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ArrayList<Products> moreProduct(@PathVariable("page") int page) {
		ArrayList<Products> list = this.productService.listProduct(page);
		return list;

	}

	/**
	 * @return the productService
	 */
	public ProductService getProductService() {
		return productService;
	}

	/**
	 * @param productService
	 *            the productService to set
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
