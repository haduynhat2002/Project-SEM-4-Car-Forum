package com.example.carforum.entity.myenum;

public enum AccountStatus {
    ACTIVE(1), UNDER_CONSTRUCTION(0),UNDER_REPAIR(-1);
    private int value;

    AccountStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static AccountStatus of(int value){
        for (AccountStatus accountStatus: AccountStatus.values()
        ) {
            if (accountStatus.getValue() == value) {
                return accountStatus;
            }
        }
        return ACTIVE;
    }
}
