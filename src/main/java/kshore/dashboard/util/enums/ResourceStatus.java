package kshore.dashboard.util.enums;

public enum ResourceStatus {

    //enum values
    ALLOCATED("ALLOCATED"),
    NOT_ALLOCATED("NOT_ALLOCATED"),
    PENDING("PENDING");

    private String value;

    ResourceStatus(String value) {
        this.value = value;
    }

    //getter
    public String getValue() {
        return value;
    }

    //equals resource status value
    public static ResourceStatus fromValue(String value) {
        for (ResourceStatus resourceStatus : ResourceStatus.values()) {
            if (resourceStatus.value.equalsIgnoreCase(value)) {
                return resourceStatus;
            }
        }
        throw new IllegalArgumentException("Unknown value in ResourceStatus: " + value);
    }
}
