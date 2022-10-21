package com.example.carforum.entity.myenum;

import com.example.carforum.entity.CategoryCar;

public enum CategoryCarStatus {
    ACTIVE(1), UNDER_CONSTRUCTION(0),UNDER_REPAIR(-1);
    private int value;

    CategoryCarStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static CategoryCarStatus of(int value){
        for (CategoryCarStatus categoryCarStatus: CategoryCarStatus.values()
        ) {
            if (categoryCarStatus.getValue() == value) {
                return categoryCarStatus;
            }
        }
        return ACTIVE;
    }
}
