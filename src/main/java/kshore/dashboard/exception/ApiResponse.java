package kshore.dashboard.exception;

import lombok.Getter;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;
    private ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ResponseEntity<?> success(SuccessCode code) {
        return ResponseEntity.status(code.getStatus().value())
                .body(new ApiResponse<>(code.getStatus().value(), code.getMessage()));
    }

    public static <T> ResponseEntity<?> success(SuccessCode code, T data) {
        return ResponseEntity.status(code.getStatus().value())
                .body(new ApiResponse<>(code.getStatus().value(), code.getMessage(), data));
    }

    public static <T> ResponseEntity<?> success(SuccessCode code, T data, Map<String, String> header) {
        HttpHeaders headers = new HttpHeaders();
        header.forEach(headers::add);
        return new ResponseEntity<>(new ApiResponse<>(code.getStatus().value(), code.getMessage(), data), headers,
                code.getStatus());
    }

    public static ResponseEntity<?> error(ErrorCode code) {
        return ResponseEntity.status(code.getStatus().value())
                .body(new ApiResponse<>(code.getStatus().value(), code.getMessage()));
    }

    public static ResponseEntity<?> error(ErrorCode code, String message) {
        return ResponseEntity.status(code.getStatus().value())
                .body(new ApiResponse<>(code.getStatus().value(), "[" + code.getMessage() + "]" + message));
    }

    public static ResponseEntity<?> error(HttpStatus status, String message) {
        return ResponseEntity.status(status.value()).body(new ApiResponse<>(status.value(), message));
    }
}
