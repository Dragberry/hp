package by.happytime.transfer;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.happytime.domain.Category;
import by.happytime.domain.Product;
import by.happytime.domain.Subcategory;
import by.happytime.repository.CategoryRepo;
import by.happytime.repository.ProductRepo;
import by.happytime.repository.SubcategoryRepo;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

@Component(value = "ExcelImporter")
public class ExcelImporter implements Importer {

    private static final long serialVersionUID = 5564208879955102303L;
    
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private SubcategoryRepo subcategoryRepo;

    public void doImport(InputStream is) throws Exception {
        WorkbookSettings settings = new WorkbookSettings();
        settings.setEncoding("CP1251");
        Workbook workbook = Workbook.getWorkbook(is);
        Sheet sheet = workbook.getSheet(0);
        for (int i = 1; i < sheet.getRows(); i++) {
            Product product = new Product();
            product.setCountry(getString(sheet.getCell(0,  i)));
            product.setManufacturer(getString(sheet.getCell(1,  i)));
            product.setTitle(getString(sheet.getCell(2,  i)));
            List<Category> categories = getCategoryList(sheet.getCell(3,  i));
            product.setSubcategories(getSubcategoryList(sheet.getCell(4,  i), categories.get(0)));
            product.setCost(getBigDecimal(sheet.getCell(5,  i)));
            product.setQuantity(getInteger(sheet.getCell(6,  i)));
            product.setColors(getString(sheet.getCell(7,  i)));
            product.setDescription(getString(sheet.getCell(8,  i)));
            product.setFullDescription(getString(sheet.getCell(9,  i)));
            product.setImgLink(getString(sheet.getCell(10,  i)));
            product.setKeywords(getString(sheet.getCell(11,  i)));
            productRepo.save(product);
        }
    }
    
    private Integer getInteger(Cell cell) {
        return StringUtils.isNumeric(getString(cell)) ? Integer.valueOf(getString(cell)) : 0;
    }
    
    private BigDecimal getBigDecimal(Cell cell) {
        if (StringUtils.isNotBlank(cell.getContents())) {
            return new BigDecimal(cell.getContents());
        }
        return null;
    }
    
    private List<Subcategory> getSubcategoryList(Cell cell, Category category) {
        List<Subcategory> subcategoryList = new ArrayList<Subcategory>();
        String value = getString(cell);
        String[] values = value.split("/");
        for (String subcategoryTitle : values) {
            Subcategory subcategory = subcategoryRepo.findByTitle(subcategoryTitle);
            if (subcategory == null) {
                subcategory = new Subcategory();
                subcategory.setTitle(subcategoryTitle);
                subcategory.setCategory(category);
                subcategoryRepo.save(subcategory);
            }
            subcategoryList.add(subcategory);
        }
        return subcategoryList;
    }
    
    private List<Category> getCategoryList(Cell cell) {
        List<Category> categoryList = new ArrayList<Category>();
        String categoryValue = getString(cell);
        Category category = categoryRepo.findByTitle(categoryValue);
        if (category != null) {
            categoryList.add(category);
        }
        return categoryList;
    }
        
     private String getString(Cell cell) {
         return cell.getContents() == null ? StringUtils.EMPTY : cell.getContents();
     }

    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public CategoryRepo getCategoryRepo() {
        return categoryRepo;
    }

    public void setCategoryRepo(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public SubcategoryRepo getSubcategoryRepo() {
        return subcategoryRepo;
    }

    public void setSubcategoryRepo(SubcategoryRepo subcategoryRepo) {
        this.subcategoryRepo = subcategoryRepo;
    }

}
