package com.barclays.assessment.computing;

import com.barclays.assessment.enums.ProductType;
import com.barclays.assessment.exceptions.AccountProductException;
import com.barclays.assessment.model.AccountProduct;
import com.barclays.assessment.model.Product;
import com.barclays.assessment.services.AccountProductService;
import com.barclays.assessment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
/*
Author : Atul Kumar
This class is used to calculate the Net Worth GBP and Simple Risk Weighted Assets.
*/

@Component
public class NetWorthComputing implements BasicComputing<BigDecimal> {
    @Autowired
    private AccountProductService accountProductService;

    @Autowired
    private ProductService productService;

    @Override
    public BigDecimal calculateNetWorthValue() throws AccountProductException{
        return sumOfAssetProductValue().subtract(sumOfLiabilityProductValue());
    }

    @Override
    public BigDecimal sumOfAssetProductValue() throws AccountProductException {
        List<AccountProduct> accountProducts = accountProductService.getAllAccountProduct();
        return accountProducts.stream()
                .filter(ap-> ProductType.Asset.name().equals(ap.getProductType()))
                .map(AccountProduct::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    @Override
    public BigDecimal sumOfLiabilityProductValue() throws AccountProductException{
        List<AccountProduct> accountProducts = accountProductService.getAllAccountProduct();
        return accountProducts.stream()
                .filter(ap-> ProductType.Liability.name().equals(ap.getProductType()))
                .map(AccountProduct::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
    }


    @Override
    public BigDecimal sumOfRiskWeightedAsset() {
        BigDecimal sumOfRiskWeightedValue=BigDecimal.ZERO;
        List<AccountProduct> assetAccountProduct = accountProductService.getAssetsAccountProduct();

        List<Product> assetProductList= productService.getAssetProduct();
        assertNotNull(assetProductList);
        for(Product assetProduct: assetProductList)
            sumOfRiskWeightedValue = sumOfRiskWeightedValue.add(
                    computeRiskWeightedAsset(computeProductAssetValue(assetAccountProduct, assetProduct.getProductName()),
                            assetProduct.getRiskRating()));

        return sumOfRiskWeightedValue;
    }

    public Map<String, BigDecimal> mapAssetProductValue(){
        Map<String, BigDecimal> assetProductValueMap = new HashMap<String, BigDecimal>();

        List<AccountProduct> assetAccountProduct = accountProductService.getAssetsAccountProduct();

        List<Product> assetProductList= productService.getAssetProduct();
        assertNotNull(assetProductList);
        for(Product assetProduct: assetProductList)
            assetProductValueMap.put(assetProduct.getProductName(),computeProductAssetValue(assetAccountProduct, assetProduct.getProductName()));

        return assetProductValueMap;
    }

    public Map<String, BigDecimal> mapLiabilityProductValue(){
        Map<String, BigDecimal> assetProductValueMap = new HashMap<String, BigDecimal>();

        List<AccountProduct> assetAccountProduct = accountProductService.getLiabilityAccountProduct();
        List<Product> assetProductList= productService.getLiabilityProduct();
        assertNotNull(assetProductList);
        for(Product assetProduct: assetProductList)
            assetProductValueMap.put(assetProduct.getProductName(),computeProductAssetValue(assetAccountProduct, assetProduct.getProductName()));

        return assetProductValueMap;

    }

    private BigDecimal computeRiskWeightedAsset(BigDecimal value, int riskRating){
        return value.subtract(value.multiply(new BigDecimal("0.05")).
                multiply(new BigDecimal(riskRating)));

    }

    private BigDecimal computeProductAssetValue(List<AccountProduct> assetAccountProduct, String productName){
       return assetAccountProduct.stream().filter(ap->productName.equals(ap.getProductName()))
                .map(AccountProduct::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

}
