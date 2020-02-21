package com.barclays.assessment.services;

import com.barclays.assessment.enums.ProductType;
import com.barclays.assessment.model.Product;
import com.barclays.assessment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/* Author : Atul Kumar */

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAssetProduct() {
        Iterable<Product> productIterable = productRepository.findAll();

        return StreamSupport.stream(productIterable.spliterator(),false)
                .filter(p-> ProductType.Asset.name().equals(p.getProductType())).collect(Collectors.toList());
    }

    @Override
    public List<Product> getLiabilityProduct() {
        Iterable<Product> productIterable = productRepository.findAll();
        return StreamSupport.stream(productIterable.spliterator(),false)
                .filter(p->ProductType.Liability.name().equals(p.getProductType())).collect(Collectors.toList());
    }
}
