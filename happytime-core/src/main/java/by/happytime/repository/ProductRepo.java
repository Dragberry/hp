package by.happytime.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.happytime.baserepo.BaseRepo;
import by.happytime.domain.Product;
import by.happytime.domain.Subcategory;

public interface ProductRepo extends BaseRepo<Product> {
    
    @Query("SELECT p FROM Product p INNER JOIN p.subcategories c WHERE c IN (:subcategories)")
    Page<Product> findBySubcategories(@Param("subcategories") List<Subcategory> subcategories, Pageable page);

}
