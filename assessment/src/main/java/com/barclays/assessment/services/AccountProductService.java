package com.barclays.assessment.services;

import com.barclays.assessment.exceptions.AccountProductException;
import com.barclays.assessment.model.AccountProduct;

import java.util.List;

public interface AccountProductService {

    public List<AccountProduct>  getAllAccountProduct() throws AccountProductException;

    public List<AccountProduct> getAssetsAccountProduct();

    public List<AccountProduct> getLiabilityAccountProduct();

    public AccountProduct saveAccountProduct(AccountProduct accountProduct);
}
