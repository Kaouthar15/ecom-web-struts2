package actions;

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
    public String list() {
        System.out.println("Listing products");
        products = productService.list();
        System.out.println("Total products: " + products.size());
        return SUCCESS;
    }
    
    public String add() {
        // Fetch categories for the dropdown
        categories = categoryService.list();
        System.out.println("Category ID: " + categoryId);
        System.out.println("Categories available: " + categories);
        
        if (product != null && categoryId != null) {
            System.out.println("Adding product with Category ID: " + categoryId);
            productService.add(product, categoryId); 
            return SUCCESS;
        }
        System.out.println(product + " categoryId :  " + categoryId); 
        return INPUT;
    }
    public String input() {
        categories = categoryService.list();
        return INPUT; // Return the input view
    }
    
    public String update() {
        categories = categoryService.list();
        
        if (product != null && product.getId() != null && categoryId != null) {
            productService.update(product, categoryId); 
            return SUCCESS;
        }
        return INPUT;
    }
    
    public String delete() {
        if (productId != null && productId > 0) {
            productService.remove(productId);
            return SUCCESS;
        }
        return INPUT;
    }
    
    public String search() {
        if (keyword != null && !keyword.isEmpty()) {
            products = productService.selectByKeyword(keyword);
            return SUCCESS;
        }
        return INPUT;
    }
}
