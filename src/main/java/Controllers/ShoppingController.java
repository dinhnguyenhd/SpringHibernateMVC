package Controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import EntityMapping.Products;
import Service.ProductService;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET, value = "/add/{id}")
	public ModelAndView addCart(@PathVariable("id") int id, HttpSession session) {
		Products product = this.productService.findProductbyId(id);
		if (session.getAttribute("cartList") == null) {
			Map<Integer, Products> cart = new HashMap<Integer, Products>();
			cart.put(id, product);
			session.setAttribute("cartList", cart);
		} else {
			@SuppressWarnings("unchecked")
			Map<Integer, Products> cart = (Map<Integer, Products>) session.getAttribute("cartList");
			if (cart.containsKey(id)) {
				Products products = cart.get(id);
				products.setPrice(product.getPrice() + 5);
				cart.put(id, products);
				session.setAttribute("cartList", cart);

			} else {
				cart.put(id, product);
				session.setAttribute("cartList", cart);
			}

		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listCart");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
	public ModelAndView deleteCart(@PathVariable("id") int id, HttpSession session) {
		@SuppressWarnings("unchecked")
		Map<Integer, Products> cart = (Map<Integer, Products>) session.getAttribute("cartList");
		cart.remove(id);
		session.setAttribute("cartList", cart);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listCart");
		return mv;
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
