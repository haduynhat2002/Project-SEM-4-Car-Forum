package com.example.carforum.entity.myenum;

public enum ProductStatus {
    ACTIVE(1), UNDER_CONSTRUCTION(0),UNDER_REPAIR(-1);
    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static ProductStatus of(int value){
        for (ProductStatus productStatus: ProductStatus.values()
        ) {
            if (productStatus.getValue() == value) {
                return productStatus;
            }
        }
        return ACTIVE;
    }
}
