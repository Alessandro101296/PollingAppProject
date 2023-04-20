package io.io.dto.Response;

public class ExceptionCode {
    private long exceptionCode;

    public ExceptionCode() {
    }

    public ExceptionCode(long exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public long getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(long exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
