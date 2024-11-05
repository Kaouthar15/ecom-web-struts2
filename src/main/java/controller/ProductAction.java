package controller;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import model.Category;
import model.Product;
import service.ProductService;
import service.CategoryService;

//@Namespace("/product")
//@Results({
//    @Result(name = "success", location = "/product.jsp"),
//    @Result(name = "input", location = "/input.jsp")
//})
public class ProductAction extends ActionSupport{

    private static final long serialVersionUID = 1L;
    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();
    
    private List<Product> products;
    private List<Category> categories;
    private Product product = new Product();
    private Long productId;
    private String keyword;
    private Long categoryId; 

    // Getter and Setter methods for Struts
    public List<Product> getProducts() {
        return products;
    }

    public List<Category> getCategories() {
        return categories;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    

    
    // Action methods
    
    @Action(value = "list", results = @Result(name = "success", location = "/product.jsp"))
    public String list() {
        products = productService.list();
        return SUCCESS;
    }
    
    @Action(value = "add", results = {
        @Result(name = "success", location = "/product.jsp"),
        @Result(name = "input", location = "/addProduct.jsp")
    })
    public String add() {
        categories = categoryService.list(); 
        if (product != null) {
            productService.add(product, categoryId); 
            return SUCCESS;
        }
        return INPUT;
    }
    
    @Action(value = "update", results = {
        @Result(name = "success", location = "/products.jsp"),
//        @Result(name = "input", location = "/updateProduct.jsp")
    })
    public String update() {
        categories = categoryService.list(); // Load categories for the form
        if (product != null && product.getId() != null) {
            productService.update(product, categoryId); // Pass categoryId to update product
            return SUCCESS;
        }
        return INPUT;
    }
    
    @Action(value = "delete", results = @Result(name = "success", location = "/product.jsp"))
    public String delete() {
        if (productId > 0) {
            productService.remove(productId);
            return SUCCESS;
        }
        return INPUT;
    }
    
    @Action(value = "search", results = {
        @Result(name = "success", location = "/products.jsp"),
//        @Result(name = "input", location = "/searchProduct.jsp")
    })
    public String search() {
        if (keyword != null && !keyword.isEmpty()) {
            products = productService.selectByKeyword(keyword);
            return SUCCESS;
        }
        return INPUT;
    }
}
