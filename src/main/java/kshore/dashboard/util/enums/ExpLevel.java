package kshore.dashboard.util.enums;

public enum ExpLevel {

    //enum values
    JUNIOR("JUNIOR"),
    SENIOR("SENIOR"),
    MIDDLE("MIDDLE");

    private String value;

    ExpLevel(String value) {
        this.value = value;
    }

    //getter
    public String getValue() {
        return value;
    }

    //equals resource status value
    public static ExpLevel fromValue(String value) {
        for (ExpLevel expLevel : ExpLevel.values()) {
            if (expLevel.value.equalsIgnoreCase(value)) {
                return expLevel;
            }
        }
        throw new IllegalArgumentException("Unknown value in ExpLevel: " + value);
    }
}
