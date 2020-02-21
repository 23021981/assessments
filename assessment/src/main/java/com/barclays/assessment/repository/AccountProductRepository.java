package com.barclays.assessment.repository;

import com.barclays.assessment.model.AccountProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/*Author : Atul Kumar*/
@Repository
public interface AccountProductRepository extends CrudRepository<AccountProduct, String> {
}
