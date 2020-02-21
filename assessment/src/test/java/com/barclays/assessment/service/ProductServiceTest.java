package com.barclays.assessment.service;

import com.barclays.assessment.enums.ProductType;
import com.barclays.assessment.model.Product;
import com.barclays.assessment.repository.ProductRepository;
import com.barclays.assessment.services.ProductServiceImpl;
import edu.emory.mathcs.backport.java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void shouldGetAssetProduct(){
        //Given
        Mockito.when(productRepository.findAll()).thenReturn(createIterableAssetProduct());

        //When
        List<Product> actualProducts = productService.getAssetProduct();

        //Then
        assertNotNull(actualProducts);
        assertThat(actualProducts.size(), equalTo(1));
    }

    @Test
    public void shouldGetLiabilityProduct(){
        //Given
        Mockito.when(productRepository.findAll()).thenReturn(createIterableLiabilityProduct());

        //When
        List<Product> actualProducts = productService.getLiabilityProduct();

        //Then
        assertNotNull(actualProducts);
        assertThat(actualProducts.size(), equalTo(1));
    }

    private Iterable<Product> createIterableAssetProduct() {
        List<Product> productList = createAssetProducts();
        return new Iterable<Product>() {
            @Override
            public Iterator<Product> iterator() {
                return productList.iterator();
            }
        };
    }

    private List<Product> createAssetProducts() {
        Product product = new Product();
        product.setProductType(ProductType.Asset.name());
        product.setProductName("Cash");
        return Collections.singletonList(product);
    }

    private Iterable<Product> createIterableLiabilityProduct() {
        List<Product> productList = createLiabilityProducts();
        return new Iterable<Product>() {
            @Override
            public Iterator<Product> iterator() {
                return productList.iterator();
            }
        };
    }

    private List<Product> createLiabilityProducts() {
        Product product = new Product();
        product.setProductType(ProductType.Liability.name());
        product.setRiskRating(2);
        return Collections.singletonList(product);
    }

    @Test
    public void callFindAllWhileAssetProductTest(){
        productService.getAssetProduct();
        verify(productRepository).findAll();
    }

    @Test
    public void callFindAllWhileLiabilityProductTest(){
        productService.getLiabilityProduct();
        verify(productRepository).findAll();
    }
}
