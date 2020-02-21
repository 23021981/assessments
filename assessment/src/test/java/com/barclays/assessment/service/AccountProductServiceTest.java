package com.barclays.assessment.service;

import com.barclays.assessment.enums.ProductType;
import com.barclays.assessment.exceptions.AccountProductException;
import com.barclays.assessment.model.AccountProduct;
import com.barclays.assessment.repository.AccountProductRepository;
import com.barclays.assessment.services.AccountProductServiceImpl;
import edu.emory.mathcs.backport.java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class AccountProductServiceTest  {

    @Mock
    AccountProductRepository accountProductRepository;

    @InjectMocks
    AccountProductServiceImpl accountProductService;

    @Test
    public void shouldGetAllAccountProductTest() throws AccountProductException {
        //Given
        Mockito.when(accountProductRepository.findAll()).thenReturn(createIterableAccountProduct());

        //When
        List<AccountProduct> actualAccountProducts = accountProductService.getAllAccountProduct();

        //Then
        assertNotNull(actualAccountProducts);
        assertThat(actualAccountProducts.size(), equalTo(1));
    }

    private Iterable<AccountProduct> createIterableAccountProduct() {
        List<AccountProduct> accountProductList = createAccountProducts();
        return new Iterable<AccountProduct>() {
            @Override
            public Iterator<AccountProduct> iterator() {
                return accountProductList.iterator();
            }
        };
    }

    private List<AccountProduct> createAccountProducts() {
        AccountProduct accountProduct = new AccountProduct();
        accountProduct.setProductType(ProductType.Asset.name());
        accountProduct.setAmount(new BigDecimal("1000.00"));
        accountProduct.setAccountType("Wholesale");
        return Collections.singletonList(accountProduct);
    }

    @Test
    public void getAssetsAccountProductTest(){
        accountProductService.getAssetsAccountProduct();
        verify(accountProductRepository).findAll();
    }

    @Test
    public void getLiabilityAccountProductTest(){
        //Given
        Mockito.when(accountProductRepository.findAll()).thenReturn(createIterableLiabilityAccountProduct());

        //When
        List<AccountProduct> actualAccountProducts = accountProductService.getLiabilityAccountProduct();

        //Then
        assertNotNull(actualAccountProducts);
        assertThat(actualAccountProducts.size(), equalTo(1));

    }
    private Iterable<AccountProduct> createIterableLiabilityAccountProduct() {
        List<AccountProduct> accountProductList = createLiabilityAccountProducts();
        return new Iterable<AccountProduct>() {
            @Override
            public Iterator<AccountProduct> iterator() {
                return accountProductList.iterator();
            }
        };
    }

    private List<AccountProduct> createLiabilityAccountProducts() {
        AccountProduct accountProduct = new AccountProduct();
        accountProduct.setProductType(ProductType.Liability.name());
        accountProduct.setAmount(new BigDecimal("1000.00"));
        accountProduct.setProductName("Cash");
        return Collections.singletonList(accountProduct);
    }

}
