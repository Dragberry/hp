package by.happytime.model.data;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.PageRequest;

import by.happytime.domain.Category;
import by.happytime.domain.Product;
import by.happytime.domain.Subcategory;
import by.happytime.repository.ProductRepo;

public class ProductLazyDataModel extends LazyDataModel<Product> {

    private static final long serialVersionUID = 2088725956257813305L;
    
    private ProductRepo productRepo = null;
    
    private List<Category> categoryList = null;
    
    private List<Subcategory> subcategoryList = null;
    
    public ProductLazyDataModel(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    
    @Override
    public List<Product> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        Integer pageNumber = first / pageSize;
        Long total = 0L;
        List<Product> products = null;
        if (CollectionUtils.isNotEmpty(categoryList)) {
            products = productRepo.findByCategories(categoryList, new PageRequest(pageNumber, pageSize)).getContent();
            total = productRepo.countByCategories(categoryList);
        } else if (CollectionUtils.isNotEmpty(subcategoryList)) {
            products = productRepo.findBySubcategories(subcategoryList, new PageRequest(pageNumber, pageSize)).getContent();
            total = productRepo.countBySubcategories(subcategoryList);
        } else {
            products = productRepo.findAll(new PageRequest(pageNumber, pageSize)).getContent();
            total = productRepo.count();
        }
        setPageSize(pageSize);
        setRowCount(total.intValue());
        return products;
    }
    
     
    @Override
    public Product getRowData(String rowKey) {
        return productRepo.findOne(Long.valueOf(rowKey));
    }
 
    @Override
    public Object getRowKey(Product product) {
        return product.getId();
    }

    public void setSubcategoryList(List<Subcategory> subcategoryList) {
        this.subcategoryList = subcategoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
    
}
