package com.barclays.assessment.model;
import javax.persistence.*;

/*Author : Atul Kumar*/

@Entity
@Table(name="Product")
public class Product {
    @Id
    String productId;
    String productName;
    int riskRating;
    String productType;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(int riskRating) {
        this.riskRating = riskRating;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
