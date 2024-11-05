package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.Category;
import model.Product;
import service.ProductService;

public class ProductAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ProductService productService = new ProductService();
	
	List<Product> products;
	private Product product;
	private Long productId;
	private String keyword;
	// Getter and Setter methods for Struts
	public List<Product> getProducts() {
        return products;
    }

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	// Action methods
	
	// list method
	public String list() {
		products = productService.list();
		return SUCCESS;
	}
	// add product method
	public String add() {
        if (product != null) {
            productService.add(product);
            return SUCCESS;
        }
        return INPUT;
    }
	
	// update method
	public String update() {
        if (product != null && product.getId() != null) {
            productService.update(product);
            return SUCCESS;
        }
        return INPUT;
    }
	
	// delete method
	public String delete() {
        if (productId > 0) {
            productService.remove(productId);
            return SUCCESS;
        }
        return INPUT;
    }
	// search method 
	public String search() {
        if (keyword != null && !keyword.isEmpty()) {
            products = productService.selectByKeyword(keyword);
            return SUCCESS;
        }
        return INPUT;
    }
	
}
