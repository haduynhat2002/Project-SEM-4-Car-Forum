package com.example.carforum.entity.myenum;

public enum CarReivewStatus {
    ACTIVE(1), UNDER_CONSTRUCTION(0),UNDER_REPAIR(-1);
    private int value;

    CarReivewStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static CarReivewStatus of(int value){
        for (CarReivewStatus carReviewStatus: CarReivewStatus.values()
        ) {
            if (carReviewStatus.getValue() == value) {
                return carReviewStatus;
            }
        }
        return ACTIVE;
    }
}
