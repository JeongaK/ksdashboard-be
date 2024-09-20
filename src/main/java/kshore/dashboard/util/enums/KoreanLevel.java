package kshore.dashboard.util.enums;

public enum KoreanLevel {

    //enum values
    BEGINNER("BEGINNER"),
    INTERMEDIATE("INTERMEDIATE"),
    ADVANCED("ADVANCED"),
    PROFICIENT("PROFICIENT");

    private String value;

    KoreanLevel(String value) {
        this.value = value;
    }

    //getter
    public String getValue() {
        return value;
    }

    //equals resource status value
    public static KoreanLevel fromValue(String value) {
        for (KoreanLevel koreanLevel : KoreanLevel.values()) {
            if (koreanLevel.value.equalsIgnoreCase(value)) {
                return koreanLevel;
            }
        }
        throw new IllegalArgumentException("Unknown value in KoreanLevel: " + value);
    }
}
