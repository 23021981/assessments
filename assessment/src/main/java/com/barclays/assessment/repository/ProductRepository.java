package com.barclays.assessment.repository;

import com.barclays.assessment.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/*Author : Atul Kumar*/
@Repository
public interface ProductRepository extends CrudRepository<Product, String>{
}
