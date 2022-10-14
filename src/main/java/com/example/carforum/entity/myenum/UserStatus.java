package com.example.carforum.entity.myenum;

public enum UserStatus {
    USING(1), UNDERCONSTRUCTION(0),UNDERREPAIR(-1), UNDEFINED(-2);
    private int value;

    UserStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static UserStatus of(int value){
        for (UserStatus roadStatus: UserStatus.values()
        ) {
            if (roadStatus.getValue() == value) {
                return roadStatus;
            }
        }
        return UNDEFINED;
    }
}
