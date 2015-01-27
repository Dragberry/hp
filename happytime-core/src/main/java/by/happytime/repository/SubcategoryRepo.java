package by.happytime.repository;

import java.util.List;

import by.happytime.baserepo.BaseRepo;
import by.happytime.domain.Category;
import by.happytime.domain.Subcategory;

public interface SubcategoryRepo extends BaseRepo<Subcategory> {
    
    Subcategory findByTitle(String title);
    
    Subcategory findByCode(String code);
    
    List<Subcategory> findByCategory(Category category);

}
