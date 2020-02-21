package com.barclays.assessment.computing;

import com.barclays.assessment.exceptions.AccountProductException;

import java.math.BigDecimal;
import java.util.Map;

public interface BasicComputing<T> {
    public T calculateNetWorthValue() throws AccountProductException;
    public T sumOfRiskWeightedAsset();
    public T sumOfAssetProductValue() throws AccountProductException;
    public T sumOfLiabilityProductValue() throws AccountProductException;


}
