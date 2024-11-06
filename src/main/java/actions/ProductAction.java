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
    public void setProducts(List<Product> products) {
    	this.products = products;  
    }
    public List<Category> getCategories() {
        return categories;
    }
    

    public void setCategories(List<Category> categories) {
    	this.categories = categories;  
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
    
    public String execute() {
        // Retrieve categories from the database using the service
        categories = categoryService.list();
        System.out.println(categories);
        return SUCCESS;
    }
    
    public String list() {
        System.out.println("Listing products");
        
        products = productService.list();
        return SUCCESS;
    }

    public String addProductFormData() {
    	setCategories(categoryService.list());
    	return SUCCESS; 
    }
    
    public String add() {
        categories = categoryService.list();
        
        if (product != null && categoryId != null) {
                    
            productService.add(product, categoryId);
            return SUCCESS;
        }
        return INPUT;
    }
    
    public String input() {
        categories = categoryService.list();
        System.out.println("Fetched categories: " + categories); 
        return INPUT; 
    }
    
    public String update() {
        categories = categoryService.list();
        System.out.println("update first");
        if (product != null && product.getId() != null && categoryId != null) {
        	System.out.println("pass done");
            productService.update(product, categoryId); 
            return SUCCESS;
        }
        return INPUT;
    }
    public String updateProductFormData() {
    	System.out.println("updateProductFormData");
    	setCategories(categoryService.list());
    	Product product = productService.get1(productId);
    	setProduct(product);
    	return SUCCESS; 
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
