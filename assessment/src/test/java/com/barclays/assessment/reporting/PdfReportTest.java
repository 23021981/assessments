package com.barclays.assessment.reporting;


import com.barclays.assessment.computing.NetWorthComputing;
import com.barclays.assessment.exceptions.AccountProductException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class PdfReportTest {

    @Mock
    private NetWorthComputing netWorthComputing;

    @InjectMocks
    private PdfReport pdfReport;

    @Test
    public void generateReportTest() throws AccountProductException {
        pdfReport.generateReport();
        verify(netWorthComputing).sumOfAssetProductValue();
        verify(netWorthComputing).calculateNetWorthValue();
        verify(netWorthComputing).sumOfLiabilityProductValue();
        verify(netWorthComputing).mapAssetProductValue();
        verify(netWorthComputing).mapLiabilityProductValue();
        verify(netWorthComputing).sumOfRiskWeightedAsset();
    }
}
