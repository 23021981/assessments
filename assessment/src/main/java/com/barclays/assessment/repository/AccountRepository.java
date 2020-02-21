package com.barclays.assessment.repository;

import com.barclays.assessment.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*Author : Atul Kumar*/
@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
}
