package com.barclays.assessment.services;

import com.barclays.assessment.enums.ProductType;
import com.barclays.assessment.exceptions.AccountProductException;
import com.barclays.assessment.model.AccountProduct;
import com.barclays.assessment.repository.AccountProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/* Author : Atul Kumar */

@Service("AccountProductService")
public class AccountProductServiceImpl implements AccountProductService {

    @Autowired
    AccountProductRepository accountProductRepository;
    @Override
    public List<AccountProduct> getAllAccountProduct() throws AccountProductException {
        List<AccountProduct> accountProductList= StreamSupport.stream(accountProductRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        if(accountProductList.size() < 1){
            throw new AccountProductException("There is no data found in AccountProduct table");
        }
        return accountProductList;
    }

    @Override
    public List<AccountProduct> getAssetsAccountProduct() {
        Iterable<AccountProduct> accountProducts = accountProductRepository.findAll();
        return StreamSupport.stream(accountProducts.spliterator(),false)
                .filter(ap-> ProductType.Asset.name().equals(ap.getProductType())).collect(Collectors.toList());
    }

    @Override
    public List<AccountProduct> getLiabilityAccountProduct() {
        Iterable<AccountProduct> accountProducts = accountProductRepository.findAll();
        return StreamSupport.stream(accountProducts.spliterator(),false)
                .filter(ap-> ProductType.Liability.name().equals(ap.getProductType())).collect(Collectors.toList());
    }

    @Override
    public AccountProduct saveAccountProduct(AccountProduct accountProduct) {
        return accountProductRepository.save(accountProduct);
    }
}
