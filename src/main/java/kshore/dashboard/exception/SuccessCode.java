package kshore.dashboard.exception;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    EXAMPLE_SUCCESS(OK, "예시 성공"),
    GET_SUCCESS(OK, "조회 성공"),
    CREATE_SUCCESS(CREATED, "생성 성공"),
    UPDATE_SUCCESS(OK, "수정 성공"),
    DELETE_SUCCESS(OK, "삭제 성공");

    private final HttpStatus status;
    private final String message;

}
