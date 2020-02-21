package com.barclays.assessment.services;

import com.barclays.assessment.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAssetProduct();
    public List<Product> getLiabilityProduct();
}
