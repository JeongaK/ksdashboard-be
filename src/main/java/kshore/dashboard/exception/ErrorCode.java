package kshore.dashboard.exception;

import static org.springframework.http.HttpStatus.*;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_CLIENT_REQUEST(BAD_REQUEST, "잘못된 요청 입니다."),
    DATA_NOT_FOUND(NOT_FOUND, "데이터를 찾을 수 없습니다."),
    CONFLICT_DATA(CONFLICT, "중복된 데이터 입니다."),
    SERVER_ERROR(INTERNAL_SERVER_ERROR, "서버 내부 오류로 인해 응답을 제공할 수 없습니다."),
    BAD_HTTP_REQUEST(BAD_REQUEST, "HTTP 요청 읽기에 실패했습니다.");

    private final HttpStatus status;
    private final String message;
}
