package ml.mizotakhteh.util.web;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class HttpErrorInfo {
    public final ZonedDateTime timestamp;
    public final String path;
    public final HttpStatus httpStatus;
    public final String message;

    public HttpErrorInfo() {
        this.timestamp = null;
        this.path = null;
        this.httpStatus = null;
        this.message = null;
    }

    public HttpErrorInfo(HttpStatus httpStatus, String path, String message) {
        this.timestamp = ZonedDateTime.now();
        this.path = path;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
