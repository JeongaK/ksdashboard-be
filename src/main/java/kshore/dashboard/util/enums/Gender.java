package kshore.dashboard.util.enums;

public enum Gender {

    //enum values
    M("M"),
    F("F"),
    O("O");

    private String value;

    Gender(String value){
        this.value = value;
    }

    //getter
    public String getValue(){
        return value;
    }

    //equals gender value
    public static Gender fromValue(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.value.equals(value)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Unknown value in Gender: " + value);
    }

}
