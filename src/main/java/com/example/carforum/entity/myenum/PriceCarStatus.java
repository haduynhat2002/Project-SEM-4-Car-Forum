package com.example.carforum.entity.myenum;

public enum PriceCarStatus {
    ACTIVE(1), UNDER_CONSTRUCTION(0),UNDER_REPAIR(-1);
    private int value;

    PriceCarStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static PriceCarStatus of(int value){
        for (PriceCarStatus priceCarStatus: PriceCarStatus.values()
        ) {
            if (priceCarStatus.getValue() == value) {
                return priceCarStatus;
            }
        }
        return ACTIVE;
    }
}
