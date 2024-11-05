package controller;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import model.Category;
import model.Product;
import service.ProductService;
import service.CategoryService;

public class ProductAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();
    
    private List<Product> products;
    private List<Category> categories; // List of categories to show in forms
    private Product product;
    private Long productId;
    private String keyword;
    private Long categoryId; // ID of the selected category

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
    
    // List all products
    public String list() {
        products = productService.list();
        return SUCCESS;
    }
    
    // Add product method
    public String add() {
        categories = categoryService.list(); // Load categories for the form
        if (product != null) {
            productService.add(product, categoryId); // Pass categoryId to add product
            return SUCCESS;
        }
        return INPUT;
    }
    
    // Update product method
    public String update() {
        categories = categoryService.list(); // Load categories for the form
        if (product != null && product.getId() != null) {
            productService.update(product, categoryId); // Pass categoryId to update product
            return SUCCESS;
        }
        return INPUT;
    }
    
    // Delete product method
    public String delete() {
        if (productId > 0) {
            productService.remove(productId);
            return SUCCESS;
        }
        return INPUT;
    }
    
    // Search method
    public String search() {
        if (keyword != null && !keyword.isEmpty()) {
            products = productService.selectByKeyword(keyword);
            return SUCCESS;
        }
        return INPUT;
    }
}
