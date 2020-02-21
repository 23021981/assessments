package com.barclays.assessment.computing;

import com.barclays.assessment.enums.ProductType;
import com.barclays.assessment.exceptions.AccountProductException;
import com.barclays.assessment.model.AccountProduct;
import com.barclays.assessment.services.AccountProductService;
import com.barclays.assessment.services.ProductService;
import edu.emory.mathcs.backport.java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class NetWorthComputingTest {

    @Mock
    private AccountProductService accountProductService;

    @Mock
    private ProductService productService;

    @InjectMocks
    private NetWorthComputing netWorthComputing;

    @Test
    public void calculateNetWorthValueTest() throws AccountProductException {
        netWorthComputing.calculateNetWorthValue();
        verify(accountProductService,times(2)).getAllAccountProduct();

    }

    @Test
    public void sumOfAssetProductValueTest() throws AccountProductException{

        List<AccountProduct> accountProductList = new ArrayList<AccountProduct>();
        AccountProduct ap = new AccountProduct();
        ap.setProductType(ProductType.Asset.name());
        ap.setAmount(new BigDecimal("100.00"));
        ap.setAccountType("Internal");
        ap.setAccountNumber("IA001");
        accountProductList.add(ap);

        AccountProduct ap1 = new AccountProduct();
        ap1.setProductType(ProductType.Asset.name());
        ap1.setAmount(new BigDecimal("100.00"));
        ap1.setAccountType("Internal");
        ap1.setAccountNumber("IA001");

        accountProductList.add(ap1);
        //Given
        Mockito.when(accountProductService.getAllAccountProduct()).thenReturn(accountProductList);

        //When
        BigDecimal assetValue = netWorthComputing.sumOfAssetProductValue();

        //Then
        assertNotNull(assetValue);
        assertThat(assetValue.doubleValue(), equalTo(200.00));
    }

    @Test
    public void sumOfLiabilityProductValueTest() throws AccountProductException{
        //Arrange
        List<AccountProduct> accountProductList = new ArrayList<AccountProduct>();
        AccountProduct ap = new AccountProduct();
        ap.setProductType(ProductType.Liability.name());
        ap.setAmount(new BigDecimal("100.00"));
        ap.setAccountType("Internal");
        ap.setAccountNumber("IA001");
        accountProductList.add(ap);

        AccountProduct ap1 = new AccountProduct();
        ap1.setProductType(ProductType.Liability.name());
        ap1.setAmount(new BigDecimal("100.00"));
        ap1.setAccountType("Internal");
        ap1.setAccountNumber("IA001");

        accountProductList.add(ap1);

        Mockito.when(accountProductService.getAllAccountProduct()).thenReturn(accountProductList);

        //Act
        BigDecimal assetValue = netWorthComputing.sumOfLiabilityProductValue();

        //Assert
        assertNotNull(assetValue);
        assertThat(assetValue.doubleValue(), equalTo(200.00));
    }

    @Test
    public void sumOfRiskWeightedAssetTest(){
        netWorthComputing.sumOfRiskWeightedAsset();
        verify(accountProductService).getAssetsAccountProduct();
        verify(productService).getAssetProduct();
    }

    @Test
    public void mapAssetProductValueTest(){
        netWorthComputing.mapAssetProductValue();
        verify(accountProductService).getAssetsAccountProduct();
        verify(productService).getAssetProduct();

    }

    @Test
    public void mapLiabilityProductValueTest(){
        netWorthComputing.mapLiabilityProductValue();
        verify(accountProductService).getLiabilityAccountProduct();
        verify(productService).getLiabilityProduct();

    }


}
