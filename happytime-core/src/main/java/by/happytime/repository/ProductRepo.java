package by.happytime.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.happytime.baserepo.BaseRepo;
import by.happytime.domain.Category;
import by.happytime.domain.Product;
import by.happytime.domain.Subcategory;

public interface ProductRepo extends BaseRepo<Product> {
    
    @Query("SELECT p FROM Product p INNER JOIN p.subcategories c WHERE c IN (:subcategories)")
    Page<Product> findBySubcategories(@Param("subcategories") List<Subcategory> subcategories, Pageable page);
    
    @Query("SELECT p FROM Product p INNER JOIN p.subcategories sc INNER JOIN sc.category c WHERE c IN (:categories)")
    Page<Product> findByCategories(@Param("categories") List<Category> categories, Pageable page);
    
    Long countBySubcategories(List<Subcategory> subcategories);
    
    @Query("SELECT COUNT (DISTINCT p)  FROM Product p INNER JOIN p.subcategories sc INNER JOIN sc.category c WHERE c IN (:categories)")
    Long countByCategories(@Param("categories") List<Category> categories);
    
    Page<Product> findAll(Pageable page);

}
